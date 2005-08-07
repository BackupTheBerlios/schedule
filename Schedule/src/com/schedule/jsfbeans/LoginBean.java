/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.CryptoManager;
import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Login;
import com.schedule.hibernate.User;


/**
 * @author Christian Sukale
 *
 */
public class LoginBean {
	
    /** The value of the simple screenname property. */
    private java.lang.String screenname;

    /** The value of the simple passwort property. */
    private java.lang.String password;

    /** The value of the simple active property. */
    private java.lang.Boolean active;
    
    /**
     * Simple constructor of Login instances.
     */
    public LoginBean()
    {
    }

    /**
     * Method for identifying a user
     * @return
     */
    public String loginUser()
    {
    		Session sess = HibernateManager.getSession();
    		Query q;
    		Login login = null;
    		User user = null;
    		
		try {
			q = sess.createQuery("from Login where screenname= :screenname and passwort= :password");
			q.setString("screenname", this.screenname);
			q.setString("password", CryptoManager.getDigest(this.getPassword(), "SHA-1"));
			login = (Login) q.uniqueResult();
			
			// Wenn der Login erfolgreich ist dann hole das zum Login gehörenden User-Objekt
			// schreibe anschließend Login- und User-ID in die Http Session
		
			if (login != null) 
			{
				try {
					user = (User) sess.createQuery("from User where idLogin= :idLogin")
					.setString("idLogin", login.getIdLogin().toString())
					.uniqueResult();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				session.setAttribute("LoginID", login.getIdLogin());
				session.setAttribute("UserID", user.getIdUser());
				HibernateManager.closeSession();
				return "usersuccess";
			} else {
				FacesContext facesContext = FacesContext.getCurrentInstance(); 
	    		FacesMessage facesMessage = new FacesMessage("Unkorrekte Logindaten!");
	    		facesContext.addMessage("loginForm", facesMessage);        
	    		return "failure";
			}
				
		} catch (HibernateException e) {
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
    		FacesMessage facesMessage = new FacesMessage("Fehler beim Loginvorgang!");
    		facesContext.addMessage("loginForm", facesMessage);        
    		return "failure";
		}
		
    }
    
    /**
     * 
     * @return
     */
    public String logoutUser()
    {
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		
    	return "logoutsuccess";
    }

	/**
	 * @return Returns the activestatus.
	 */
	public java.lang.Boolean getActive() {
		return active;
	}
	/**
	 * @param active Sets the active property.
	 */
	public void setActive(java.lang.Boolean active) {
		this.active = active;
	}
	/**
	 * @return Returns the passwort.
	 */
	public java.lang.String getPassword() {
		return password;
	}
	/**
	 * @param passwort The passwort to set.
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	/**
	 * @return Returns the screenname.
	 */
	public java.lang.String getScreenname() {
		return screenname;
	}
	/**
	 * @param screenname The screenname to set.
	 */
	public void setScreenname(java.lang.String screenname) {
		this.screenname = screenname;
	}
}

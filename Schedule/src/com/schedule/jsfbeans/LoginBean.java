/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.CryptoManager;
import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Login;


/**
 * @author reinhard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
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
    
    public String logoutUser()
    {
    		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		
    		return "logoutsuccess";
    }

    /**
     * Method for identifying a user
     * @return
     */
    public String loginUser()
    {
    		Session sess = HibernateManager.getSession();
    		Query q;
    		List logins;
    		
		try {
			q = sess.createQuery("from Login where screenname= :screenname and passwort= :password");
			q.setString("screenname", this.screenname);
			q.setString("password", CryptoManager.getDigest(this.getPassword(), "SHA-1"));
			logins = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
			return "failure";
		}
		
		List users = null;
		try {
			q = sess.createQuery("from User where idLogin= :idLogin");
			q.setString("idLogin", ( (Login) logins.get(0) ).getIdLogin().toString());
			users = (List) q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		if(logins.size()==1)
		{
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("Login", logins.get(0));
			session.setAttribute("User", users.get(0));
			return "usersuccess";
		} else {
    		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    		FacesMessage facesMessage = new FacesMessage("Unkorrekte Logindaten!");
    		facesContext.addMessage("loginForm", facesMessage);        
    		return "failure";
		}
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

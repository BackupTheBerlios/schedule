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

import net.sf.hibernate.*;

import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Login;
import com.schedule.hibernate.User;


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

    /**
     * Method for identifying a user
     * @return
     */
    public String loginUser()
    {
    		Session sess = HibernateManager.getSession();
    		List logins;
		try {
			// Hier mit where klausel, damit das performanter wird, dann
			// kšnnen wir im Anschluss einfach gucken, ob es ein Resultat gibt
			// wenn nicht, dann ist login/password falsch
			logins = (List) sess.createQuery("from Login").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return "failure";
		}
		
		// Performance killer! 
		for(int i=0; i<logins.size(); i++)
		{
			Login temp = (Login)logins.get(i);
			if( temp.getScreenname().equals(this.getScreenname()) && temp.getPasswort().equals(this.getPassword()))
			{
				return "success";
			}
		}
    		
    		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    		FacesMessage facesMessage = new FacesMessage("Unkorrekte Logindaten!");
    		facesContext.addMessage("loginForm", facesMessage);        
    		return "failure";
    }
    
    /**
     * Method for registering a new login for a user
     * @return
     */
    public String registerLogin()
    {
    		if(this.getScreenname()!=null && this.getPassword()!=null)
    		{		
    			Session hbmsession = HibernateManager.getSession();
    			HibernateManager.beginTransaction();
	    	
			Login hbmlogin = new Login();
			hbmlogin.setPasswort(this.password);
			hbmlogin.setScreenname(this.screenname);
			try {
				hbmsession.saveOrUpdate(hbmlogin);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			HibernateManager.commitTransaction();
			try {
				hbmsession.flush();
			} catch (HibernateException e1) {
				e1.printStackTrace();
			}
    			
    			
    			return "success";
    		}
    		
    		// If something went wrong (screenname already exists, password insecure,
    		// user already registered...) registration will fail
    		return "failure";
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

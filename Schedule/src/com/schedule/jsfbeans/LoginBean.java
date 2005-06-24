/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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

    public String loginUser()
    {
    		if(this.getScreenname().equals("testuser") && this.getPassword().equals("password"))
    		{
    			return "usersuccess";
    		}
    		
    		if(this.getScreenname().equals("admin") && this.getPassword().equals("adminpass"))
		{
    			return "adminsuccess";
		}
    		
    		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    		FacesMessage facesMessage = new FacesMessage("Unkorrekte Logindaten!");
    		facesContext.addMessage("loginForm", facesMessage);        
    		return "failure";
    }
    
    public String registerLogin()
    {
    		if(this.getScreenname()!=null && this.getPassword()!=null)
    		{
    			return "success";
    		}
    		
    		// If something went wrong (screenname already exists, password insecure, user already registered...)
    		// registration will fail
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

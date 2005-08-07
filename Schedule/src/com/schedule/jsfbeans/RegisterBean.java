/*
 * Created on 27.06.2005
 *
 */
package com.schedule.jsfbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.CryptoManager;
import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Login;
import com.schedule.hibernate.Roles;
import com.schedule.hibernate.User;

/**
 * @author Andreas Pursian
 *
 */
public class RegisterBean {

	/** The value of the simple screenname property. */
    private java.lang.String screenname;

    /** The value of the simple passwort property. */
    private java.lang.String password;

    /** The value of the simple active property. */
    private java.lang.Boolean active;
    
    /** The value of the simple lastname property. */
    private java.lang.String lastname;

    /** The value of the simple firstname property. */
    private java.lang.String firstname;

    /** The value of the simple title property. */
    private java.lang.String title;

    /** The value of the simple email property. */
    private java.lang.String email;

    /** The value of the simple phone property. */
    private java.lang.String phone;

    /** The value of the simple street property. */
    private java.lang.String street;

    /** The value of the simple city property. */
    private java.lang.String city;

    /** The value of the simple zip property. */
    private java.lang.Integer zip;
    
    
    /**
     * Registers a new user with the system
     * @return "success" or "failure"
     */
    public String register()
    {
		Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		
		Query q;
		List roles=null;
		
		try {
			q = hbmsession.createQuery("from Roles where name= :name");
			q.setString("name", "user");
			roles = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		if(roles == null || roles.size()==0)
		{
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Systemuser Rolle konnte nicht zugeordnet werden");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failure";
		}
		
		Roles hbmrole = (Roles) roles.get(0);
	
		Login hbmlogin = new Login();
		hbmlogin.setPasswort(CryptoManager.getDigest(this.password, "SHA-1"));
		hbmlogin.setScreenname(this.screenname);
		hbmlogin.setActive(new Byte("1"));
		
		User hbmuser = new User();
		hbmuser.setFirstname(this.firstname);
		hbmuser.setLastname(this.lastname);
		hbmuser.setTitle(this.title);
		hbmuser.setPhone(this.phone);
		hbmuser.setEmail(this.email);
		hbmuser.setCity(this.city);
		hbmuser.setStreet(this.street);
		hbmuser.setZip(this.zip);
		hbmuser.setLogin(hbmlogin);
		hbmuser.setRole(hbmrole);
		
	
		try {
			hbmsession.saveOrUpdate(hbmlogin);
			hbmsession.saveOrUpdate(hbmuser);	
		} catch (HibernateException e) {
			e.printStackTrace();
			
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Sichern der Daten fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage); 
			
			return "failure";
		}
		HibernateManager.commitTransaction();
		try {
			hbmsession.flush();
		} catch (HibernateException e1) {
			e1.printStackTrace();
			
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failure";
		}
		HibernateManager.closeSession();
		return "success";
    }
	
	
	/**
	 * @return Returns the active.
	 */
	public java.lang.Boolean getActive() {
		return active;
	}
	/**
	 * @param active The active to set.
	 */
	public void setActive(java.lang.Boolean active) {
		this.active = active;
	}
	/**
	 * @return Returns the city.
	 */
	public java.lang.String getCity() {
		return city;
	}
	/**
	 * @param city The city to set.
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	/**
	 * @return Returns the email.
	 */
	public java.lang.String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	/**
	 * @return Returns the firstname.
	 */
	public java.lang.String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname The firstname to set.
	 */
	public void setFirstname(java.lang.String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return Returns the lastname.
	 */
	public java.lang.String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname The lastname to set.
	 */
	public void setLastname(java.lang.String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return Returns the password.
	 */
	public java.lang.String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	/**
	 * @return Returns the phone.
	 */
	public java.lang.String getPhone() {
		return phone;
	}
	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
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
	/**
	 * @return Returns the street.
	 */
	public java.lang.String getStreet() {
		return street;
	}
	/**
	 * @param street The street to set.
	 */
	public void setStreet(java.lang.String street) {
		this.street = street;
	}
	/**
	 * @return Returns the title.
	 */
	public java.lang.String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	/**
	 * @return Returns the zip.
	 */
	public java.lang.Integer getZip() {
		return zip;
	}
	/**
	 * @param zip The zip to set.
	 */
	public void setZip(java.lang.Integer zip) {
		this.zip = zip;
	}
}

/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.*;
import javax.servlet.http.*;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import com.schedule.hibernate.*;

/**
 * @author reinhard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AppointmentBean {
	
	/** The value of the simple subject property. */
    private java.lang.String subject;
    
    /** */
    private String tmpCurrProj;
    
    /** */
    private Integer currProj;

    /** The value of the simple date property. */
    private java.util.Date date;

    /** The value of the simple description property. */
    private java.lang.String description;

    /** The user associated with this appointment */
    private User user;

    /** List of all Appointments assigned to the current User */
    private Vector appointmentsList;
    
    /** Number of appointments assigned to the current User */
    private int appointmentCount;
    
    /**
     * 
     * Standardkonstruktur
     */
    public AppointmentBean()
    {
   /* 	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	user = (User) session.getAttribute("User");*/
    	
    	appointmentCount = 0;
    	this.getAppointmentsList();
   
    }
    
    /**
	 * @return Returns the currProj.
	 */
	public Integer getCurrProj() {
		return currProj;
	}
	
    /**
	 * @return Returns the tmpCurrProj.
	 */
	public String getTmpCurrProj() 
	{
		return tmpCurrProj;
	}
	
	/**
	 * @param tmpCurrProj The tmpCurrProj to set.
	 */
	public void setTmpCurrProj(String tmpCurrProj) 
	{
		this.tmpCurrProj = tmpCurrProj;
		
		this.currProj = Integer.decode(tmpCurrProj);
		
		//this.currProj = i.intValue();
	}

	/**
	 * @return Returns the date.
	 */
	public java.util.Date getDate() {
		return date;
	}
	/**
	 * @param date The date to set.
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	/**
	 * @return Returns the description.
	 */
	public java.lang.String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	/**
	 * @return Returns the subject.
	 */
	public java.lang.String getSubject() {
		return subject;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}
	
	/**
	 * Returns a list of all appointments assigned to the current user
	 * @return
	 */
	public Vector getAppointmentsList()
	{
		User user = this.getUser();
		Set appointments = user.getAppointments();
		appointmentsList = new Vector();
		
		for(int i=0; i<appointments.size(); i++)
		{
			appointmentsList.add(appointments.toArray()[i]);
		}
		
		appointmentCount = appointmentsList.size();
		
		return appointmentsList;
		
	}
	
	/**
	 * Sets the list of appointments for the current user
	 * @param aAppointmentsList
	 */
	public void setAppointmentsList(Vector aAppointmentsList)
	{
		appointmentsList = aAppointmentsList;
	}
	
	/**
	 * Returns the number of appointments assigned to the current user
	 * @return
	 */
	public int getAppointmentCount()
	{
		return appointmentCount;
	}
	
	/**
	 * Sets the number of appointments for the current user
	 * @param aAppointmentCount
	 */
	public void setAppointmentCount(int aAppointmentCount)
	{
		appointmentCount = aAppointmentCount;
	}
	
	public void resetObjectAttributes(){
		this.subject = null;
		this.appointmentCount = 0;
		this.appointmentsList = null;
		this.currProj = null;
		this.date = null;
		this.description = null;
		this.tmpCurrProj = null;
		this.user = null;
		
	}
	
	public String addAppointment()
    {
    	User user = null;
    	Projects project = null;
    	Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		
		// aktuellen User holen
		user = this.getUser();
		// im Drop-Down-Field ausgewähltes Projekt laden	
		try {
			project = (Projects) hbmsession.load(Projects.class, this.currProj);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// neues Task-Objekt erstellen
		Appointments newAppoint = new Appointments();
		newAppoint.setSubject(this.subject);
		newAppoint.setDescription(this.description);
		newAppoint.setDate(this.date);
		newAppoint.setUser(user);
		newAppoint.setProject(project);
		
		//associate appointment to a user
		user.getAppointments().add(newAppoint);
		//associate appointment with project
		project.getAppointments().add(newAppoint);
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(newAppoint);
			hbmsession.saveOrUpdate(user);
			hbmsession.saveOrUpdate(project);
			hbmsession.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failure";
		}
		HibernateManager.commitTransaction();
		HibernateManager.closeSession();
		//resetObjectAttributes();
		return "successAddAppoint";
    	
    }
	/**
	 * @return Returns the user.
	 */
	public User getUser() 
	{
		User user = null;
		Session hbmsession = HibernateManager.getSession();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    		Integer userId = (Integer) session.getAttribute("UserID");
    	try {
    		user = (User) hbmsession.load(User.class, userId);
    	} catch (HibernateException e) {
    		e.printStackTrace();
    	}
		return user;
	}
	
}

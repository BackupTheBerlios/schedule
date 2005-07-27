/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.*;

import javax.faces.context.*;
import javax.servlet.http.*;

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
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	user = (User) session.getAttribute("User");
    	this.getAppointmentsList();		//zum Initialisieren des Counters
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
}

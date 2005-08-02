/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.*;

import javax.servlet.http.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.*;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import com.schedule.hibernate.*;

/**
 * @author reinhard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TaskBean {
	
	/** The value of the simple subject property. */
    private java.lang.String subject;
    
    /** Description of a task */
    private java.lang.String description;

	
    /** The value of the simple pid property. */
    private java.lang.Integer pid;

    /** The value of the simple solved property. */
    private java.lang.Float solved;

    /** The value of the simple tid1 property. */
    private java.lang.Integer partOfTID;

    /** The User associated with this Task */
    private User user;
    
    /** List of all tasks assigned to the current user */
    private Vector tasksList;
    
    /** Number of tasks assigned to the current user */
    private int taskCount;
    
    public TaskBean() {
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	user = (User) session.getAttribute("User");
    	this.getTasksList();	// zum Initialiseren des Counters
    }
    
    
    public String addTask()	{
    	
    	Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		Projects tempProject = new Projects();
		
		Tasks newTask = new Tasks();
		newTask.setSubject(this.subject);
		newTask.setDescription(this.description);
		tempProject.setIdProjects(this.pid);
		newTask.setProject(tempProject);
		
		
		//Get User from Session
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User u = (User) session.getAttribute("User");
		newTask.setUser(u);
		//associate project to a user 
		u.getTasks().add(newTask);
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(newTask);
			hbmsession.saveOrUpdate(u);
		} catch (HibernateException e) {
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failure";
		}
		
		HibernateManager.commitTransaction();
	
    	
    	
    	return "successAdd";
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
	 * @return Returns the user.
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}
    
    
	/**
	 * @return Returns the pid.
	 */
	public java.lang.Integer getPid() {
		return pid;
	}
	/**
	 * @param pid The pid to set.
	 */
	public void setPid(java.lang.Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return Returns the solved.
	 */
	public java.lang.Float getSolved() {
		return solved;
	}
	/**
	 * @param solved The solved to set.
	 */
	public void setSolved(java.lang.Float solved) {
		this.solved = solved;
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
	 * @return Returns the tid1.
	 */
	public java.lang.Integer getPartOfTID() {
		return partOfTID;
	}
	/**
	 * @param tid1 The tid1 to set.
	 */
	public void setPartOfTID(java.lang.Integer partOfTID) {
		this.partOfTID = partOfTID;
	}
	
	/**
	 * Returns a list of tasks assigned to the user
	 * @return
	 */
	public Vector getTasksList()
	{
		Set tasks = user.getTasks();
		tasksList = new Vector();
		
		for (int i=0; i<tasks.size(); i++)
		{
			tasksList.add(tasks.toArray()[i]);
		}
		
		taskCount = tasksList.size();
		
		return tasksList;
	}
	
	/**
	 * Sets a list of tasks for the user
	 * @param aTasksList
	 */
	public void setTasksList(Vector aTasksList)
	{
		tasksList = aTasksList;
	}
	
	/**
	 * Returns the number of tasks assigned to the user
	 * @return
	 */
	public int getTaskCount()
	{
		return taskCount;
	}
	
	/**
	 * Sets the number of tasks assigned to the user
	 * @param aTaskCount
	 */
	public void setTaskCount(int aTaskCount)
	{
		taskCount = aTaskCount;
	}
}

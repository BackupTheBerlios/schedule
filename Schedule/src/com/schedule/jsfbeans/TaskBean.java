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
    
    /** */
    private String tmpCurrProj;
 
    /** */
    private Integer currProj;

    /** Description of a task */
    private java.lang.String description;

    /** The value of the simple solved property. */
    private java.lang.Float solved;
   
    /** List of all tasks assigned to the current user */
    private Vector tasksList;
    
    /** Number of tasks assigned to the current user */
    private int taskCount;
    
    /**
     * 
     * Standardkonstruktor
     */
    public TaskBean() 
    {
    	taskCount = 0;
    	this.getTasksList();	// zum Initialiseren des Counters
    }
    
    /** Reset all attributes */
    public void resetObjectAttributes(){
    		this.subject = null;
    		this.tmpCurrProj = null;
    		this.currProj = null;
    		this.description = null;
    		this.solved = null;
    		this.tasksList = null;
    		this.taskCount = 0;
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
	 * 
	 * @return
	 */
    public String addTask()
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
		Tasks newTask = new Tasks();
		newTask.setSubject(this.subject);
		newTask.setDescription(this.description);
		newTask.setSolved(new Float(0.0));
		newTask.setUser(user);
		newTask.setProject(project);
		
		//associate task to a user 
		user.getTasks().add(newTask);
		//associate task with project
		project.getTasks().add(newTask);
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(newTask);
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
		resetObjectAttributes();
		return "successAddTask";
    	
    }
	/**
	 * @return Returns the currProj.
	 */
	public Integer getCurrProj() {
		return currProj;
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
	
	/**
	 * @return Returns the solved.
	 */
	public java.lang.Float getSolved() 
	{
		return solved;
	}
	
	/**
	 * @param solved The solved to set.
	 */
	public void setSolved(java.lang.Float solved) 
	{
		this.solved = solved;
	}
	
	/**
	 * @return Returns the subject.
	 */
	public java.lang.String getSubject() 
	{
		return subject;
	}
	
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(java.lang.String subject) 
	{
		this.subject = subject;
	}

	/**
	 * Returns a list of tasks assigned to the user
	 * @return
	 */
	public Vector getTasksList()
	{
		User user = this.getUser();
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

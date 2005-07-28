/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.faces.application.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.schedule.hibernate.*;

import net.sf.hibernate.*;

/**
 * @author reinhard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ProjectBean {
	
	/** The value of the simple name property. */
    private java.lang.String name;

    /** The value of the simple description property. */
    private java.lang.String description;
    
    /** The user associated with this Project*/
    private User user;
    
    /** List of all projects */
    private Vector projectList;    

    /** Amount of Projects assigned to the current User */
    private int projectCount;
    
    /**
     * Constructor
     *
     */
    public ProjectBean()
    {
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	user = (User) session.getAttribute("User");
		this.getProjectList();	
    }

    /**
     * Returns the current User
     * @return
     */
    public User getUser()
    {
    	return user;
    }
    
    /**
     * Sets the current User
     * @param aUser
     */
    public void setUser(User aUser)
    {
    	user = aUser;
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
	 * @return Returns the name.
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * @return Returns the projectList.
	 */
	public List getProjectList() {
		Set projects = user.getProjects();
		projectList = new Vector();
		
		for(int i=0; i<projects.size(); i++)
		{
			this.projectList.add(projects.toArray()[i]);
		}
		
		projectCount = projectList.size(); 
		
		return projectList;
	}

	/**
	 * @param projectList The projectList to set.
	 */
	public void setProjectList(Vector projectList) {
		this.projectList = projectList;
	}
	
	/**
	 * Returns the amount of projects assigned to the current user
	 * @return
	 */
	public int getProjectCount()
	{
		return projectCount;
	}
	
	/**
	 * Sets the number of projects assigned to the current user
	 * @param aProjectCount
	 */
	public void setProjectCount(int aProjectCount)
	{
		projectCount = aProjectCount;
	}
	
	/**
     * Adds a new Project
     */ 
    public String addProject()
    {
    	Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		
		Projects newProject = new Projects();
		newProject.setName(this.name);
		newProject.setDescription(this.description);
		
		//Get User from Session
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User u = (User) session.getAttribute("User");
		newProject.getUsers().add(u);
		//associate project to a user 
		u.getProjects().add(newProject);
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(newProject);
			hbmsession.saveOrUpdate(u);
		} catch (HibernateException e) {
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failure";
		}
		
		HibernateManager.commitTransaction();
		return "success";
    }
}

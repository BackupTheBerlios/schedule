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

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.schedule.hibernate.User;

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
    
    /**
     * Primary key of the associated user
     */
    private Integer myUID;
    
    /**
     * List of all projects
     */
    private Vector projectList;    

    /**
     * Constructor
     *
     */
    public ProjectBean()
    {
    		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    		User u = (User) session.getAttribute("User");
		this.myUID = u.getIdUser();
		this.getProjects(u);
		
    }
    
    /**
     * Gets all projects from the database
     */
    public void getProjects(User u)
	{
    		Set projects = u.getProjects();
    		this.projectList = new Vector();
    		
    		for(int i=0; i<projects.size(); i++)
    		{
    			this.projectList.add(projects.toArray()[i]);
    		}
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
	 * @return Returns the myUID.
	 */
	public Integer getMyUID() {
		return myUID;
	}

	/**
	 * @param myUID The myUID to set.
	 */
	public void setMyUID(Integer myUID) {
		this.myUID = myUID;
	}

	/**
	 * @return Returns the projectList.
	 */
	public List getProjectList() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User u = (User) session.getAttribute("User");
		this.getProjects(u);
		return projectList;
	}

	/**
	 * @param projectList The projectList to set.
	 */
	public void setProjectList(Vector projectList) {
		this.projectList = projectList;
	}
}

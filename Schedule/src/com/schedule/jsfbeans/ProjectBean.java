/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Projects;
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
    
    /** List of all projects */
    private Vector projectList;    

    /** Amount of Projects assigned to the current User */
    private int projectCount;
    
    /** current Project which is chosen by ex.from Projects Overview*/
    private Projects currentProject;
   
    /**Name of the Project*/
    private String projectName;
    
    /** */
    private ArrayList projectListArray;

    
    /**
     * Constructor
     *
     */
    public ProjectBean()
    {	
    	projectCount = 0;
    	this.getProjectList();	
    }

    /**
     * Returns the current User
     * @return
     */
    public User getUser()
    {
    	User user = null;
    	Session hbmsession = HibernateManager.getSession();
    	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	Integer userId = (Integer) session.getAttribute("UserID");
		
    	//User-Objekt laden
		try {
			user = (User) hbmsession.load(User.class, userId);		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    	return user;
    }
    
    /**
	 * @return Returns the projectName.
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName The projectName to set.
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
		User user = this.getUser();
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
		Integer userId = (Integer) session.getAttribute("UserID");
		User user = this.getUser();
		//associate project to a user 
		user.getProjects().add(newProject);
		newProject.getUsers().add(user);
		
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(user);
			hbmsession.saveOrUpdate(newProject);
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
		return "successAdd";
    }
	/**
	 * @return Returns the currentProject.
	 */
	public Projects getCurrentProject() {
		//Get Values from Request at point "proj"
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		String aProjectsId = ((String) requestMap.get("proj"));
		
		//Create Session
		Session sess = HibernateManager.getSession();
		Query q;
		List projects = null;
		
		try {
			q = sess.createQuery("from Projects where idProjects= :idProjects");
			q.setString("idProjects", aProjectsId);
			//Write results from Query to projects
			projects = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//get the current Project
		Projects aProject = (Projects) projects.get(0);
		
		this.setCurrentProject(aProject);
		
		return currentProject;
	}
	/**
	 * @param currentProject The currentProject to set.
	 */
	public void setCurrentProject(Projects acurrentProject) {
		this.currentProject = acurrentProject;
	}
	
	/**
	 * @return Returns the projectListArray.
	 */
	public ArrayList getProjectListArray() 
	{
		User user = this.getUser();
		Set projects = user.getProjects();
		projectListArray = new ArrayList();
		
		for(int i=0; i<projects.size(); i++)
		{
			Projects newpo = (Projects) projects.toArray()[i];
			String neu = newpo.getName();
			String projctnr = newpo.getIdProjects().toString();
			
			this.projectListArray.add(new SelectItem(projctnr,neu,"desc")); //Value, Label
		}
		
		return projectListArray;
	}
	
	/**
	 * @param projectListArray The projectListArray to set.
	 */
	public void setProjectListArray(ArrayList projectListArray) {
		this.projectListArray = projectListArray;
	}

}

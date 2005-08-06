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
import net.sf.hibernate.Session;

import com.schedule.hibernate.Groups;
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
    
    /** List of all tasks assigned to the current Project */
    private List taskList;
    
    /** List of all appoinments assigned to the current Project */ 
    private List appointmentList;
    
    /** List of all Entries on the Blackboard assigned to the current Project */
    private List blackboardEntryList;
    
    /** List of all users assigned to the current Project */
    private List userList;
    
    /** Amount of Projects assigned to the current User */
    private int projectCount;
    
    /** Defines whether a request has a project ID or not */
    private boolean hasProject;
    
    /** current Project which is chosen by ex.from Projects Overview*/
    private Projects currentProject;
   
    /** Name of the Project*/
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
	 * @return Returns the taskList.
	 */
	public List getTaskList() 
	{	
		if (isHasProject())
		{
			Session hbmsession = HibernateManager.getSession();
			Projects project = this.getCurrentProject();	
			try {
				taskList = hbmsession.createFilter(project.getTasks(), "order by this.subject").list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return taskList;
		} else {
			return taskList;
		}
	}
	
	/**
	 * 
	 * @param aTaskList
	 */
	public void setTaskList(List aTaskList)
	{
		taskList = aTaskList;
	}
	
	/**
	 * @return Returns the appointmentList.
	 */
	public List getAppointmentList() 
	{	
		if (isHasProject())
		{
			Session hbmsession = HibernateManager.getSession();
			Projects project = this.getCurrentProject();	
			try {
				appointmentList = hbmsession.createFilter(project.getAppointments(), "order by this.subject").list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return appointmentList;
		} else {
			return appointmentList;
		}
	}
	
	/**
	 * 
	 * @param aAppointmentList
	 */
	public void setAppointmentList(List aAppointmentList)
	{
		taskList = aAppointmentList;
	}
	
	/**
	 * @return Returns the blackboardEntryList.
	 */
	public List getBlackboardEntryList() 
	{
		if (isHasProject())
		{
			Session hbmsession = HibernateManager.getSession();
			Projects project = this.getCurrentProject();	
			try {
				blackboardEntryList = hbmsession.createFilter(project.getBlackboardEntries(), "order by this.subject").list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return blackboardEntryList;
		} else {
			return blackboardEntryList;
		}
		
	}
	
	/**
	 * @param blackboardEntryList The blackboardEntryList to set.
	 */
	public void setBlackboardEntryList(List blackboardEntryList) {
		this.blackboardEntryList = blackboardEntryList;
	}
	
	/**
	 * @return Returns the userList.
	 */
	public List getUserList()
	{
		if (isHasProject())
		{
			Session hbmsession = HibernateManager.getSession();
			Projects project = this.getCurrentProject();
			try {
				userList = hbmsession.createFilter(project.getUsers(), "order by this.login.screenname").list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return userList;
		} else {
			return userList;
		}
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
//    	get User from Session
		User user = this.getUser();
		
		HibernateManager.beginTransaction();
		// create new Project
		Projects newProject = new Projects();
		newProject.setName(this.name);
		newProject.setDescription(this.description);
		newProject.setAdminId(user.getIdUser());
		
		//create new "default UserGroup" for new Project
		Groups defaultGroup = new Groups();
		defaultGroup.setName("default");
		defaultGroup.setDescription("Das ist die default Usergroup. Alle User des Projekts finden sie hier.");
		defaultGroup.getProjects().add(newProject);
		defaultGroup.getUser().add(user);
		
		//associate project to a user
		user.getGroups().add(defaultGroup);
		user.getProjects().add(newProject);
		newProject.getUsers().add(user);
		newProject.getGroups().add(defaultGroup);
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(user);
			hbmsession.saveOrUpdate(newProject);
			hbmsession.saveOrUpdate(defaultGroup);
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
	 * @return Returns the hasProject.
	 */
	public boolean isHasProject() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		if(requestMap.get("proj") != null)
		{
			hasProject = true;
		} else {
			hasProject = false;
		}
		return hasProject;
	}
	
	/**
	 * @param hasProject The hasProject to set.
	 */
	public void setHasProject(boolean hasProject) {
		this.hasProject = hasProject;
	}
    
	/**
	 * @return Returns the currentProject.
	 */
	public Projects getCurrentProject() {
		//Get Values from Request at point "proj"
		Projects project = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		Integer aProjectsId = new Integer((String) requestMap.get("proj"));
		
		//Create Session
		Session sess = HibernateManager.getSession();
		
		try {
			project = (Projects) sess.load(Projects.class, aProjectsId);			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		this.setCurrentProject(project);
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

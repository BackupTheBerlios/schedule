/*
 * 
 */
package com.schedule.jsfbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.lang.Integer;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import com.schedule.hibernate.Groups;
import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Projects;
import com.schedule.hibernate.User;

/**
 * @author Christian Sukale
 *
 */
public class ProjectBean {
	
	/** The value of the simple name property. */
    private java.lang.String name;

    /** The value of the simple description property. */
    private java.lang.String description;
    
    /** List of all projects */
    private List projectList;    
    
    /** List of all tasks assigned to the current Project */
    private List taskList;
    
    /** List of all appoinments assigned to the current Project */ 
    private List appointmentList;
    
    /** List of all Entries on the Blackboard assigned to the current Project */
    private List blackboardEntryList;
    
    /** List of all users assigned to the current Project */
    private List userList;
    
    /** List of all user groups which are to be found in this project */
    private List groupsList;
    
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

    /** determines if a user is project admin or not*/
    private boolean isAdmin;
    
    /** determines the project a admin user is allowed to add user*/
    private Projects addUserToProject;
    
    /** List of all exsisting users */
    private List allUserList;
    
    /** List of all exsisting users */
    private ArrayList allUserListArray;
    
    /** List of all users associated with the current project*/
    private ArrayList allProjectUserListArray;
    
    /** user which should be added to a project*/
    private String tempAddUser;
    
    
    
    /**
     * Constructor
     *
     */
    public ProjectBean()
    {	
    	projectCount = 0;
    	setIsAdmin(false);
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
	public List getProjectList() 
	{
		Session hbmsession = HibernateManager.getSession();
		User user = this.getUser();
		
		try {
			projectList = hbmsession.createFilter(user.getProjects(), "order by this.name").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		projectCount = projectList.size(); 
		
		return projectList;
	}

	/**
	 * @param projectList The projectList to set.
	 */
	public void setProjectList(List projectList) {
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
	 * @return Returns the blackboardEntryList.
	 */
	public List getGroupsList() 
	{
		if (isHasProject())
		{
			Session hbmsession = HibernateManager.getSession();
			Projects project = this.getCurrentProject();	
			try {
				groupsList = hbmsession.createFilter(project.getGroups(), "order by this.name").list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return groupsList;
		} else {
			return groupsList;
		}
		
	}
	
	/**
	 * @param blackboardEntryList The blackboardEntryList to set.
	 */
	public void setGroupsList(List groupsList) {
		this.groupsList = groupsList;
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
    	// get User from Session
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
	public Projects getCurrentProject() 
	{
		//Get Values from Request at point "proj"
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		Integer aProjectsId = new Integer((String) requestMap.get("proj"));
		
		
		//Create Session
		Session sess = HibernateManager.getSession();
		
		try {
			currentProject = (Projects) sess.load(Projects.class, aProjectsId);			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	Integer aUserId = (Integer) session.getAttribute("UserID");
		
		if (this.currentProject.getAdminId().equals(aUserId)) {
			setIsAdmin(true);
		} 	else {
				setIsAdmin(false);
			}
		return currentProject;
	}
	
	/**
	 * @param currentProject The currentProject to set.
	 */
	public void setCurrentProject(Projects acurrentProject) 
	{
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

	/**
	 * @return Returns the isAdmin.
	 */
	public boolean getIsAdmin() {
		return isAdmin;
	}
	/**
	 * @param isAdmin The isAdmin to set.
	 */
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * @return Returns the addUserToProject.
	 */
	public Projects getAddUserToProject() {
		return addUserToProject;
	}
	/**
	 * @param addUserToProject The addUserToProject to set.
	 */
	public void setAddUserToProject(Projects addUserToProject) {
		this.addUserToProject = addUserToProject;
	}
	/**
	 * set the current project to add user to.
	 */
	public void projectToAddUser(ActionEvent event) {
		
		setAddUserToProject(this.currentProject);
		
		
	}
	/**
	 * @return Returns the allUserList.
	 */
	public List getAllUserList() {
		
		Session hbmsession = HibernateManager.getSession();
		
		try {
			allUserList = hbmsession.createCriteria(User.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return allUserList;
	}
	/**
	 * @param allUserList The allUserList to set.
	 */
	public void setAllUserList(List allUserList) {
		this.allUserList = allUserList;
	}
	/**
	 * @return Returns the tempAddUser.
	 */
	public String getTempAddUser() {
		return tempAddUser;
	}
	/**
	 * @param tempAddUser The tempAddUser to set.
	 */
	public void setTempAddUser(String tempAddUser) {
		this.tempAddUser = tempAddUser;
	}
	/**
	 * @return Returns the allUserListArray.
	 */
	public ArrayList getAllUserListArray() {
		
		allUserList = this.getAllUserList();
		setAllUserList(allUserList);
		allUserListArray = new ArrayList();
		
		for (int i=0;i<allUserList.size();i++)	{
			User tmpUser = (User)allUserList.get(i);
			if (!addUserToProject.getUsers().contains(tmpUser))	{
				String tempUserString = new String((String)(tmpUser.getLastname() +", "+ tmpUser.getFirstname()));
				String tempUserId = new String((new Integer(i)).toString());
				this.allUserListArray.add(new SelectItem(tempUserId,tempUserString));
			}
			
		}
		return allUserListArray;
	}
	
	public ArrayList getAllProjectUserListArray() {
		
		allUserList = this.getAllUserList();
		setAllUserList(allUserList);
		allProjectUserListArray = new ArrayList();
		
		for (int i=0;i<allUserList.size();i++)	{
			User tmpUser = (User)allUserList.get(i);
			if (addUserToProject.getUsers().contains(tmpUser))	{
				String tempUserString = new String((String)(tmpUser.getLastname() +", "+ tmpUser.getFirstname()));
				String tempUserId = new String((new Integer(i)).toString());
				this.allProjectUserListArray.add(new SelectItem(tempUserId,tempUserString));
			}
			
		}
		return allProjectUserListArray;
	}
	
	
	
	/**
	 * @param allUserListArray The allUserListArray to set.
	 */
	public void setAllUserListArray(ArrayList allUserListArray) {
		this.allUserListArray = allUserListArray;
	}
	
	public String addUserToProjectTeam()	{
		String resultString = new String();
		Integer tempAddUserInt = new Integer(this.tempAddUser);
		User tempAddUser = (User)allUserList.get(tempAddUserInt.intValue());
		Projects tempAddProject = this.addUserToProject;
		
		Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		
		//associate project to user 
		tempAddUser.getProjects().add(tempAddProject);
		//associate user to project 
		tempAddProject.getUsers().add(tempAddUser);
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(tempAddProject);
			hbmsession.saveOrUpdate(tempAddUser);
			
			hbmsession.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failureAddUser";
		}
		HibernateManager.commitTransaction();
		HibernateManager.closeSession();
		tempAddUser = null;
		tempAddProject = null;
		return "successAddUser";
		
		
		
		
		
	}
	
	
	public String delUserFromProjectTeam() {
		
		Integer tempDelUserInt = new Integer(this.tempAddUser);
		User tempDelUser = (User)allUserList.get(tempDelUserInt.intValue());
		Projects tempDelProject = this.addUserToProject;
		
		Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		
		//del project to user 
		tempDelUser.getProjects().remove(tempDelProject);
		//del user to project 
		tempDelProject.getUsers().remove(tempDelUser);
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(tempDelProject);
			hbmsession.saveOrUpdate(tempDelUser);
			
			hbmsession.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failureDelUser";
		}
		HibernateManager.commitTransaction();
		HibernateManager.closeSession();
		tempDelUser = null;
		tempDelProject = null;
		return "successDelUser";
	}
	
	
	
}

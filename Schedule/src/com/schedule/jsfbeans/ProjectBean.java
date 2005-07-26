/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.HibernateManager;
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
    private List projectList;
    
    List up_association;
    
    
    public ProjectBean()
    {
    		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    		User u = (User) session.getAttribute("User");
		this.myUID = u.getIdUser();
    }
    
    /**
     * Gets all projects from the database
     */
    public void getProjects()
	{
		Session sess = HibernateManager.getSession();
		Query q;
		
		try {
			q = sess.createQuery("from UserProjects where idUser= :Userid");
			q.setString("Userid", this.myUID.toString());
			up_association = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		q=null;
		
		if(up_association.size()==0)
		{
			return;
		}
		
		List temp = null;
		for(int i=0; i<up_association.size(); i++)
		{
			try {
				q = sess.createQuery("from Projects where IdProjects= :ProjectID");
				q.setString("ProjectID", ((Integer) up_association.get(i)).toString());
				temp = q.list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			
			if(temp.size()!=0)
			{
				this.projectList.addAll(temp);
			}
			
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
		this.getProjects();
		return projectList;
	}

	/**
	 * @param projectList The projectList to set.
	 */
	public void setProjectList(List projectList) {
		this.projectList = projectList;
	}
}

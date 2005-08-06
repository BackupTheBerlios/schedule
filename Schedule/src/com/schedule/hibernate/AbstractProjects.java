/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 22:00:30 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the Projects table. 
 * You can customize the behavior of this class by editing the class, {@link Projects()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractProjects 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer idProjects;
    
    /** The value of the simple name property. */
    private java.lang.String name;

    /** The value of the simple description property. */
    private java.lang.String description;

    /** Id of User who created this project */
    private java.lang.Integer adminId;
    
    /** Die aktuellen User, die dieses Projekt bearbeiten */
    private java.util.Set users;
    
    /** Eine Liste alle User-Gruppen dieses Projektes */
    private java.util.Set groups;
    
    /** Alle Blackboard-Entries zu diesem Projekt */
    private java.util.Set blackboardEntries; 
    
    /** Alle Tasks die zu diesem Projekt geh�ren */
    private java.util.Set tasks;
    
    /** Alle Appointments zu diesem Projekt */
    private java.util.Set appointments;
    
    /**
     * Simple constructor of AbstractProjects instances.
     */
    public AbstractProjects()
    {
    	users = new java.util.HashSet();
    	groups = new java.util.HashSet();
    	blackboardEntries = new java.util.HashSet();
    	tasks = new java.util.HashSet();
    	appointments = new java.util.HashSet();
    }

    /**
     * Constructor of AbstractProjects instances given a simple primary key.
     * @param pid
     */
    public AbstractProjects(java.lang.Integer idProjects)
    {
        this.setIdProjects(idProjects);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getIdProjects()
    {
        return idProjects;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param idProjects
     */
    public void setIdProjects(java.lang.Integer idProjects)
    {
        this.hashValue = 0;
        this.idProjects = idProjects;
    }
        
    /**
     * Return the value of the Name column.
     * @return java.lang.String
     */
    public java.lang.String getName()
    {
        return this.name;
    }

    /**
     * Set the value of the Name column.
     * @param name
     */
    public void setName(java.lang.String name)
    {
        this.name = name;
    }

    /**
     * Return the value of the Description column.
     * @return java.lang.String
     */
    public java.lang.String getDescription()
    {
        return this.description;
    }

    /**
     * Set the value of the Description column.
     * @param description
     */
    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }

    /**
	 * @return Returns the adminId.
	 */
	public java.lang.Integer getAdminId() {
		return adminId;
	}
	
	/**
	 * @param adminId The adminId to set.
	 */
	public void setAdminId(java.lang.Integer adminId) {
		this.adminId = adminId;
	}
    
    /**
     * liefert die User zur�ck, die dieses Projekt bearbeiten
     * @return java.util.Set users
     */
    public java.util.Set getUsers()
    {
    	return users;
    }
    
    /**
     * setzt die User, die dieses Projekt bearbeiten
     * @param users
     */
    public void setUsers(java.util.Set users)
    {
    	this.users = users;
    }
    
	/**
	 * liefert alle User-Gruppen zur�ck, die zu diesem Projekt geh�ren
	 * @return Returns the groups.
	 */
	public java.util.Set getGroups() {
		return groups;
	}
	
	/**
	 * setzt die User-Gruppen f�r dieses Projekt
	 * @param groups The groups to set.
	 */
	public void setGroups(java.util.Set groups) {
		this.groups = groups;
	}
	
    /**
     * liefert die User zur�ck, die dieses Projekt bearbeiten
     * @return java.util.Set users
     */
    public java.util.Set getBlackboardEntries()
    {
    	return blackboardEntries;
    }
    
    /**
     * setzt die User, die dieses Projekt bearbeiten
     * @param users
     */
    public void setBlackboardEntries(java.util.Set blackboardEntries)
    {
    	this.blackboardEntries = blackboardEntries;
    }
    
    /**
	 * @return Returns the tasks.
	 */
	public java.util.Set getTasks() {
		return tasks;
	}
	
	/**
	 * @param tasks The tasks to set.
	 */
	public void setTasks(java.util.Set tasks) {
		this.tasks = tasks;
	}
    
    /**
	 * @return Returns the appointments.
	 */
	public java.util.Set getAppointments() {
		return appointments;
	}
	
	/**
	 * @param appointments The appointments to set.
	 */
	public void setAppointments(java.util.Set appointments) {
		this.appointments = appointments;
	}
	
    
    /**
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof Projects))
            return false;
        Projects that = (Projects) rhs;
        if (this.getIdProjects() != null && that.getIdProjects() != null)
        {
            if (! this.getIdProjects().equals(that.getIdProjects()))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation of the hashCode method conforming to the Bloch pattern with
     * the exception of array properties (these are very unlikely primary key types).
     * @return int
     */
    public int hashCode()
    {
        if (this.hashValue == 0)
        {
            int result = 17;
            int pidValue = this.getIdProjects() == null ? 0 : this.getIdProjects().hashCode();
            result = result * 37 + pidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
	
}

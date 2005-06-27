/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 22:00:30 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;
import java.util.Set;

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

    /** Wert des Foreign Keys "Tasks" */
    private java.lang.Integer idTasks;
    
    /** Wert des Foreign Keys "Blackboard */
    private java.lang.Integer idBlackboard;
    
    /** The value of the simple name property. */
    private java.lang.String name;

    /** The value of the simple description property. */
    private java.lang.String description;

    /** Die aktuellen User, die dieses Projekt bearbeiten */
    private Set users;
    
    /**
     * Simple constructor of AbstractProjects instances.
     */
    public AbstractProjects()
    {
    	users = new java.util.HashSet();
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
     * Liefert den Wert f�r den Foreign Key "Tasks" zur�ck
     * @return java.lang.Integer
     */
    public java.lang.Integer getIdTasks()
    {
        return idTasks;
    }

    /**
     * Setzt den Wert f�r den Foreign Key "Tasks"
     * @param idTasks
     */
    public void setIdTasks(java.lang.Integer idTasks)
    {
        this.idTasks = idTasks;
    }

    /**
     * Liefert den Wert f�r den Foreign Key "Blackboard" zur�ck
     * @return java.lang.Integer
     */
    public java.lang.Integer getIdBlackboard()
    {
        return idBlackboard;
    }

    /**
     * Setzt den Wert f�r den Foreign Key "Blackboard"
     * @param idBlackboard
     */
    public void setIdBlackboard(java.lang.Integer idBlackboard)
    {
        this.idBlackboard = idBlackboard;
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
     * liefert die User zur�ck, die dieses Projekt bearbeiten
     * @return java.util.Set users
     */
    public Set getUsers()
    {
    	return users;
    }
    
    /**
     * setzt die User, die dieses Projekt bearbeiten
     * @param users
     */
    public void setUsers(Set users)
    {
    	this.users = users;
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

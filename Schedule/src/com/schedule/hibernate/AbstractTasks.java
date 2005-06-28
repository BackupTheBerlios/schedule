/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 22:00:51 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the Tasks table. 
 * You can customize the behavior of this class by editing the class, {@link Tasks()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractTasks 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer idTasks;

    /** The value of the simple subject property. */
    private java.lang.String subject;
    
    /** Zur genauen Beschreibung der Aufgabe */
    private java.lang.String description;

    /** The value of the simple solved property. */
    private java.lang.Float solved;

    /** Das Projekt zu dem diese Aufgabe geh�rt */ 
    private Projects project;
    
    /** User dem diese Aufgabe zugeteilt ist */
    private User user;
   
    /**
     * Simple constructor of AbstractTasks instances.
     */
    public AbstractTasks()
    {
    }

    /**
     * Constructor of AbstractTasks instances given a simple primary key.
     * @param tid
     */
    public AbstractTasks(java.lang.Integer idTasks)
    {
        this.setIdTasks(idTasks);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getIdTasks()
    {
        return idTasks;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param idTasks
     */
    public void setIdTasks(java.lang.Integer idTasks)
    {
        this.hashValue = 0;
        this.idTasks = idTasks;
    }

    /**
     * Return the value of the Subject column.
     * @return java.lang.String
     */
    public java.lang.String getSubject()
    {
        return this.subject;
    }

    /**
     * Set the value of the Subject column.
     * @param subject
     */
    public void setSubject(java.lang.String subject)
    {
        this.subject = subject;
    }

    /**
     * liefert die Beschreibung zu dieser Aufgabe zur�ck
     * @return java.lang.String description
     */
    public java.lang.String getDescription()
    {
    	return description;
    }
    
    /**
     * setzt die Beschreibung dieser Aufgabe
     * @param description
     */
    public void setDescription(java.lang.String description)
    {
    	this.description = description;
    }
    
    /**
     * Return the value of the Solved column.
     * @return java.lang.Float
     */
    public java.lang.Float getSolved()
    {
        return this.solved;
    }

    /**
     * Set the value of the Solved column.
     * @param solved
     */
    public void setSolved(java.lang.Float solved)
    {
        this.solved = solved;
    }
    
    /**
     * liefert denjenigen User zur�ck, dem diese Aufgabe zugeteilt ist
     * @return User user
     */
    public User getUser()
    {
    	return user;
    }

    /**
     * setzt den User, dem diese Aufgabe zugeteilt werden soll
     * @param user
     */
    public void setUser(User user)
    {
    	this.user = user;
    }
    
    /**
     * liefert das Projekt zur�ck, zu dem diese Aufgabe geh�rt
     * @return Projects project
     */
    public Projects getProject()
    {
    	return project;
    }
    
    /**
     * setzt das Projekt, zu dem diese Aufgabe geh�rt
     * @param project
     */ 
    public void setProject(Projects project)
    {
    	this.project = project;
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
        if (! (rhs instanceof Tasks))
            return false;
        Tasks that = (Tasks) rhs;
        if (this.getIdTasks() != null && that.getIdTasks() != null)
        {
            if (! this.getIdTasks().equals(that.getIdTasks()))
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
            int tidValue = this.getIdTasks() == null ? 0 : this.getIdTasks().hashCode();
            result = result * 37 + tidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}

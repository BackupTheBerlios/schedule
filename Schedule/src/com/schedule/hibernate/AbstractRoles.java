/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 22:00:42 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the Roles table. 
 * You can customize the behavior of this class by editing the class, {@link Roles()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractRoles 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer idRole;

    /** The value of the simple name property. */
    private java.lang.String name;

    /** The value of the simple description property. */
    private java.lang.String description;

    /**
     * Simple constructor of AbstractRoles instances.
     */
    public AbstractRoles()
    {
    }

    /**
     * Constructor of AbstractRoles instances given a simple primary key.
     * @param uid
     */
    public AbstractRoles(java.lang.Integer idRole)
    {
        this.setUid(idRole);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getUid()
    {
        return idRole;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param uid
     */
    public void setUid(java.lang.Integer idRole)
    {
        this.hashValue = 0;
        this.idRole = idRole;
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
     * Implementation of the equals comparison on the basis of equality of the primary key values.
     * @param rhs
     * @return boolean
     */
    public boolean equals(Object rhs)
    {
        if (rhs == null)
            return false;
        if (! (rhs instanceof Roles))
            return false;
        Roles that = (Roles) rhs;
        if (this.getUid() != null && that.getUid() != null)
        {
            if (! this.getUid().equals(that.getUid()))
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
            int uidValue = this.getUid() == null ? 0 : this.getUid().hashCode();
            result = result * 37 + uidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}

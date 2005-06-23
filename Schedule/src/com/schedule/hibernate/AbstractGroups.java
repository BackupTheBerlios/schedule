/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 21:59:38 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the Groups table. 
 * You can customize the behavior of this class by editing the class, {@link Groups()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractGroups 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The simple primary key value. */
    private GroupsKey id;

    /** The value of the simple name property. */
    private java.lang.String name;

    /** The value of the simple description property. */
    private java.lang.String description;

    /**
     * Simple constructor of AbstractGroups instances.
     */
    public AbstractGroups()
    {
    }

    /**
     * Constructor of AbstractGroups instances given a composite primary key.
     * @param id
     */
    public AbstractGroups(GroupsKey id)
    {
        this.setId(id);
    }

    /**
     * Return the composite id instance that identifies this object.
     * @return GroupsKey
     */
    public GroupsKey getId()
    {
        return this.id;
    }

    /**
     * Set the composite id instance that identifies this object.
     * @param id
     */
    public void setId(GroupsKey id)
    {
        this.hashValue = 0;
        this.id = id;
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
        if (! (rhs instanceof Groups))
            return false;
        Groups that = (Groups) rhs;
        if (this.getId() != null && that.getId() != null)
        {
            return (this.getId().equals(that.getId()));
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
            if (this.getId() == null)
            {
                result = super.hashCode();
            }
            else
            {
                result = this.getId().hashCode();
            }
            this.hashValue = result;
        }
        return this.hashValue;
    }
}

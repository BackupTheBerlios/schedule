/*
 * Created Thu Jun 23 21:59:38 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Groups' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Groups
    extends AbstractGroups
    implements Serializable
{
    /**
     * Simple constructor of Groups instances.
     */
    public Groups()
    {
    }

    /**
     * Constructor of Groups instances given a composite primary key.
     * @param id
     */
    public Groups(java.lang.Integer idGroups)
    {
        super(idGroups);
    }

    /* Add customized code below */

}

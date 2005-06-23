/*
 * Created Thu Jun 23 22:00:42 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Roles' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Roles
    extends AbstractRoles
    implements Serializable
{
    /**
     * Simple constructor of Roles instances.
     */
    public Roles()
    {
    }

    /**
     * Constructor of Roles instances given a simple primary key.
     * @param uid
     */
    public Roles(java.lang.Integer uid)
    {
        super(uid);
    }

    /* Add customized code below */

}

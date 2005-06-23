/*
 * Created Thu Jun 23 22:00:30 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Projects' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Projects
    extends AbstractProjects
    implements Serializable
{
    /**
     * Simple constructor of Projects instances.
     */
    public Projects()
    {
    }

    /**
     * Constructor of Projects instances given a simple primary key.
     * @param pid
     */
    public Projects(java.lang.Integer pid)
    {
        super(pid);
    }

    /* Add customized code below */

}

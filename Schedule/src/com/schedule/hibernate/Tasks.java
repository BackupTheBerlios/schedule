/*
 * Created Thu Jun 23 22:00:51 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Tasks' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Tasks
    extends AbstractTasks
    implements Serializable
{
    /**
     * Simple constructor of Tasks instances.
     */
    public Tasks()
    {
    }

    /**
     * Constructor of Tasks instances given a simple primary key.
     * @param tid
     */
    public Tasks(java.lang.Integer tid)
    {
        super(tid);
    }

    /* Add customized code below */

}

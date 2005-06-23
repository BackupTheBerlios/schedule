/*
 * Created Thu Jun 23 21:59:24 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Blackboard' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Blackboard
    extends AbstractBlackboard
    implements Serializable
{
    /**
     * Simple constructor of Blackboard instances.
     */
    public Blackboard()
    {
    }

    /**
     * Constructor of Blackboard instances given a simple primary key.
     * @param pid
     */
    public Blackboard(java.lang.Integer pid)
    {
        super(pid);
    }

    /* Add customized code below */

}

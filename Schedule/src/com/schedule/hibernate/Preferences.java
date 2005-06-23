/*
 * Created Thu Jun 23 22:00:19 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Preferences' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Preferences
    extends AbstractPreferences
    implements Serializable
{
    /**
     * Simple constructor of Preferences instances.
     */
    public Preferences()
    {
    }

    /**
     * Constructor of Preferences instances given a simple primary key.
     * @param uid
     */
    public Preferences(java.lang.Integer uid)
    {
        super(uid);
    }

    /* Add customized code below */

}

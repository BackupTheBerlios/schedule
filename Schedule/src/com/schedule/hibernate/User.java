/*
 * Created Thu Jun 23 22:01:02 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'User' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class User
    extends AbstractUser
    implements Serializable
{
    /**
     * Simple constructor of User instances.
     */
    public User()
    {
    }

    /**
     * Constructor of User instances given a simple primary key.
     * @param uid
     */
    public User(java.lang.Integer uid)
    {
        super(uid);
    }

    /* Add customized code below */

}

/*
 * Created Thu Jun 23 21:59:50 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Login' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Login
    extends AbstractLogin
    implements Serializable
{
    /**
     * Simple constructor of Login instances.
     */
    public Login()
    {
    }

    /**
     * Constructor of Login instances given a simple primary key.
     * @param uid
     */
    public Login(java.lang.Integer uid)
    {
        super(uid);
    }

}

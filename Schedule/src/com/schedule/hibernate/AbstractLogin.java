/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 21:59:50 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the Login table. 
 * You can customize the behavior of this class by editing the class, {@link Login()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractLogin 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer idLogin;

    /** The value of the simple screenname property. */
    private java.lang.String screenname;

    /** The value of the simple passwort property. */
    private java.lang.String passwort;

    /** The value of the simple active property. */
    private java.lang.Byte active;
    
    /**
     * Simple constructor of AbstractLogin instances.
     */
    public AbstractLogin()
    {
    }

    /**
     * Constructor of AbstractLogin instances given a simple primary key.
     * @param uid
     */
    public AbstractLogin(java.lang.Integer idLogin)
    {
        this.setIdLogin(idLogin);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getIdLogin()
    {
        return idLogin;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param uid
     */
    public void setIdLogin(java.lang.Integer idLogin)
    {
        this.hashValue = 0;
        this.idLogin = idLogin;
    }

    /**
     * Return the value of the Screenname column.
     * @return java.lang.String
     */
    public java.lang.String getScreenname()
    {
        return this.screenname;
    }

    /**
     * Set the value of the Screenname column.
     * @param screenname
     */
    public void setScreenname(java.lang.String screenname)
    {
        this.screenname = screenname;
    }

    /**
     * Return the value of the Passwort column.
     * @return java.lang.String
     */
    public java.lang.String getPasswort()
    {
        return this.passwort;
    }

    /**
     * Set the value of the Passwort column.
     * @param passwort
     */
    public void setPasswort(java.lang.String passwort)
    {
        this.passwort = passwort;
    }

    /**
     * Return the value of the Active column.
     * @return java.lang.Byte
     */
    public java.lang.Byte getActive()
    {
        return this.active;
    }

    /**
     * Set the value of the Active column.
     * @param active
     */
    public void setActive(java.lang.Byte active)
    {
        this.active = active;
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
        if (! (rhs instanceof Login))
            return false;
        Login that = (Login) rhs;
        if (this.getIdLogin() != null && that.getIdLogin() != null)
        {
            if (! this.getIdLogin().equals(that.getIdLogin()))
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
            int uidValue = this.getIdLogin() == null ? 0 : this.getIdLogin().hashCode();
            result = result * 37 + uidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}

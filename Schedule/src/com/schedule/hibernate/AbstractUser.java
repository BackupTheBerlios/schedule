/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 22:01:01 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the User table. 
 * You can customize the behavior of this class by editing the class, {@link User()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractUser 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The composite primary key value. */
    private java.lang.Integer idUser;

    /** Wert f�r den Foreign Key "Role */
    private java.lang.Integer idRole;
    
    /** Wert f�r den Foreign Key "Login" */
    private java.lang.Integer idLogin;
    
    /** Wert f�r den Foreign Key "Preferences" */
    private java.lang.Integer idPreferences;
    
    /** The value of the simple lastname property. */
    private java.lang.String lastname;

    /** The value of the simple firstname property. */
    private java.lang.String firstname;

    /** The value of the simple title property. */
    private java.lang.String title;

    /** The value of the simple email property. */
    private java.lang.String email;

    /** The value of the simple phone property. */
    private java.lang.String phone;

    /** The value of the simple street property. */
    private java.lang.String street;

    /** The value of the simple city property. */
    private java.lang.String city;

    /** The value of the simple zip property. */
    private java.lang.Integer zip;

    /** Aktuelle Projekte des Nutzers */
    private java.util.Set projects;
    
    /** Alle Gruppen denen dieser User angeh�rt */
    private java.util.Set groups;
    
    /**
     * Simple constructor of AbstractUser instances.
     */
    public AbstractUser()
    {
    }

    /**
     * Constructor of AbstractUser instances given a simple primary key.
     * @param uid
     */
    public AbstractUser(java.lang.Integer idUser)
    {
        this.setIdUser(idUser);
    }

    /**
     * Return the simple primary key value that identifies this object.
     * @return java.lang.Integer
     */
    public java.lang.Integer getIdUser()
    {
        return idUser;
    }

    /**
     * Set the simple primary key value that identifies this object.
     * @param idUser
     */
    public void setIdUser(java.lang.Integer idUser)
    {
        this.hashValue = 0;
        this.idUser = idUser;
    }

    /**
     * Gibt den Wert f�r den Forgeign Key "Role" zur�ck
     * @return idRole
     */
    public java.lang.Integer getIdRole()
    {
    	return idRole;
    }
    
    /**
     * Setzt den Wert f�r den Foreign Key "Role"
     * @param idRole
     */
    public void setIdRole(java.lang.Integer idRole)
    {
    	this.idRole = idRole;
    }
    
    /**
     * Gibt den Wert f�r den Forgeign Key "Login" zur�ck
     * @return idRole
     */
    public java.lang.Integer getIdLogin()
    {
    	return idLogin;
    }
    
    /**
     * Setzt den Wert f�r den Foreign Key "Role"
     * @param idRole
     */
    public void setIdLogin(java.lang.Integer idLogin)
    {
    	this.idLogin = idLogin;
    }
    
    /**
     * Gibt den Wert f�r den Forgeign Key "Login" zur�ck
     * @return idRole
     */
    public java.lang.Integer getIdPreferences()
    {
    	return idPreferences;
    }
    
    /**
     * Setzt den Wert f�r den Foreign Key "Role"
     * @param idRole
     */
    
    public void setIdPreferences(java.lang.Integer idPreferences)
    {
    	this.idPreferences = idPreferences;
    }
    
    /**
     * Return the value of the Lastname column.
     * @return java.lang.String
     */
    public java.lang.String getLastname()
    {
        return this.lastname;
    }

    /**
     * Set the value of the Lastname column.
     * @param lastname
     */
    public void setLastname(java.lang.String lastname)
    {
        this.lastname = lastname;
    }

    /**
     * Return the value of the Firstname column.
     * @return java.lang.String
     */
    public java.lang.String getFirstname()
    {
        return this.firstname;
    }

    /**
     * Set the value of the Firstname column.
     * @param firstname
     */
    public void setFirstname(java.lang.String firstname)
    {
        this.firstname = firstname;
    }

    /**
     * Return the value of the Title column.
     * @return java.lang.String
     */
    public java.lang.String getTitle()
    {
        return this.title;
    }

    /**
     * Set the value of the Title column.
     * @param title
     */
    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }

    /**
     * Return the value of the Email column.
     * @return java.lang.String
     */
    public java.lang.String getEmail()
    {
        return this.email;
    }

    /**
     * Set the value of the Email column.
     * @param email
     */
    public void setEmail(java.lang.String email)
    {
        this.email = email;
    }

    /**
     * Return the value of the Phone column.
     * @return java.lang.String
     */
    public java.lang.String getPhone()
    {
        return this.phone;
    }

    /**
     * Set the value of the Phone column.
     * @param phone
     */
    public void setPhone(java.lang.String phone)
    {
        this.phone = phone;
    }

    /**
     * Return the value of the Street column.
     * @return java.lang.String
     */
    public java.lang.String getStreet()
    {
        return this.street;
    }

    /**
     * Set the value of the Street column.
     * @param street
     */
    public void setStreet(java.lang.String street)
    {
        this.street = street;
    }

    /**
     * Return the value of the City column.
     * @return java.lang.String
     */
    public java.lang.String getCity()
    {
        return this.city;
    }

    /**
     * Set the value of the City column.
     * @param city
     */
    public void setCity(java.lang.String city)
    {
        this.city = city;
    }

    /**
     * Return the value of the ZIP column.
     * @return java.lang.Integer
     */
    public java.lang.Integer getZip()
    {
        return this.zip;
    }

    /**
     * Set the value of the ZIP column.
     * @param zip
     */
    public void setZip(java.lang.Integer zip)
    {
        this.zip = zip;
    }

    /**
     * Liefert die aktuellen Projekte des Nutzers zur�ck
     * @return projects 
     */
    public java.util.Set getProjects()
    {
    	return projects;
    }

    /**
     * Setzt die Projekte des Nutzers
     * @param projects
     */
    public void setProjects(java.util.Set projects)
    {
    	this.projects = projects;
    }
    
    /**
     * liefert alle Gruppen zur�ck denen dieser User angeh�rt
     * @return java.util.Set groups
     */
    public java.util.Set getGroups()
    {
    	return groups;
    }
    
    /**
     * setzt die Gruppen denen der User angeh�rt
     * @param groups
     */
    public void setGroups(java.util.Set groups)
    {
    	this.groups = groups;
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
        if (! (rhs instanceof User))
            return false;
        User that = (User) rhs;
        if (this.getIdUser() != null && that.getIdUser() != null)
        {
            if (! this.getIdUser().equals(that.getIdUser()))
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
            int uidValue = this.getIdUser() == null ? 0 : this.getIdUser().hashCode();
            result = result * 37 + uidValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}

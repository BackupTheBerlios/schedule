/*
 * Created Thu Jun 23 21:58:11 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Appointments' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Appointments
    extends AbstractAppointments
    implements Serializable
{
    /**
     * Simple constructor of Appointments instances.
     */
    public Appointments()
    {
    }

    /**
     * Constructor of Appointments instances given a composite primary key.
     * @param id
     */
    public Appointments(AppointmentsKey id)
    {
        super(id);
    }

    /* Add customized code below */

}

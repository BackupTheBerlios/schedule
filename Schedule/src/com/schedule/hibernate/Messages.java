/*
 * Created Thu Jun 23 22:00:06 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the 'Messages' table. 
 * This class may be customized as it is never re-generated 
 * after being created.
 */
public class Messages
    extends AbstractMessages
    implements Serializable
{
    /**
     * Simple constructor of Messages instances.
     */
    public Messages()
    {
    }

    /**
     * Constructor of Messages instances given a composite primary key.
     * @param id
     */
    public Messages(MessagesKey id)
    {
        super(id);
    }

    /* Add customized code below */

}

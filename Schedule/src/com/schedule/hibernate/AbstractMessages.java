/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Jun 23 22:00:06 CEST 2005 by MyEclipse Hibernate Tool.
 */
package com.schedule.hibernate;

import java.io.Serializable;

/**
 * A class that represents a row in the Messages table. 
 * You can customize the behavior of this class by editing the class, {@link Messages()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized * by MyEclipse Hibernate tool integration.
 */
public abstract class AbstractMessages 
    implements Serializable
{
    /** The cached hash code value for this instance.  Settting to 0 triggers re-calculation. */
    private int hashValue = 0;

    /** The simple primary key value. */
    private java.lang.Integer idMessages;

    /** The value of the simple recipient property. */
    private java.lang.String recipient;

    /** The value of the simple subject property. */
    private java.lang.String subject;

    /** The value of the simple body property. */
    private java.lang.String body;

    /** The value of the simple attachment property. */
    private java.lang.String attachment;

    /** The value of the simple date property. */
    private java.util.Date date;

    /** gibt an ob die Nachricht bereits gelesen wurde */
    private java.lang.Boolean messageRead;
    
    /** Der User der die Nachricht verfa�t hat */
    private User user;
    
    /**
     * Simple constructor of AbstractMessages instances.
     */
    public AbstractMessages()
    {
    }

    /**
     * Constructor of AbstractMessages instances given a composite primary key.
     * @param id
     */
    public AbstractMessages(java.lang.Integer idMessages)
    {
        this.setIdMessages(idMessages);
    }

    /**
     * Return the composite id instance that identifies this object.
     * @return MessagesKey
     */
    public java.lang.Integer getIdMessages()
    {
        return this.idMessages;
    }

    /**
     * Set the composite id instance that identifies this object.
     * @param id
     */
    public void setIdMessages(java.lang.Integer idMessages)
    {
        this.hashValue = 0;
        this.idMessages = idMessages;
    }

    /**
     * Return the value of the Recipient column.
     * @return java.lang.String
     */
    public java.lang.String getRecipient()
    {
        return this.recipient;
    }

    /**
     * Set the value of the Recipient column.
     * @param recipient
     */
    public void setRecipient(java.lang.String recipient)
    {
        this.recipient = recipient;
    }

    /**
     * Return the value of the Subject column.
     * @return java.lang.String
     */
    public java.lang.String getSubject()
    {
        return this.subject;
    }

    /**
     * Set the value of the Subject column.
     * @param subject
     */
    public void setSubject(java.lang.String subject)
    {
        this.subject = subject;
    }

    /**
     * Return the value of the Body column.
     * @return java.lang.String
     */
    public java.lang.String getBody()
    {
        return this.body;
    }

    /**
     * Set the value of the Body column.
     * @param body
     */
    public void setBody(java.lang.String body)
    {
        this.body = body;
    }

    /**
     * Return the value of the Attachment column.
     * @return java.lang.String
     */
    public java.lang.String getAttachment()
    {
        return this.attachment;
    }

    /**
     * Set the value of the Attachment column.
     * @param attachment
     */
    public void setAttachment(java.lang.String attachment)
    {
        this.attachment = attachment;
    }

    /**
     * Return the value of the Date column.
     * @return java.util.Date
     */
    public java.util.Date getDate()
    {
        return this.date;
    }

    /**
     * Set the value of the Date column.
     * @param date
     */
    public void setDate(java.util.Date date)
    {
        this.date = date;
    }

    /** 
     * liefert den Status (gelesen oder ungelesen) dieser Nachricht zur�ck 
     * @return java.lang.Boolean messageRead
     * */
    public java.lang.Boolean getMessageRead()
    {
    	return messageRead;
    }
    
    /** 
     * setzt den Status der Nachricht auf gelesen or ungelesen
     * @param
     * */
    public void setMessageRead(java.lang.Boolean messageRead)
    {
    	this.messageRead = messageRead;
    }
    
    /**
     * liefert den User zur�ck, der diese Nachricht verfa�t hat
     * @return User user
     */
    public User getUser()
    {
    	return user;
    }
    
    /**
     * setzt den User der diese Nachricht verfa�t hat
     * @param user
     */
    public void setUser(User user)
    {
    	this.user = user;
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
        if (! (rhs instanceof Messages))
            return false;
        Messages that = (Messages) rhs;
        if (this.getIdMessages() != null && that.getIdMessages() != null)
        {
            return (this.getIdMessages().equals(that.getIdMessages()));
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
            if (this.getIdMessages() == null)
            {
                result = super.hashCode();
            }
            else
            {
                result = this.getIdMessages().hashCode();
            }
            this.hashValue = result;
        }
        return this.hashValue;
    }
}

/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

/**
 * @author Christian Sukale
 *
 */
public class BlackboardBean {
	
	 /** The value of the simple subject property. */
    private java.lang.String subject;

    /** The value of the simple body property. */
    private java.lang.String body;

    /** The value of the simple date property. */
    private java.util.Date date;
    
	/**
	 * @return Returns the body.
	 */
	public java.lang.String getBody() {
		return body;
	}
	/**
	 * @param body The body to set.
	 */
	public void setBody(java.lang.String body) {
		this.body = body;
	}
	/**
	 * @return Returns the date.
	 */
	public java.util.Date getDate() {
		return date;
	}
	/**
	 * @param date The date to set.
	 */
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	/**
	 * @return Returns the subject.
	 */
	public java.lang.String getSubject() {
		return subject;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}
}

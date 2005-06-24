/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

/**
 * @author reinhard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MessageBean {
	
	/** The sender id of the message. */
	private Integer sender;
	
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

	/**
	 * @return Returns the attachment.
	 */
	public java.lang.String getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment The attachment to set.
	 */
	public void setAttachment(java.lang.String attachment) {
		this.attachment = attachment;
	}
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
	 * @return Returns the recipient.
	 */
	public java.lang.String getRecipient() {
		return recipient;
	}
	/**
	 * @param recipient The recipient to set.
	 */
	public void setRecipient(java.lang.String recipient) {
		this.recipient = recipient;
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
	/**
	 * @return Returns the sender.
	 */
	public Integer getSender() {
		return sender;
	}
	/**
	 * @param sender The sender to set.
	 */
	public void setSender(Integer sender) {
		this.sender = sender;
	}
}

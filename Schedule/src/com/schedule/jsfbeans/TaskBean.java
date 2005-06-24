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
public class TaskBean {
	
	/** The value of the simple subject property. */
    private java.lang.String subject;

    /** The value of the simple pid property. */
    private java.lang.Integer pid;

    /** The value of the simple solved property. */
    private java.lang.Float solved;

    /** The value of the simple tid1 property. */
    private java.lang.Integer partOfTID;

	/**
	 * @return Returns the pid.
	 */
	public java.lang.Integer getPid() {
		return pid;
	}
	/**
	 * @param pid The pid to set.
	 */
	public void setPid(java.lang.Integer pid) {
		this.pid = pid;
	}
	/**
	 * @return Returns the solved.
	 */
	public java.lang.Float getSolved() {
		return solved;
	}
	/**
	 * @param solved The solved to set.
	 */
	public void setSolved(java.lang.Float solved) {
		this.solved = solved;
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
	 * @return Returns the tid1.
	 */
	public java.lang.Integer getPartOfTID() {
		return partOfTID;
	}
	/**
	 * @param tid1 The tid1 to set.
	 */
	public void setPartOfTID(java.lang.Integer partOfTID) {
		this.partOfTID = partOfTID;
	}
}

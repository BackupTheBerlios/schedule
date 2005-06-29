/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import java.sql.ResultSet;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.Messages;

/**
 * 
 * @author reinhard
 *
 */
public class MessageHandlerBean {

	/**
	 * List of messages
	 */
	private List messageList;
	
	/**
	 * A row representing a message
	 */
	private ResultSet entry;
	
	/**
	 * Constructor reads messages from database
	 *
	 */
	public MessageHandlerBean()
	{
		this.getMessages();
	}
	
	/**
	 * Method for reading messages
	 *
	 */
	public void getMessages()
	{
		Session sess = HibernateManager.getSession();
		Query q;
		
		List messages = null;
		
		try {
			q = sess.createQuery("from Messages where uid= :uid");
			q.setString("uid", "1");
			messages = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<messages.size(); i++)
		{
			Messages msg = (Messages) messages.get(i);
		}
		
		
	}
	/**
	 * @return Returns the messageList.
	 */
	public List getMessageList() {
		return messageList;
	}
	/**
	 * @param messageList The messageList to set.
	 */
	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}
}
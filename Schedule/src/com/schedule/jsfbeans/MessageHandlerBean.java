/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import com.schedule.hibernate.*;

import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.*;
import javax.faces.context.*;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.HibernateManager;

/**
 * 
 * @author reinhard
 *
 */
public class MessageHandlerBean {

	/**
	 * Screenname of currently logged in User
	 */
	private String screenname;
	
	/**
	 * List of unread Messages
	 */
	private List unreadMessages;
	
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
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Login login = (Login) session.getAttribute("Login");	//Login-Objekt wird aus Session geholt
		screenname = login.getScreenname();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRecipient()
	{
		return screenname;
	}
	
	/**
	 * 
	 * @param aRecipient
	 */
	public void setRecipient(String aRecipient)
	{
		screenname = aRecipient;
	}
	
	/**
	 * queries all unread messages of currently logged in user
	 * @return Returns a list of unread messages
	 */
	public List getUnreadMessages()
	{
		Session sess = HibernateManager.getSession();
		Query q;
		
		try {
			q = sess.createQuery("from Messages where Recipient= :Recipient and MessageRead= :MessageRead");
			q.setString("Recipient", screenname);
			q.setString("MessageRead", "false");
			unreadMessages = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return unreadMessages;
	}
	
	/**
	 * 
	 * @param aMessageList
	 */
	public void setUnreadMessages(List aMessageList)
	{
		unreadMessages = aMessageList;
	}
		
	/**
	 * @return Returns the messageList.
	 */
	public List getMessageList() {
		
		Session sess = HibernateManager.getSession();
		Query q;
		
		try {
			q = sess.createQuery("from Messages where Recipient= :Recipient");
			q.setString("Recipient", screenname);
			messageList = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return messageList;
	}
	
	/**
	 * @param messageList The messageList to set.
	 */
	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}
}
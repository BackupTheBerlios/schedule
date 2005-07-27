/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.HibernateManager;

import com.schedule.hibernate.Login;


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
	
	/** Amount of unread messages */
	private int unreadMessagesCount;
	
	/** Amount of overall messages */
	private int messagesCount;
	
	/**
	 * Constructor reads messages from database
	 *
	 */
	public MessageHandlerBean()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Login login = (Login) session.getAttribute("Login");
		screenname = login.getScreenname();
		unreadMessagesCount = 0;
		messagesCount = 0;

	}
	
	/**
	 * 
	 * @return
	 */
	public String getScreenname()
	{
		return screenname;
	}
	
	/**
	 * 
	 * @param aRecipient
	 */
	public void setScreenname(String aScreenname)
	{
		screenname = aScreenname;
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
		unreadMessagesCount = unreadMessages.size();
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
		messagesCount = messageList.size();
		return messageList;
	}
	
	/**
	 * @param messageList The messageList to set.
	 */
	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}
	
	/**
	 * 
	 * @return Returns the number of unread messages
	 */
	public int getUnreadMessagesCount()
	{
		return unreadMessagesCount;
	}
	
	/**
	 * 
	 * @return Returns the number of overall messages
	 */
	public int getMessagesCount()
	{
		return messagesCount;
	}
}
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
import com.schedule.hibernate.Messages;

/**
 * 
 * @author reinhard
 *
 */
public class MessageHandlerBean {

	
	private String recipient;
	
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
		Login login = (Login) session.getAttribute("Login");
		recipient = login.getScreenname();
		this.getMessages();
	}
	
	public String getRecipient()
	{
		return recipient;
	}
	
	public void setRecipient(String aRecipient)
	{
		recipient = aRecipient;
	}
	
	/**
	 * Method for reading messages
	 *
	 */
	public void getMessages()
	{
		Session sess = HibernateManager.getSession();
		Query q;
		
		try {
			q = sess.createQuery("from Messages where Recipient= :Recipient");
			q.setString("Recipient", recipient);
			messageList = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(messageList.size() != 0)
		{
			for(int i=0; i<messageList.size(); i++)
			{
				Messages msg = (Messages) messageList.get(i);
			}	
		} else {
			System.out.println("Keine Nachrichten gefunden");
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
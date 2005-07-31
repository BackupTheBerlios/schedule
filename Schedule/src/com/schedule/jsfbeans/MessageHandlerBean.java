/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.*;



/**
 * 
 * @author reinhard
 *
 */
public class MessageHandlerBean {

	/** Recipient of the new message */
	private String recipient;
	
	/** Subject belonging to the new message */
	private String subject;
	
	/** Body of the new message */
	private String body;
	
	/** Screenname of currently logged in User */
	private String screenname;
	
	/** List of unread Messages */
	private List unreadMessages;
	
	/** List of messages */
	private List messageList;
	
	/** Amount of unread messages */
	private int unreadMessagesCount;
	
	/** Amount of overall messages */
	private int messagesCount;
	
	/** The current Message included in this Request */
	private Messages currentMessage;
	
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
		this.getUnreadMessages();	//um die Counter zu initialisieren
		this.getMessageList();		//um die Counter zu initialisieren
	}
	
	/**
	 * @return Returns the body.
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * @param body The body to set.
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * @return Returns the recipient.
	 */
	public String getRecipient() {
		return recipient;
	}
	
	/**
	 * @param recipient The recipient to set.
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	/**
	 * @return Returns the subject.
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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
	
	/**
	 * 
	 * @return
	 */
	public Messages getCurrentMessage()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		String aMessageId = ((String) requestMap.get("Message"));
		
		Session sess = HibernateManager.getSession();
		Query q;
		List messages = null;
		
		try {
			q = sess.createQuery("from Messages where idMessages= :idMessages");
			q.setString("idMessages", aMessageId);
			messages = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		Messages aMessage = (Messages) messages.get(0);
		
		this.setCurrentMessage(aMessage);
		
		return currentMessage;
	}
	
	/**
	 * 
	 * @param aCurrentMessage
	 */
	public void setCurrentMessage(Messages aCurrentMessage)
	{
		currentMessage = aCurrentMessage;
	}
	
	/**
     * Adds a new Message
     */ 
    public String addMessage()
    {
    	//Hibernate Session holen
    	Session hbmsession = HibernateManager.getSession();
		HibernateManager.beginTransaction();
		//neues Message-Objekt erzeugen und Attribute setzen
		Messages newMessage = new Messages();
		newMessage.setRecipient(this.recipient);
		newMessage.setDate(new Date());
		newMessage.setSubject(this.subject);
		newMessage.setBody(this.body);
		newMessage.setMessageRead(new Boolean(false));
		/** TODO
		 * An dieser Stelle muﬂ dann noch das Attachment gespeichert werden - sobald wir wissen wie
		 */
		//Get User from Session
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		User user = (User) session.getAttribute("User");
		//Absender der Nachricht
		newMessage.setUser(user);
		
		try {
			//Update DB Objects
			hbmsession.saveOrUpdate(newMessage);
		} catch (HibernateException e) {
			e.printStackTrace();
			FacesContext facesContext = FacesContext.getCurrentInstance(); 
			FacesMessage facesMessage = new FacesMessage("Datenbankzugriff fehlgeschlagen");
			facesContext.addMessage("registerForm", facesMessage);  
			
			return "failure";
		}
		
		HibernateManager.commitTransaction();
		return "success";
    }
	
}
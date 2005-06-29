/*
 * Created on 24.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.xml.registry.RegistryException;

import com.schedule.hibernate.Messages;


public class MessageBean {

    private DataModel messageModel;

  
    public DataModel getReportsModel( ) {

        if (messageModel == null) {

        	messageModel = new ListDataModel( );

        }

        messageModel.setWrappedData(getReports( ));

        return messageModel;

    }


    /**
     * Get the current message set
     * @return The messages of the user
     */
    public List getReports( ) {

        String user = null;

        user = getCurrentUser( );

        List l = null;

        try {

            l = registry.getReports(user, from, to, status);

        }
        catch (RegistryException e) {

        }
        return l;
    }
    
    public String select( ) {

        Messages selectedReport = (Messages) messageModel.getRowData( );

        setCurrentReport(selectedReport);

        return "success";

    }

}

//
//public class MessageBean {
//	
//	private List messageList;
//	private String recipient;
//	
//	private UIData message;
//	
//	/**
//	 * Constructor reads messages from the DB
//	 *
//	 */
//	public MessageBean()
//	{
//		this.init();
//		this.getMessages(recipient);
//	}
//	
//	public void init()
//	{
//		Session sess = HibernateManager.getSession();
//		Query q = null;
//
//		try {
//			q = sess.createQuery("select uid from Users where uid= :uid");
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//	/**
//	 * Read messages from the DB
//	 * @param recipient The recipient of the messages
//	 */
//	public void getMessages(String recipient)
//	{
//		Session sess = HibernateManager.getSession();
//		Query q = null;
//		List messages=null;
//		
//		try {
//			q = sess.createQuery("from Messages where recipient= :recipient");
//			q.setString("recipient", this.recipient);
//			messages = (List) q.list();			
//		} catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		
//		this.messageList = messages;
//	
//	}
//	
//	/**
//	 * @return Returns the message.
//	 */
//	public UIData getMessage() {
//		return message;
//	}
//	/**
//	 * @param message The message to set.
//	 */
//	public void setMessage(UIData message) {
//		this.message = message;
//	}
//	/**
//	 * @return Returns the messageList.
//	 */
//	public List getMessageList() {
//		return messageList;
//	}
//	/**
//	 * @param messageList The messageList to set.
//	 */
//	public void setMessageList(List messageList) {
//		this.messageList = messageList;
//	}
//	/**
//	 * @return Returns the recipient.
//	 */
//	public String getRecipient() {
//		return recipient;
//	}
//	/**
//	 * @param recipient The recipient to set.
//	 */
//	public void setRecipient(String recipient) {
//		this.recipient = recipient;
//	}
//}

/*
 * Created on 24.06.2005
 *
 */
package com.schedule.jsfbeans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.schedule.hibernate.*;

/**
 * 
 * @author Christian Sukale
 *
 */
public class MessageHandlerBean {

	private UploadedFile myFile;
    private String myParam = "MD5";
    private String myResult;
    private int isSet = 0;
    
    private String savePath;
    
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
	
	public UploadedFile getMyFile() {
        return myFile;
    }

    public void setMyFile(UploadedFile myFile) {
        this.myFile = myFile;
    }

    public String getMyParam() {
        return myParam;
    }

    public void setMyParam(String myParam) {
        this.myParam = myParam;
    }

    public String getMyResult() {
        return myResult;
    }

    public void setMyResult(String myResult) {
        this.myResult = myResult;
    }
    public String processMyFile() {
        try {
        		BufferedOutputStream os = null;
        		String bla = FacesContext.getCurrentInstance().getViewRoot().getViewId();//   getViewRoot().getViewId() ;
            MessageDigest md
                = MessageDigest.getInstance(myParam);
            InputStream in = new BufferedInputStream(
                myFile.getInputStream());
            this.savePath = this.savePath + myFile.getName();
            os = new BufferedOutputStream(
            	       new FileOutputStream( this.savePath ) ); //Zielverzeichniss
            
            try {
                byte[] buffer = new byte[64 * 1024];
                int count;
                while ((count = in.read(buffer)) > 0){
                    md.update(buffer, 0, count);
                    os.write(buffer, 0, count);
                    
                }
            } finally {
                in.close();
            }
            byte hash[] = md.digest();
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                int b = hash[i] & 0xFF;
                int c = (b >> 4) & 0xF;
                c = c < 10 ? '0' + c : 'A' + c - 10;
                buf.append((char) c);
                c = b & 0xF;
                c = c < 10 ? '0' + c : 'A' + c - 10;
                buf.append((char) c);
            }
            myResult = buf.toString();
            this.isSet = 1;
            return "OK";
        } catch (Exception x) {
            FacesMessage message = new FacesMessage(
                FacesMessage.SEVERITY_FATAL,
                x.getClass().getName(), x.getMessage());
            FacesContext.getCurrentInstance().addMessage(
                null, message);
            return null;
        }
    }
	/**
	 * @return Returns the isSet.
	 */
	public int getIsSet() {
		return this.isSet;
	}
	/**
	 * @param isSet The isSet to set.
	 */
	public void setIsSet(int isSet) {
		this.isSet = isSet;
	}
	/**
	 * Constructor reads messages from database
	 *
	 */
	public MessageHandlerBean()
	{
		savePath = "/";
		Session sess = HibernateManager.getSession();
		Login login = null;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Integer loginId = (Integer) session.getAttribute("LoginID");
		// Login-Objekt laden
		try {
			login = (Login) sess.load(Login.class, loginId);		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
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
	public List getMessageList() 
	{
		
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
	public void setMessageList(List messageList) 
	{
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
		Integer aMessageId = new Integer((String) requestMap.get("Message"));
		
		Session sess = HibernateManager.getSession();
		
		
		try {
			this.currentMessage = (Messages) sess.load(Messages.class, aMessageId);			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		//Status der Nachricht auf "gelesen" setzen
		currentMessage.setMessageRead(new Boolean(true));
		try
		{
			sess.saveOrUpdate(currentMessage);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
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
		newMessage.setAttachment(this.savePath);
		
		/** TODO
		 * An dieser Stelle muß dann noch das Attachment gespeichert werden - sobald wir wissen wie
		 */
		//Get User from Session
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Integer userId = (Integer) session.getAttribute("UserID");
		User user = null;
		try {
			user = (User) hbmsession.load(User.class, userId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
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
			//TODO: DELETE UPLOADED FILE (this.savePath)
			return "failure";
		}
		
		HibernateManager.commitTransaction();
		HibernateManager.closeSession();
		this.isSet = 0;
		resetAttributes();
		return "success";
    }
    public void resetAttributes(){
    	this.screenname = null;
    	this.body = null;
    	this.recipient = null;
    	this.subject = null;
    	this.savePath = "/";
    }
	
	/**
	 * @return Returns the savePath.
	 */
	public String getSavePath() {
		return savePath;
	}
	/**
	 * @param savePath The savePath to set.
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
}
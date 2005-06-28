/*
 * Created on 28.06.2005
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
public class NavigationBean {
	
	private String link;
	
	/**
	 * This method handles the navigation throughout the application
	 * @return The page the user is sent to as a string
	 */
	public String gotoPage()
	{
		if(this.link.equals("messages"))
		{
			return "messagepage";
		}
		
		if(this.link.equals("logout"))
		{
			return "logoutpage";
		}
		
		if(this.link.equals("register"))
		{
			return "registerpage";
		}
		
		if(this.link.equals("login"))
		{
			return "loginpage";
		}
		
		return "startpage";
	}
	
	/**
	 * @return Returns the link.
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link The link to set.
	 */
	public void setLink(String link) {
		this.link = link;
	}
}

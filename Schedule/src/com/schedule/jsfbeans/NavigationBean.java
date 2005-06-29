/*
 * Created on 28.06.2005
 *
 */
package com.schedule.jsfbeans;

/**
 * @author reinhard
 *
 */
public class NavigationBean {
	
	private String link;
	
	/**
	 * This method handles the navigation throughout the application
	 * @return The page the user is sent to as a string
	 */
	public String gotoPage()
	{
		if(this.link.equals("team"))
		{
			return "teampage";
		}
		
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
		
		if(this.link.equals("home"))
		{
			return "startpage";
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

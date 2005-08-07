/*
 * Created on 06.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author MuTaBor
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class myDate {

	/**
	 * 
	 */
	public myDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/** constructor*/
	public myDate (Calendar date){
		setDateString(date.getTime().toString());
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		setSimpleDateString(formatter.format(date.getTime()));
	}
		private String simpleDateString;
	
		
		private String dateString;
		
		/**
		 * @return Returns the simpleDateString.
		 */
		public String getSimpleDateString() {
			return simpleDateString;
		}
		
		/**
		 * @param simpleDateString The simpleDateString to set.
		 */
		public void setSimpleDateString(String simpleDateString) {
			this.simpleDateString = simpleDateString;
		}
		
		
		/**
		 * @return Returns the dateString.
		 */
		public String getDateString() {
			return dateString;
		}
		/**
		 * @param dateString The dateString to set.
		 */
		public void setDateString(String dateString) {
			this.dateString = dateString;
		}
		
	

}

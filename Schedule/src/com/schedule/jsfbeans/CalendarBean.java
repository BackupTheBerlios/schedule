/*
 * Created on 05.08.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.jsfbeans;

import java.util.List;
import java.util.Calendar;
import java.util.Vector;
import java.text.SimpleDateFormat;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Query;

import com.schedule.hibernate.HibernateManager;
import com.schedule.hibernate.User;
import com.schedule.jsfbeans.myDate;


/**
 * @author roBaTuM
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CalendarBean {
	
	
	/** Number of appointments assigned to the current User */
    private int appointmentCount;
	
    /** List of all tasks assigned to the current user */
    private List tasksList;
    
    /** Number of tasks assigned to the current user */
    private int taskCount;

	
	
	/** List of all Appointments assigned to the current User */
    private List appointmentsList;
    
    
    /** The user associated with this appointment */
    private User user;

    private myDate weekPointer;
    
    private myDate monthPointer;
    
    private List weekList = null;
    
    private List monthList = null;
	
	private myDate date;
	
	/**
	 * @return Returns the date.
	 */
	public myDate getDate() {
		return date;
	}
	/**
	 * @param date The date to set.
	 */
	public void setDate(myDate date) {
		this.date = date;
	}
	private static int dateUnit = 24;
	
	
	/** List of all calendar entries */
    private Vector calendarList;
	
    /** Range for up-to-date calendar view */
	private int range;
	
	private Calendar now;
	
	private Calendar datePointer = null;
	
	private String datePointerString;
	
	private List outputDate;
	
	private int countDate;
	
	
	/** Constrauctor for CalendarBean */
	public CalendarBean() {
		
		getNow();
		setRange(3);
		setCountDate(0);

		Calendar tempCal = getDatePointer();
		}
	
	
	
	/**
	 * @return Returns the monthList.
	 */
	public List getMonthList() {
		
		return monthList;
	}
	
	/**
	 * @param monthList The monthList to set.
	 */
	public void setMonthList(List monthList) {
		this.monthList = monthList;
	}
	
	/**
	 * @return Returns the weekList.
	 */
	public List getWeekList() {
		if (this.weekList == null) {
			weekList = new Vector();
			Calendar tempDate = getDatePointer();
			int dayOfWeek = tempDate.get(Calendar.DAY_OF_WEEK);
			int startDay = 2 - dayOfWeek;
			if (startDay == 1) {
				startDay = -6;
				}
			
			for (int i=startDay;i<startDay+7;i++){
				
				
				
				Calendar tempDate2 = Calendar.getInstance();
				
				tempDate2.setTime(getDatePointer().getTime());
				
				
				tempDate2.add(Calendar.HOUR, + (int)(dateUnit*i));
				myDate wDate = new myDate(tempDate2);
				
				this.weekList.add(wDate);
			}
		}else {}
		
		return weekList;
	}
	
	/**
	 * @param weekList The weekList to set.
	 */
	public void setWeekList(List weekList) {
		this.weekList = weekList;
	}
	

	/**
	 * @return Returns the datePointerString.
	 */
	public String getDatePointerString() {
		
		Calendar cal = getDatePointer();
		
		SimpleDateFormat formatter = new SimpleDateFormat("E dd.MM.yyyy");
		this.datePointerString = formatter.format(cal.getTime());
		return datePointerString;
	}
	
	/**
	 * @param datePointerString The datePointerString to set.
	 */
	public void setDatePointerString(String datePointerString) {
		this.datePointerString = datePointerString;
	}
	
	/**
	 * @return Returns the datePointer.
	 */
	public Calendar getDatePointer() {
		
		if (this.datePointer == null){
			this.datePointer = Calendar.getInstance();
			
			
		}	else {
			
			}
		
		return datePointer;
	}
	
	/**
	 * @param datePointer The datePointer to set.
	 */
	public void setDatePointer(Calendar datePointer) {
		
		this.datePointer = datePointer;
	}

	/**
	 * @return Returns the countDate.
	 */
	public int getCountDate() {
		return countDate;
	}
	
	/**
	 * @param countDate The countDate to set.
	 */
	public void setCountDate(int countDate) {
		this.countDate = countDate;
	}
	
	/**
	 * Returns a list of tasks assigned to the user
	 * @return
	 */
	public List getTasksList()
	{	
		Session hbmsession = HibernateManager.getSession();
		User user = this.getUser();
		Query q;
		
		
		try {
			q = hbmsession.createFilter(user.getTasks(), "where this.solved < 100");
			this.tasksList = q.list();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

			System.out.println(tasksList);
	
		
		taskCount = tasksList.size();
		
		return tasksList;
	}
	
	/**
	 * Sets a list of tasks for the user
	 * @param aTasksList
	 */
	public void setTasksList(List aTasksList)
	{
		tasksList = aTasksList;
	}
	
	
	public List getAppointmentsList()
	{
		Session hbmsession = HibernateManager.getSession();
		User user = this.getUser();
		Query q;
		try {
			q = hbmsession.createFilter(user.getAppointments(), "where this.date like :Date");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			q.setString("Date",formatter.format(this.datePointer.getTime()));
			
			this.appointmentsList = q.list();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.appointmentCount = this.appointmentsList.size();
		return this.appointmentsList;
		
	}
	
	public void setAppointmentsList(List aAppointmentsList)
	{
		appointmentsList = aAppointmentsList;
	}
	
	public User getUser() 
	{
		
		User user = null;
		Session hbmsession = HibernateManager.getSession();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	Integer userId = (Integer) session.getAttribute("UserID");
    	try {
    		user = (User) hbmsession.load(User.class, userId);
    	} catch (HibernateException e) {
    		e.printStackTrace();
    	}
    	
		return user;
	}
	
	
	/**
	 * @return Returns the now.
	 */
	public Calendar getNow() {
		
		this.now = Calendar.getInstance();
		
		return now;
	}
	
	/**
	 * @param now The now to set.
	 */
	public void setNow(Calendar now) {
		this.now = now;
	}
	
	/**
	 * @return Returns the outputDate.
	 */
	private List getOutputDate() {
		return outputDate;
	}
	
	/**
	 * @param outputDate The outputDate to set.
	 */
	private void setOutputDate(List outputDate) {
		this.outputDate = outputDate;
	}
	
	/**
	 * @return Returns the range.
	 */
	public int getRange() {
		return range;
	}
	
	/**
	 * @param range The range to set.
	 */
	public void setRange(int range) {
		this.range = range;
	}
	
	
	public List getCalendarList() {		
		return  calendarList;
	}
	
	
	public void forwardDay(ActionEvent event){
		Calendar tempDate = getDatePointer();
		tempDate.add(Calendar.HOUR, + (int)(dateUnit));
		setDatePointer(tempDate);
	}
	public void backwardDay(ActionEvent event){
		Calendar tempDate = getDatePointer();
		tempDate.add(Calendar.HOUR, - (int)(dateUnit));
		setDatePointer(tempDate);
	}
	
	public void forwardWeek(ActionEvent event){
		Calendar tempDate = getDatePointer();
		tempDate.add(Calendar.HOUR, + (int)(dateUnit*7));
		setDatePointer(tempDate);
	}
	public void backwardWeek(ActionEvent event){
		Calendar tempDate = getDatePointer();
		tempDate.add(Calendar.HOUR, - (int)(dateUnit*7));
		setDatePointer(tempDate);
	}
	
	
	/**
	 * @return Returns the monthPointer.
	 */
	public myDate getMonthPointer() {
		return monthPointer;
	}
	/**
	 * @param monthPointer The monthPointer to set.
	 */
	public void setMonthPointer(myDate monthPointer) {
		this.monthPointer = monthPointer;
	}
	/**
	 * @return Returns the weekPointer.
	 */
	private int weekPointerCounter = 0;
	
	public myDate getWeekPointer() {
		List tempList = getWeekList();
		this.weekPointer = (myDate)tempList.get(0);
			tempList.remove(0);
		//if(tempList.size() == 0)	{
		weekPointerCounter++;
		if(weekPointerCounter >= 7)	{
			this.weekList = null;
			
			weekPointerCounter = 0;
		}
		
		return weekPointer;
	}
	/**
	 * @param weekPointer The weekPointer to set.
	 */
	public void setWeekPointer(myDate weekPointer) {
		this.weekPointer = weekPointer;
	}
	/**
	 * @return Returns the taskCount.
	 */
	public int getTaskCount() {
		return taskCount;
	}
	/**
	 * @param taskCount The taskCount to set.
	 */
	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}
}
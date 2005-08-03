/*
 * Created on 26.06.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.schedule.hibernate;

import net.sf.hibernate.*;

/**
 * @author reinhard
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HibernateManager {
	
	static Session curSession = null;
	static Transaction curTransaction = null;
	
	/**
	 * Get the current Hibernate session
	 * @return Current Hibernate session object
	 */
	public static Session getSession()
	{
		if(curSession==null)
		{
			try {
				curSession = HibernateSessionFactory.currentSession();
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
		}
		return curSession;
	}
	
	/**
	 * Finalize a Hibernate session
	 * @return
	 */
	public static boolean closeSession()
	{
		try {
			HibernateSessionFactory.closeSession();
			curSession = null;
		} catch (HibernateException e) {
			System.err.println("Fataler Hibernate Fehler! Session konnte nicht geschlossen werden!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Begins a new Hibernate Transaction
	 * @return new Hibernate Transaction object
	 */
	public static Transaction beginTransaction()
	{
		if(curTransaction==null)
		{
			if(curSession==null)
			{
				curSession = HibernateManager.getSession();
			}
			try {
				curTransaction = curSession.beginTransaction();
			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		return curTransaction;
	}
	
	/**
	 * Commits the current Hibernate Transaction
	 * @return True if commit was successful, False if something went wrong
	 */
	public static boolean commitTransaction()
	{
		if(curTransaction!=null)
		{
			try {
				curTransaction.commit();
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			curTransaction=null;
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a Hibernate Transaction is running
	 * @return
	 */
	public static boolean isInTransaction()
	{
		if(curTransaction==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Rollback a Hibernate transaction
	 * @return True if successful, false if not
	 */
	public static boolean rollbackTransaction()
	{
		if(curTransaction!=null)
		{
			try {
				curTransaction.rollback();
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		return false;
	}
	

}

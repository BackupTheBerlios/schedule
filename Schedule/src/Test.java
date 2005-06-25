/*
 * Created on Jun 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Christian Sukale
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import com.schedule.hibernate.*;

import net.sf.hibernate.*;

public class Test {

	/**
	 * 
	 */
	public Test() {
		
	}

	public static void main(String[] args) {
		
		//Objekt erzeugen
		Roles neueRolle = new Roles();
		neueRolle.setName("Admin");
		neueRolle.setDescription("Systemadministrator");
		
		try {
			//Hibernate Session erzeugen
			Session session = HibernateSessionFactory.currentSession();
			//Transaktion erzeugen
			Transaction tx = session.beginTransaction();
			//neues Objekt speichern
			session.save(neueRolle);
			//Transaktion an DB schicken
			tx.commit();
			//Debug-Ausgabe
			System.out.println("Speichervorgang erfolgreich!");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.err.println("Speichervorgang fehlgeschlagen");
			e.printStackTrace();
		} finally {
			try {
				HibernateSessionFactory.closeSession();
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
}

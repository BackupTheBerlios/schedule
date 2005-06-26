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
		
		
		
				
		try {
			//Hibernate Session erzeugen
			Session session = HibernateSessionFactory.currentSession();
			//Transaktion erzeugen
			Transaction tx = session.beginTransaction();
			
//			Objekt erzeugen
			Roles neueRolle = new Roles();
			neueRolle.setName("Admin");
			neueRolle.setDescription("Systemadministrator");
			User us = new User();
			us.setFirstname("Helmut");
			us.setCity("Berlin");
			us.setStreet("hallostreet");
			us.setLastname("Schmidt");
			us.setEmail("mail@hallo.de");
			us.setPhone("1321321");
			us.setTitle("Dr.");
			us.setZip(new Integer(23232));
			
			Login lg =  new Login();
			lg.setPasswort("test");
			lg.setScreenname("fosion");

			Preferences p = new Preferences();
			
			
			//neues Objekt speichern
			session.save(neueRolle);
			session.save(lg);
			session.save(p);
			//Rollen ID zuweisen , diese gibt es nach dem gespeichert wurde...
			
			us.setIdRole(neueRolle.getIdRole());
			us.setIdLogin(lg.getUid());
			us.setIdPreferences(p.getIdPreferences());
			us.setIdUser(lg.getUid());
			//User speichern
			//session.save(us);
			session.flush();
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

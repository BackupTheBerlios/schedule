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
			Projects neuesProjekt = new Projects();
			neuesProjekt.setName("Test-Projekt");
			neuesProjekt.setDescription("Dies ist ein Testprojekt");
			
			User neuerUser = new User();
			neuerUser.setFirstname("Christian");
			neuerUser.setLastname("Sukale");
			neuerUser.setStreet("Karower Chaussee 185");
			neuerUser.setZip(new Integer(13125));
			neuerUser.setCity("Berlin");
			
			Login neuerLogin = new Login();
			neuerLogin.setScreenname("rapid");
			neuerLogin.setPasswort("hotsauce");
			neuerLogin.setActive(new Byte("1"));
			
			neuerLogin.setUser(neuerUser);
			neuerUser.getLogins().add(neuerLogin);
			
			User neuerUser2 = new User();
			neuerUser2.setFirstname("Frank");
			neuerUser2.setLastname("Otto");
			neuerUser2.setStreet("Binzstraﬂe 52");
			neuerUser2.setZip(new Integer(13125));
			neuerUser2.setCity("Berlin");
			
			Login neuerLogin2 = new Login();
			neuerLogin2.setScreenname("fosion");
			neuerLogin2.setPasswort("franky");
			neuerLogin2.setActive(new Byte("1"));
			
			neuerLogin2.setUser(neuerUser2);
			neuerUser2.getLogins().add(neuerLogin2);
			
			neuesProjekt.getUsers().add(neuerUser);
			neuesProjekt.getUsers().add(neuerUser2);
			neuerUser.getProjects().add(neuesProjekt);
			neuerUser2.getProjects().add(neuesProjekt);
			
			//neues Objekt speichern
			session.save(neuesProjekt);
			session.save(neuerUser);
			session.save(neuerLogin);
			session.save(neuerUser2);
			session.save(neuerLogin2);
		
			//session.flush();
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

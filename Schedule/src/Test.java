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

import java.util.List;

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
			
			//Objekt erzeugen
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
			neuerUser2.setStreet("Binzstraße 52");
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
			
			tx.commit();
			
			System.out.println("#####HQL querys#############");
			
			List users = (List) session.createQuery("from User").list();
			User temp = (User)users.get(0);
					
			System.out.println(temp.getFirstname());
			
			List str = (List) session.createQuery("select us.lastname from User as us").list();
			//session.flush();
			//Transaktion an DB schicken
			System.out.println((String)str.get(0));
			//User strrr = (User) session.createQuery("from User as us where us.firstname='Christian'").list();
			//session.flush();
			//Transaktion an DB schicken
						
			//named parameter (preferred)
			Query q = session.createQuery("select usert.idUser from User usert where usert.firstname= :name");
			q.setString("name", "Christian");
			List ll = q.list();
			System.out.println((Integer)ll.get(0));
			
			//subqueries
			Query q1 = session.createQuery("from User as usert where usert.idUser = ("
					+ "select lg.user.idUser from Login lg where lg.screenname= :screen)");
			q1.setString("screen", "rapid");
			List lll = q1.list();
			temp= (User)lll.get(0);
			System.out.println(temp.getFirstname());
		
			
			System.out.println("Speichervorgang erfolgreich!");
		} catch (HibernateException e) {
			System.err.println("Speichervorgang fehlgeschlagen");
			e.printStackTrace();
		} finally {
			try {
				HibernateSessionFactory.closeSession();
			} catch (HibernateException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}

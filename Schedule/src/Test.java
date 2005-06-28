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
			// Hibernate Session erzeugen
			Session session = HibernateSessionFactory.currentSession();
			// Transaktion erzeugen
			Transaction tx = session.beginTransaction();
			

			// neues Projekt erzeugen
			Projects neuesProjekt = new Projects();
			neuesProjekt.setName("Test-Projekt");
			neuesProjekt.setDescription("Dies ist ein Testprojekt");
			
			//neuen Blackboard-Eintrag erzeugen
			Blackboard neuerBbEntry = new Blackboard();
			neuerBbEntry.setSubject("Test");
			neuerBbEntry.setBody("Dies ist ein Testeintrag am Schwarzten Brett eines Testprojekts!");
			neuerBbEntry.setProject(neuesProjekt);
			neuesProjekt.getBlackboardEntries().add(neuerBbEntry);
			
			//neue Nutzergruppe erzeugen
			Groups neueGruppe = new Groups();
			neueGruppe.setName("Developer");
			neueGruppe.setDescription("Diese Gruppe enth‰lt Softwareentwickler und Programmierer!");
			neueGruppe.setProject(neuesProjekt);
			
			//neuen User erzeugen
			User neuerUser = new User();
			neuerUser.setFirstname("Christian");
			neuerUser.setLastname("Sukale");
			neuerUser.setStreet("Karower Chaussee 185");
			neuerUser.setZip(new Integer(13125));
			neuerUser.setCity("Berlin");
			//neue Rolle erzeugen und User zuweisen
			Roles neueRolle = new Roles();
			neueRolle.setName("Systemadministrator");
			neueRolle.setDescription("Der Systemadministrator verwaltet das gesamte Schedule-System");
			neuerUser.setRole(neueRolle);
			//neuen Login erzeugen
			Login neuerLogin = new Login();
			neuerLogin.setScreenname("rapid");
			neuerLogin.setPasswort("hotsauce");
			neuerLogin.setActive(new Byte("1"));
			//Login an User binden und umgekehrt
			neuerUser.setLogin(neuerLogin);
			//noch einen neuen User erzeugen
			User neuerUser2 = new User();
			neuerUser2.setFirstname("Frank");
			neuerUser2.setLastname("Otto");
			neuerUser2.setStreet("Binzstraﬂe 52");
			neuerUser2.setZip(new Integer(13125));
			neuerUser2.setCity("Berlin");
			//dem User eine Rolle zuweisen
			neuerUser2.setRole(neueRolle);
			
			//noch einen neuen Login erzeugen
			Login neuerLogin2 = new Login();
			neuerLogin2.setScreenname("fosion");
			neuerLogin2.setPasswort("franky");
			neuerLogin2.setActive(new Byte("1"));
			//Login an User binden und umgekehrt
			neuerUser2.setLogin(neuerLogin2);
			//die User an die Projekte binden und umgekehrt
			neuesProjekt.getUsers().add(neuerUser);
			neuesProjekt.getUsers().add(neuerUser2);
			neuerUser.getProjects().add(neuesProjekt);
			neuerUser2.getProjects().add(neuesProjekt);
			
			//die User der Nutzergruppe zuweisen
			neueGruppe.getUser().add(neuerUser);
			neueGruppe.getUser().add(neuerUser2);
			neuerUser.getGroups().add(neueGruppe);
			neuerUser2.getGroups().add(neueGruppe);
			
			
			//neue Nachricht erzeugen
			Messages neueMsg = new Messages();
			neueMsg.setRecipient("rapid");
			neueMsg.setSubject("Test");
			neueMsg.setBody("Hi rapid, wollte nur mal testen ob es funktioniert");
			//Nachricht an User binden und umgekehrt
			neueMsg.setUser(neuerUser2); //Frank schickt mit eine Nachricht ;-)
			neuerUser2.getMessages().add(neueMsg);
			
			//neuen Termin erzeugen
			Appointments neuerTermin = new Appointments();
			neuerTermin.setSubject("Testtermin");
			neuerTermin.setDescription("Dies ist ein Testtermin!");
			//Termin an User binden und umgekehrt
			neuerTermin.setUser(neuerUser);
			neuerUser.getAppointments().add(neuerTermin);
			//Termin an Projekt binden
			neuerTermin.setProject(neuesProjekt);
			
			//neue Aufgabe erzeugen
			Tasks neuerTask = new Tasks();
			neuerTask.setSubject("Test");
			neuerTask.setDescription("Dies ist eine Testaufgabe!");
			//Aufgabe an User binden und umgekehrt
			neuerTask.setUser(neuerUser);
			neuerUser.getTasks().add(neuerTask);
			//Aufgabe an Projekt binden
			neuerTask.setProject(neuesProjekt);
			
			//neue Preference erzeugen
			Preferences neuePref = new Preferences();
			neuePref.setUser(neuerUser);
			neuerUser.getPreferences().add(neuePref);
			
			//alle neuen Objekte speichern
			session.save(neuesProjekt);
			session.save(neuerBbEntry);
			session.save(neueRolle);
			session.save(neuerLogin);
			session.save(neuerLogin2);
			session.save(neuerUser);
			session.save(neuerUser2);
			session.save(neueGruppe);
			session.save(neueMsg);
			session.save(neuerTermin);
			session.save(neuerTask);
			session.save(neuePref);
		
			session.flush();

			
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
			
			/*
			//subqueries
			Query q1 = session.createQuery("from User as usert where usert.idUser = ("
					+ "select lg.user.idUser from Login lg where lg.screenname= :screen)");
			q1.setString("screen", "rapid");
			List lll = q1.list();
			temp= (User)lll.get(0);
			System.out.println(temp.getFirstname());
			*/
			
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

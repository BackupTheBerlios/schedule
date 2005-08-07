/*
 * Created on Jun 26, 2005
 *
 */

/**
 * @author Christian Sukale
 * 
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

	public static void main(String[] args) 
	{
		
		//Hier den Test-Case implementieren
		Session session = HibernateManager.getSession();
		List userList = null;
		Query q;
		
		try {
			q = session.createQuery("from User where idUser= :idUser");
			q.setString("idUser", "14");
			userList = (List) q.list();			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		User user = (User) userList.get(0);
		java.util.Set projects = user.getProjects();
		Object[] projekte = projects.toArray();
		System.out.println("Name des Projekts: " +((Projects)projekte[0]).getName());
	}
}

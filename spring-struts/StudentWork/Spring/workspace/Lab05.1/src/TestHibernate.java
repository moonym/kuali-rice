/*
 *
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2008 LearningPatterns Inc.
 */

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.javatunes.persist.MusicItem;

public class TestHibernate {
	

	public static void main(String[] args) {

		SessionFactory sf = null;
		Session s = null;

		try {
			sf = new Configuration().configure().buildSessionFactory();
			s = sf.openSession();
			
			System.out.println("Session connect status: " + s.isConnected());
			
			s.isConnected();
/*			
			Long id= new Long(1);
			MusicItem mItem = (MusicItem)s.get(MusicItem.class,  id);
			System.out.println("Retrieved MusicItem with Num: " + mItem.getNum());
			//String oldTitle = mItem.getTitle();
			mItem.setTitle("Hibernate Really Rocks");

			tx.commit();
			System.out.println(mItem.getTitle());
*/
			test(s);
			
			s.close();
			sf.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		catch (Exception ex) { ex.printStackTrace(); }
	}

	public static void test(Session s){
		Transaction tx = s.beginTransaction();
		Query q = s.createQuery("FROM MusicItem WHERE id > 10");
		List l = q.list();
		for(Object curObject: l){
			System.out.println(curObject);
		}
		tx.commit();
	}
	
	
	

}

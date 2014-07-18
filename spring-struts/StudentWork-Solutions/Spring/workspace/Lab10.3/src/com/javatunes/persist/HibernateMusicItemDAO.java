/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.persist;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMusicItemDAO implements MusicItemDAO
{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
	  sessionFactory = sf;
	}
	public SessionFactory getSessionFactory() {
	  return sessionFactory;
	}
	
   public MusicItem searchById(Long id) {
	   Session s = getSessionFactory().getCurrentSession();
	  MusicItem ret = (MusicItem)s.get(MusicItem.class, id); 
      return ret;
   }   

   public void create(MusicItem item) {
	 Session s = getSessionFactory().getCurrentSession();
	 s.save(item);
   }
	
   public Collection<MusicItem> searchByKeyword(String keyword) {
	   // create the %keyword% wildcard syntax used in SQL LIKE operator
	   String wildcarded = "%" + keyword + "%";
	   Session s = getSessionFactory().getCurrentSession();
	   // Using a regular query
	   // Query q = s.createQuery("FROM MusicItem m WHERE m.title LIKE :keyword OR m.artist LIKE :keyword");
	   // Optional part - named query
	   Query q = s.getNamedQuery("MusicItem.findByKeyword");
	   q.setString("keyword", wildcarded);
	   return (Collection<MusicItem>)q.list();
	}
   
	public void delete(MusicItem item) {
		Session s = getSessionFactory().getCurrentSession();
		s.delete(item);
	}
	
	public void merge(MusicItem item) {
		Session s = getSessionFactory().getCurrentSession();
		s.merge(item);
	}
   
	public void test() {
		Session s = getSessionFactory().getCurrentSession();
		
		// LEFT JOIN FETCH query
		Transaction tx = s.beginTransaction();
		System.out.println("*** Querying with LEFT JOIN FETCH ***");
		String query = "SELECT m FROM MusicItem m LEFT JOIN FETCH " +
        	"m.inventoryRecords WHERE m.id = :id";
		Query q = s.createQuery(query);
		q.setLong("id",new Long(1));
		List l = q.list();
		System.out.println("Size of list = " + l.size());
		HashSet<MusicItem> hs = new HashSet<MusicItem>(l);
		System.out.println("Size of hashSet = " + hs.size());
		MusicItem m = (MusicItem)hs.iterator().next();
		for (Inventory cur : m.getInventoryRecords()) {
			System.out.println(cur);
		}
		tx.commit();
		System.out.println("*** END Querying with LEFT JOIN FETCH ***");
		
		// Optional query to get locations
		s = getSessionFactory().getCurrentSession();
		tx = s.beginTransaction();
		query = "SELECT i.location FROM MusicItem mi JOIN mi.inventoryRecords i where mi.id = :id"; 
		q = s.createQuery(query);
		q.setLong("id",new Long(1));
		System.out.println("*** Locations for MusicItem 1 ***");
		for (Object cur : q.list()) {
			System.out.println(cur);
		}
		tx.commit();
		System.out.println("*** End Locations for MusicItem 1 ***");
				

	}
}

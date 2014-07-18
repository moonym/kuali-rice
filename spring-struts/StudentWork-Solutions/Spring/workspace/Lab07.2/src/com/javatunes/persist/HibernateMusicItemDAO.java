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
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
   
	public void test() {
		Session s = getSessionFactory().getCurrentSession();
		System.out.println("*** Query all MusicItems Where id>10 ***");
		Query q = s.createQuery("FROM MusicItem m WHERE id>10");
		List resultList = q.list();
		for (Object curObject : resultList) {
			MusicItem cur = (MusicItem)curObject;
			System.out.println("id>10 query retrieved Num: " + cur.getNum());
		}

		System.out.println("*** Pagination - first 5 then next 5 where id>10 ***");
		q.setFirstResult(0);
		q.setMaxResults(5);
		System.out.println("--- First 5 results");
		resultList = q.list();
		for (Object curObject : resultList) {
			MusicItem cur = (MusicItem)curObject;
			System.out.println("id>10 query retrieved Num: " + cur.getNum());
		}
		q.setFirstResult(5);
		q.setMaxResults(5);
		System.out.println("--- Second 5 results");
		resultList = q.list();
		for (Object curObject : resultList) {
			MusicItem cur = (MusicItem)curObject;
			System.out.println("id>10 query retrieved Num: " + cur.getNum());
		}
		
		System.out.println("*** Select artist, title for all items ***");
		Query q4 = s.createQuery("SELECT m.artist, m.title FROM MusicItem m");
	    resultList = q4.list();
	    for (Object curObject : resultList) {
	    	Object[] cur = (Object[])curObject;
	    	System.out.println("Title, artist " + cur[0] + "," + cur[1]);
	    }
		
		System.out.println("*** Count(m) for id>10 ***");
		Query q5 = s.createQuery("SELECT count(m) FROM MusicItem m WHERE id>10");
		Long count = (Long)q5.uniqueResult();
		System.out.println("Num retrieved with count(m) id>10 query = " + count);

		System.out.println("*** Artist, avergage price grouped by artist ***");
		Query q6 = s.createQuery("SELECT m.artist, avg(m.price) FROM MusicItem m GROUP BY m.artist");
	    resultList = q6.list();
	    for (Object curObject : resultList) {
	    	Object[] cur = (Object[])curObject;
	    	System.out.println("Artist, average price " + cur[0] + "," + cur[1]);
	    }		
	}
}

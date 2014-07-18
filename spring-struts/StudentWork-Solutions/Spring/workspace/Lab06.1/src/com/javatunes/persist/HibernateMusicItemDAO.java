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
     // TODO
   }
	
   public Collection<MusicItem> searchByKeyword(String keyword) {
      // create the %keyword% wildcard syntax used in SQL LIKE operator
      String wildcarded = "%" + keyword + "%";
      // TODO: 
      return null;
	}
	
	public void delete(MusicItem item) {
	  // TODO - Finish delete
	}	
}

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
import org.hibernate.cfg.Configuration;

public class HibernateMusicItemDAO implements MusicItemDAO
{

	private static final String FIND_BY_KEYWORD = "TODO";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
	  sessionFactory = sf;
	}
	public SessionFactory getSessionFactory() {
	  return sessionFactory;
	}
	
   public MusicItem searchById(Long id) {
	  // TODO - Finish searchById
      return null;
   }   

   public void create(MusicItem item) {
     // TODO - finish create
   }
	
   public Collection<MusicItem> searchByKeyword(String keyword) {
      // create the %keyword% wildcard syntax used in SQL LIKE operator
      String wildcarded = "%" + keyword + "%";
      // TODO - finish searchByKeyword
      return null;
	}
	
	public void delete(MusicItem item) {
	  // TODO - Finish delete
	}	
}

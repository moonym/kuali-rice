/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.persist;

import java.sql.*;
import java.util.Collection;
import java.math.BigDecimal;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringHibernateTest
{
   public static void main(String[] args) throws Exception
   {
		String[] configFiles = {"beans.xml"};
		ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext( configFiles );
		System.out.println("Created container");
		
		MusicItemDAO dao = null; // TODO - Look up DAO by name "musicItemDAO"
		SessionFactory sf = null; // TODO - Look up session factory by name "javatunesSessionFactory"
      try
      {         
         // test searchById
		 System.out.println("*** searchById = 2 ***");
		 sf.getCurrentSession().beginTransaction();
		 
         MusicItem item = null; // TODO - Lookup item via dao.searchById method
         
         sf.getCurrentSession().getTransaction().commit();
         System.out.println(item);
		 System.out.println("*** searchById = 2 ***\n");

      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}

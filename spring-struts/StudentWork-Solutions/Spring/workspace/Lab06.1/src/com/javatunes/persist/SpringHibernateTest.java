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

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringHibernateTest
{
   public static void main(String[] args) throws Exception
   {
		String[] configFiles = {"beans.xml"};
		ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext( configFiles );
		System.out.println("Created container");
		
		MusicItemDAO dao = (MusicItemDAO)ctx.getBean("musicItemDAO");
		SessionFactory sf = (SessionFactory)ctx.getBean("javatunesSessionFactory");
      try
      {         
         // test searchById
		 System.out.println("*** searchById = 2 ***");
		 sf.getCurrentSession().beginTransaction();
         MusicItem item = dao.searchById(new Long(2));
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

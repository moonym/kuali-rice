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

			// Lookup an item - print out its version 
			sf.getCurrentSession().beginTransaction();
			MusicItem m1 = dao.searchById(1L);
			System.out.println("*** version ***");
			System.out.println("Item with id = 1 has version: " + m1.getVersion());
			sf.getCurrentSession().getTransaction().commit();
			
			// Lookup up same item and modify
			sf.getCurrentSession().beginTransaction();
			MusicItem m2 = dao.searchById(1L);
			m2.setTitle(m2.getTitle() + "x");
			sf.getCurrentSession().getTransaction().commit();
			
			// Lookup the item - print out its version again (should be different)
			sf.getCurrentSession().beginTransaction();
			MusicItem m3 = dao.searchById(1L);
			System.out.println("*** version ***");
			System.out.println("Item with id = 1 has version: " + m3.getVersion());
			sf.getCurrentSession().getTransaction().commit();	
			
			// Merge in m1 - should FAIL!!
			sf.getCurrentSession().beginTransaction();
			dao.merge(m1);
			sf.getCurrentSession().getTransaction().commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

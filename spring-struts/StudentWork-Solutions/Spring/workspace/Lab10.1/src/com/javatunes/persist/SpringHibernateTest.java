/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.persist;

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

			// Lookup an item - print out its band members
			sf.getCurrentSession().beginTransaction();
			MusicItem m1 = dao.searchById(10L);
			System.out.println("*** Band Members ***");
			System.out.println("Item with id = 10 has members: ");
			for (String member : m1.getBandMembers()) {
				System.out.println(member);
			}
			sf.getCurrentSession().getTransaction().commit();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.persist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.service.ItemService;

class SpringHibernateTest
{
	public static void main(String[] args) throws Exception
	{
		String[] configFiles = {"beans.xml"};
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext( configFiles );
		System.out.println("Created container");

		ItemService itemService = (ItemService)ctx.getBean("itemService", ItemService.class);
		
		try
		{         

			// Run the transaction test method
			try {
				System.out.println("Calling runTest");
				itemService.runTest();
			} catch (Exception e) {
				System.out.println("Exception thrown in ItemServiceImpl: " + e.getMessage());
			}

			// Check the results 
			itemService.checkResults();
	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

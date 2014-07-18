/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.jdbc;

import java.sql.*;
import java.util.Collection;
import java.math.BigDecimal;
import com.javatunes.util.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringJDBCTest
{
   public static void main(String[] args)
   {
		String[] configFiles = {"beans.xml"};
		ClassPathXmlApplicationContext ctx = 
			new ClassPathXmlApplicationContext( configFiles );
		System.out.println("Created container");
		MusicItemDAO dao = (MusicItemDAO)ctx.getBean("musicItemDAO");
		
         // test searchById
		 System.out.println("*** searchById = 2 ***");
         MusicItem item = dao.searchById(new Long(2));
         System.out.println(item);
		 System.out.println("*** searchById = 2 finished ***\n");
		 
		 // test create
		 System.out.println("*** create ***");
         MusicItem createItem1 = new MusicItem(null, "CD522", "Ride the Lightning", 
		    "Metallica", Date.valueOf("1984-09-16"), 
			new BigDecimal("9.99"), new BigDecimal("7.77"));
		 dao.create(createItem1);
		 System.out.println("*** create finished ***\n");
		 
         // test searchByKeyword
         System.out.println("*** searchByKeyword = a ***");
         Collection results = dao.searchByKeyword("a");
		 for (Object curItem : results) {
            System.out.println(curItem);
         }
		 System.out.println("*** searchByKeyword = a finished ***\n");		 
   }
}

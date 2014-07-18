/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */
 
package com.javatunes.jdbc;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;

import com.javatunes.util.*;

class JDBCTest
{
   public static void main(String[] args)
   {
      // Sspecify database driver and URL
      String driver = "org.apache.derby.jdbc.ClientDriver";
      String url = "jdbc:derby://localhost:1527/JavaTunesDB";
      String usr = "guest";
      String passwd = "password";

      // Declare Connection here so we have access to it in finally
      Connection conn = null;

      // Prepared Statement Lab declare DAO here so we have access to it in finally
      ItemDAO dao = null;
      
      try
      {         
         // Load the JDBC driver class - this can throw ClassNotFoundException
         Class.forName(driver);
         
         // Connect to the database - this can throw SQLException
         conn = DriverManager.getConnection(url,usr,passwd);
         dao = new ItemDAO(conn);         
         // Print database metadata
         // JDBCUtilities.printDatabaseMetaData(conn.getMetaData());
         
         // Check for warnings
         // JDBCUtilities.checkForWarnings(conn.getWarnings());
         
         // Test ItemDAO.searchById
         long searchId = 1;
         if (args.length > 0) searchId = Long.parseLong(args[0]);
         MusicItem item = dao.searchById(searchId);
         System.out.println(item);  
      
         // Prepared Statement Lab - test ItemDAO.searchByKeyword
         String searchKeyword = "Madonna";
         if (args.length > 0) searchKeyword = args[0];
         Collection<MusicItem> results = dao.searchByKeyword(searchKeyword);
         for (Object cur : results) {
            MusicItem curItem = (MusicItem) cur;
            System.out.println(curItem);
         } 

         // Lab 5 - test ItemDAO.create
         dao = new ItemDAO(conn);
         
         // this value object has all 6 values
         MusicItem createItem1 = new MusicItem(22L, "Ride the Lightning", "Metallica",
            "1984-09-16", new BigDecimal("9.99"), new BigDecimal("7.77"));         
         
         // the Java null values should become SQL NULL values in the database
         MusicItem createItem2 = new MusicItem(23L, null, null, "2008-01-01", null, null);  // PK cannot be NULL
         
         dao.create(createItem1);
         dao.create(createItem2);
         
         System.out.println("\n*** Created itemds with ids = 22 and 23.  Searching the DB now to see if they are there *** ");
         
         // see if the data were inserted into the DB properly
         MusicItem testItem1 = dao.searchById(createItem1.getId());
         MusicItem testItem2 = dao.searchById(createItem2.getId());
         System.out.println(testItem1);
         System.out.println(testItem2);         
      }
      catch (ClassNotFoundException e)
      {
         System.out.println(e);
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
      finally
      {
         try
         {
            // Close connection
            if (conn != null)
            {
               conn.close();
               System.out.println("Connection closed.");
            }
         }
         catch (SQLException ignored) {  }
      }
   }
}

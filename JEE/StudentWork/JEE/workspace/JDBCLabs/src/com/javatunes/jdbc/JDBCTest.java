/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */
 
package com.javatunes.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;

import com.javatunes.util.*;

class JDBCTest
{
   public static void main(String[] args) throws NumberFormatException, IOException, SQLException
   {
      // Sspecify database driver and URL
      String driver = "org.apache.derby.jdbc.ClientDriver";
      String url = "jdbc:derby://localhost:1527/JavaTunesDB";
      String usr = "guest";
      String passwd = "password";
      
      // Declare Connection here so we have access to it in finally
      Connection conn = null;
      ItemDAO ItemRow = null;
      try
      {         
         // Load the JDBC driver class - this can throw ClassNotFoundException
         Class.forName(driver);
         
         // Connect to the database - this can throw SQLException
         conn = DriverManager.getConnection(url,usr,passwd);
		 ItemRow = new ItemDAO(conn);
		 
		 // Indicate that we successfully connected
         System.out.println("Connected");
         System.out.print("Please enter the ID you wish to find: ");
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         long id = Long.parseLong(br.readLine());
         // Instantiate ItemDAO
         MusicItem result = ItemRow.searchById(id);
         
         // Get metadata and print
         DatabaseMetaData dbmd = conn.getMetaData();
         SQLWarning sqlWarn = conn.getWarnings();
         JDBCUtilities.printDatabaseMetaData(dbmd);
         JDBCUtilities.checkForWarnings(sqlWarn);
         
         //Print out result from ItemDAO ItemRow
         System.out.println("ID: "+result.getId());
         System.out.println("Title: "+result.getTitle());
         System.out.println("Artist: "+result.getArtist());
         System.out.println("Release Date: "+result.getReleaseDate());
         System.out.println("List Price: "+result.getListPrice());
         System.out.println("Price: "+result.getPrice());
         System.out.println('\n');
         //Search By Keyword
         Collection<MusicItem> cResult = ItemRow.searchByKeyword("Madonna");
         for(Object currItem: cResult){
        	 MusicItem cur = (MusicItem) currItem;
        	 System.out.println("=====================");
        	 System.out.println("ID: "+cur.getId());
             System.out.println("Title: "+cur.getTitle());
             System.out.println("Artist: "+cur.getArtist());
             System.out.println("Release Date: "+cur.getReleaseDate());
             System.out.println("List Price: "+cur.getListPrice());
             System.out.println("Price: "+cur.getPrice());
             
         }
         
         MusicItem newInsert = new MusicItem(22L,"Ride the Lightning", "Metallica","1984-09-16",new BigDecimal("9.99"), new BigDecimal("7.77"));
         ItemRow.create(newInsert);
         MusicItem testInsert = ItemRow.searchById(newInsert.getId());
         System.out.println(testInsert);
      }
      catch (ClassNotFoundException e)
      {
         System.out.println(e);
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
      finally{
    	  
    	  try {
    		  if (ItemRow != null){
    			  ItemRow.close();
    		  }
    		  if (conn != null){
    			  conn.close();
    			  System.out.println("Connection closed");
    		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
   }
}

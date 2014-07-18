/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */
 
package com.javatunes.jdbc;

import java.sql.*;
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
      
      try
      {         
         // Load the JDBC driver class - this can throw ClassNotFoundException
         Class.forName(driver);
         
         // Connect to the database - this can throw SQLException
         conn = DriverManager.getConnection(url,usr,passwd);
         
         // Print database metadata
         JDBCUtilities.printDatabaseMetaData(conn.getMetaData());
         
         // Check for warnings
         JDBCUtilities.checkForWarnings(conn.getWarnings());
         
         // Test ItemDAO.searchById
         long searchId = 1;
         if (args.length > 0) searchId = Long.parseLong(args[0]);
         ItemDAO dao = new ItemDAO(conn);
         MusicItem item = dao.searchById(searchId);
         System.out.println(item);         
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

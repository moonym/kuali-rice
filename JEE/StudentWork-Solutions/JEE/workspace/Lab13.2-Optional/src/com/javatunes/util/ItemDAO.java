/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */

package com.javatunes.util;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ItemDAO
{
   // connection to the database (assumed to be open)
   private Connection m_conn = null;
   
   //// PreparedStatement Lab ////
   //-- declare the PreparedStatement for searchByKeyword --//
   private PreparedStatement m_pstmtKeyword = null; 
   
   // PreparedStatement Lab -Optional
   // declare the PreparedStatement for searchById
   private PreparedStatement m_pstmtId = null;
   
   //// Update Lab ////
   //-- declare the PreparedStatement for create --//
   
   
   
   // constructor
   public ItemDAO(Connection conn)
   throws SQLException
   {
      // store the connection
      m_conn = conn;
      
      //// PreparedStatement Lab ////
      //-- define the ?-SQL for searchByKeyword --//
      String sqlKeyword = "SELECT ITEM_ID, Title, Artist, ReleaseDate, ListPrice, Price " +
      "FROM Item WHERE Title LIKE ? OR Artist LIKE ?";         
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      m_pstmtKeyword = m_conn.prepareStatement(sqlKeyword);
      
      // PreparedStatement Lab - Optional
      // define the ?-SQL for searchById
      String sqlId = "SELECT Title, Artist, ReleaseDate, ListPrice, Price " +
         "FROM Item WHERE ITEM_ID = ?";
      
      // prepare the ?-SQL with the DBMS and initialize the PreparedStatement
      m_pstmtId = m_conn.prepareStatement(sqlId);      
      
      //// Update Lab ////
      //-- define the ?-SQL for create --//
      
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      
   }
   
   
   //// DAO Lab ////
   public MusicItem searchById(Long id)
   throws SQLException
   {
      // declare return value
      MusicItem result = null;
      
      // set the ? parameter on the PreparedStatement
      m_pstmtId.setLong(1, id);
      
      // execute the PreparedStatement, get a ResultSet back
      ResultSet rs = m_pstmtId.executeQuery();
      
         //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
         //-- if ID not found, the return value remains null --//
         if (rs.next())    // ID found
         {
            // extract data from the ResultSet
            String     title       = rs.getString("Title");
            String     artist      = rs.getString("Artist");
            Date       releaseDate = rs.getDate("ReleaseDate");
            BigDecimal listPrice   = rs.getBigDecimal("ListPrice");
            BigDecimal price       = rs.getBigDecimal("Price");
            
            // initialize the return value
            result = new MusicItem(id, title, artist, releaseDate, listPrice, price);
         }
      // return the value object
      return result;
   }
   
   
   //// PreparedStaement Lab ////
   public Collection<MusicItem> searchByKeyword(String keyword)
   throws SQLException
   {
	   // create storage for the results
	   Collection<MusicItem> result = new ArrayList<MusicItem>();

	   // create the %keyword% wildcard syntax used in SQL LIKE operator
	   String wildcarded = "%" + keyword + "%";

	   //-- set the ? parameters on the PreparedStatement --//
	   m_pstmtKeyword.setString(1, wildcarded);
	   m_pstmtKeyword.setString(2, wildcarded);      

	   //-- execute the PreparedStatement, get a ResultSet back --//
	   ResultSet rs = m_pstmtKeyword.executeQuery();      

	   //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
	   //-- add the ItemValue to the Collection via Collection's add method --//
	   while (rs.next())
	   {
		   // extract data from each row, create an ItemValue from it, add to Collection
		   Long       id          = rs.getLong("ITEM_ID");
		   String     title       = rs.getString("Title");
		   String     artist      = rs.getString("Artist");
		   Date       releaseDate = rs.getDate("ReleaseDate");
		   BigDecimal listPrice   = rs.getBigDecimal("ListPrice");
		   BigDecimal price       = rs.getBigDecimal("Price");

		   MusicItem item = new MusicItem(id, title, artist, releaseDate, listPrice, price);
		   result.add(item);
	   }

	   // return the Collection
	   return result;
   }
   
   
   //// Update Lab ////
   public void create(MusicItem item)
   throws SQLException
   {
      java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
      //-- set the ? parameters on the PreparedStatement --//
      
      
      //-- execute the PreparedStatement - ignore the update count --//
      
   }
   
   
   //// PreparedStatement and Update Labs ////
   public void close()
   {
      try
      {
         //// PreparedStatement Lab ////
         //-- close the PreparedStatement for searchByKeyword --//
    	  m_pstmtKeyword.close();
         
         //// Update Lab ////
         //-- close the PreparedStatement for create --//
         
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
   }
}

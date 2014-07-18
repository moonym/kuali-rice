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
   private PreparedStatement pstmt = null;
   
   //// Update Lab ////
   //-- declare the PreparedStatement for create --//
   private PreparedStatement cPstmt = null;
   
   
   // constructor
   public ItemDAO(Connection conn)
   throws SQLException
   {
      // store the connection
      m_conn = conn;
      
      //// PreparedStatement Lab ////
      //-- define the ?-SQL for searchByKeyword --//
      String pSQL = "SELECT ITEM_ID, Title, Artist, ReleaseDate, ListPrice, Price FROM Item WHERE Title LIKE ? OR Artist LIKE ?";
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      pstmt = m_conn.prepareStatement(pSQL);
      
      //// Update Lab ////
      //-- define the ?-SQL for create --//
      String cSQL = "INSERT INTO Item (ITEM_ID, Title, Artist, ReleaseDate, ListPrice, Price) VALUES (?,?,?,?,?,?)";
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      cPstmt = m_conn.prepareStatement(cSQL);
   }
   
   
   //// DAO Lab ////
   public MusicItem searchById(Long id)
   throws SQLException
   {
      // declare return value
      MusicItem result = null;
      
      // declare JDBC objects
      Statement stmt = null;
      
      //-- build the SQL statement --//
      String sqlStmt ="SELECT Title, Artist, ReleaseDate, ListPrice, Price FROM Item WHERE ITEM_ID = " + id;
      
      try
      {
         //-- initialize the Statement object --//
         stmt = m_conn.createStatement();
         
         //-- execute the SQL statement, get a ResultSet back --//
         ResultSet rs = stmt.executeQuery(sqlStmt);
         
         //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
         //-- if ID not found, the return value remains null --//
         if(rs.next()){
        	 String title = rs.getString("Title");
        	 String artist = rs.getString("Artist");
        	 Date releaseDate = rs.getDate("ReleaseDate");
        	 BigDecimal listPrice = rs.getBigDecimal("ListPrice");
        	 BigDecimal price = rs.getBigDecimal("Price");
        	 
        	 result = new MusicItem(id,title,artist,releaseDate,listPrice,price);
         }
      }
      finally
      {
         //-- close the Statement - this closes its ResultSet --//
         stmt.close();
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
	  pstmt.setString(1,wildcarded);
	  pstmt.setString(2,wildcarded);
	  
	  //-- execute the PreparedStatement, get a ResultSet back --//
	  ResultSet rs = pstmt.executeQuery();
	  
	  //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
	  //-- add the ItemValue to the Collection via Collection's add method --//
	  while(rs.next()){
		  MusicItem newMusicItem = new MusicItem(rs.getLong("ITEM_ID"),rs.getString("Title"),rs.getString("Artist"),rs.getDate("ReleaseDate"),rs.getBigDecimal("ListPrice"),rs.getBigDecimal("Price"));
		  result.add(newMusicItem);
	  }
	
      
      // return the Collection
      return result;
   }
   
   
   //// Update Lab ////
   public void create(MusicItem item)
   throws SQLException
   {
	  // Use the following releaseDate value in the  prepared statement for setDate
	  java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
      //-- set the ? parameters on the PreparedStatement --//
      cPstmt.setLong(1,item.getId());
      cPstmt.setString(2, item.getTitle());
      cPstmt.setString(3, item.getArtist());
      cPstmt.setDate(4, releaseDate);
      cPstmt.setBigDecimal(5, item.getListPrice());
      cPstmt.setBigDecimal(6, item.getPrice());
      
      //-- execute the PreparedStatement - ignore the update count --//
      int i = cPstmt.executeUpdate();
      
   }
   
   
   //// PreparedStatement and Update Labs ////
   public void close()
   {
     
      try
      {
         //// PreparedStatement Lab ////
         //-- close the PreparedStatement for searchByKeyword --//
         pstmt.close();
         
         //// Update Lab ////
         //-- close the PreparedStatement for create --//
         cPstmt.close();
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
   }
}

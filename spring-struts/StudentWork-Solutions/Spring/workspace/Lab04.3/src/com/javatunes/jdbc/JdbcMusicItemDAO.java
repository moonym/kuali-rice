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

import com.javatunes.util.MusicItem;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

// TODO extend the SimpleJdbcDaoSupport class
public class JdbcMusicItemDAO extends SimpleJdbcDaoSupport implements MusicItemDAO
{

      private static final String INSERT = "INSERT INTO Item (NUM, Title, Artist, ReleaseDate, ListPrice, Price) VALUES (?, ?, ?, ?, ?, ?)";

	  private static final String SELECT_ALL_PROPS = "SELECT ITEM_ID, NUM, Title, Artist, ReleaseDate, ListPrice, Price FROM Item ";
	  
      private static final String FIND_BY_KEYWORD = SELECT_ALL_PROPS + " WHERE Title LIKE ? OR Artist LIKE ?";      
	  
      private static final String FIND_BY_ID = SELECT_ALL_PROPS + " WHERE ITEM_ID = ?";   
   
	private static final class MIRowMapper implements ParameterizedRowMapper<MusicItem> {
		public MusicItem mapRow(ResultSet rs, int rowNum) throws SQLException {
	         // extract data from the ResultSet
			 Long       id  		= rs.getLong("ITEM_ID");
			 String     num			= rs.getString("NUM");
			 String     title       = rs.getString("Title");
	         String     artist      = rs.getString("Artist");
	         Date       releaseDate = rs.getDate("ReleaseDate");
	         BigDecimal listPrice   = rs.getBigDecimal("ListPrice");
	         BigDecimal price       = rs.getBigDecimal("Price");
	         
	         // initialize the return value
	         return new MusicItem(id, num, title, artist, releaseDate, listPrice, price);
     }
   }
   
   public MusicItem searchById(Long id) {
	  return getSimpleJdbcTemplate().queryForObject (
	     FIND_BY_ID, new MIRowMapper(), id);
   }   

   public void create(MusicItem item) {
     getSimpleJdbcTemplate().update(INSERT, item.getNum(), item.getTitle(), 
		item.getArtist(), item.getReleaseDate(), item.getListPrice(), item.getPrice());
	}
	
   public Collection<MusicItem> searchByKeyword(String keyword) {
      // create the %keyword% wildcard syntax used in SQL LIKE operator
      String wildcarded = "%" + keyword + "%";
	  return getSimpleJdbcTemplate().query(FIND_BY_KEYWORD, new MIRowMapper(), wildcarded, wildcarded);
   }	
   
}

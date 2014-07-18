/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-9 LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatunes.util.MusicItem;
import com.javatunes.util.SearchUtility;

public class SearchServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0,
	 *      HttpServletResponse arg1)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Read parameter from HTML form
	      String keyword = request.getParameter("keyword");

	      // Do the search, get an Iterator to go through the Collection
	      Collection<MusicItem> results = SearchUtility.findByKeyword(keyword);

	      // Set content-type and get PrintWriter
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      // Send back some HTML
	      out.println("<HTML>");
	      out.println("<HEAD><TITLE>Search Results</TITLE></HEAD>");
	      out.println("<BODY>");
	      out.println("<P>Search results for keyword <B>" + keyword + "</B>:<BR>");

	      // Send back search results
	      for (MusicItem item : results) {
	         out.println(item.getId() + " " + item.getTitle() + " " + item.getArtist() + " " +
	            item.getReleaseDateString() + " " + item.getListPrice() + " " + item.getPrice() + "<BR>");
	      }

	      // Close out the HTML tags
	      out.println("</BODY>");
	      out.println("</HTML>");

	      // Close the PrintWriter
	      out.close();

	}
}
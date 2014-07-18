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

		  // Make sure we get a keyword parameter
	      if (keyword == null)  {
	         this.getServletContext().getRequestDispatcher("/").
	            forward(request, response);
	      } else {
	         // Do the search, store results in request with name "results"
	         Collection<MusicItem> results = SearchUtility.findByKeyword(keyword.trim());
	         request.setAttribute("results", results);
	         
	         request.setAttribute("size", results.size() );

	         // Forward to /jsp/searchResults.jsp for display
	         this.getServletContext().getRequestDispatcher("/jsp/searchResults.jsp").
	            forward(request, response);
	      }
	}
}
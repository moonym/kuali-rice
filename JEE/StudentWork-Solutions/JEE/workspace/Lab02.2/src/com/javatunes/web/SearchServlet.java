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

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet implements Servlet {

    private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Set content-type and get PrintWriter
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();

	      // Send back some HTML
	      out.println("<HTML>");
	      out.println("<HEAD><TITLE>Search Results</TITLE></HEAD>");
	      out.println("<BODY>");
	      out.println("<P>Search Results: (not implemented yet)");
	      out.println("</BODY>");
	      out.println("</HTML>");

	      // Close the PrintWriter
	      out.close();
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
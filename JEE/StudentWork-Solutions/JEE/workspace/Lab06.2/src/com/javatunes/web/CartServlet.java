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
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
	}

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // read the parameter from the "Add to Cart" link
	      String itemID = request.getParameter("itemID");

	      // forward to /jsp/cartDisplay.jsp
	      this.getServletContext().getRequestDispatcher("/jsp/cartDisplay.jsp").
	         forward(request, response);
	}

}
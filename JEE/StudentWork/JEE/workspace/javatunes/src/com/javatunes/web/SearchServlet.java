package com.javatunes.web;
import com.javatunes.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatunes.util.SearchUtility;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String browser = request.getHeader("User-Agent");
		String keyword = request.getParameter("keyword");
		
		/*
		Enumeration headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String headerName = (String) headers.nextElement();
		}
		*/
		Collection<MusicItem> resultSet = SearchUtility.findByKeyword(keyword);
		request.setAttribute("results", resultSet);
		request.setAttribute("size", resultSet.size());
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/searchResults.jsp");
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}

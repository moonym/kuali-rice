package com.javatunes.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javatunes.util.MusicItem;
import com.javatunes.util.SearchUtility;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String itemID = request.getParameter("itemID");
		request.setAttribute("itemID",itemID);
		
		Collection<MusicItem> cart = (Collection<MusicItem>) session.getAttribute("cart");
		if (cart == null) cart = new java.util.ArrayList();
		
		if(itemID != null){
			MusicItem item = SearchUtility.findById(itemID);
			if (!cart.contains(item)){
				cart.add(item);
			}
		}
		
		
		session.setAttribute("cart", cart);
		
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/cartDisplay.jsp");
		rd.forward(request, response);
		// Or // getServletContext().getRequestDispatcher("/jsp/cartDisplay.jsp").forward(request,response);
		
		
	}


}

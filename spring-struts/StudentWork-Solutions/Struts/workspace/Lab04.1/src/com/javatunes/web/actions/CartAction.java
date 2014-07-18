/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-11 LearningPatterns Inc.
 */
 
package com.javatunes.web.actions;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javatunes.util.MusicItem;
import com.javatunes.util.SearchUtility;
import com.javatunes.web.forms.CartForm;


public class CartAction extends Action {

    public ActionForward execute(
				 ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {

    	// return value
    	ActionForward forward = mapping.findForward("success");
        CartForm cartForm = (CartForm) form;


    	HttpSession session = request.getSession();
    	Collection<MusicItem> cart = 
    	    (Collection<MusicItem>) session.getAttribute("cart");
    	if (cart == null) {   // first visit
    	    cart = new ArrayList<MusicItem>();
    	    session.setAttribute("cart", cart);
    	}
    			
    	String itemID = cartForm.getItemID();
    	if (itemID != null) {
    	    MusicItem item = SearchUtility.findById(itemID);
    	    if (!cart.contains(item)) { // avoid duplicates
    	    	cart.add(item);
    	    }
    	}
    		
    	// Finish with
    	return (forward);

    }
}

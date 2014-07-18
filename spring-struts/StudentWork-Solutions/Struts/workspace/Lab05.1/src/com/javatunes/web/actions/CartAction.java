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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

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
    	ActionMessages errors = new ActionMessages();
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
    		if (outOfStock(itemID)) { // For optional out of stock checking only
    			ActionMessage outOfStock = 
    				new ActionMessage("error.cartAction.outOfStock", itemID);
    			errors.add("error.cartAction.outOfStock", outOfStock);
    			forward = mapping.findForward("outOfStock");
    		} else {
    			MusicItem item = SearchUtility.findById(itemID);
    			if (!cart.contains(item)) { // avoid duplicates
    				cart.add(item);
    			}
    		}  // end else
    	}
    	
    	if (!errors.isEmpty()) {
    		saveErrors(request, errors);
    	}

    		
    	// Finish with
    	return (forward);
    }
    
    private boolean outOfStock (String id) {
    	if (id.equals("507")) {
    		return true;
    	}
    	return false;
    }
    
}

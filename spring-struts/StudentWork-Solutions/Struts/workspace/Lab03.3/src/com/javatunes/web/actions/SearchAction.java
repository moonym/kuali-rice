/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-11 LearningPatterns Inc.
 */
 
package com.javatunes.web.actions;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javatunes.util.MusicItem;
import com.javatunes.util.SearchUtility;
import com.javatunes.web.forms.SearchForm;


public class SearchAction extends Action {

    public ActionForward execute(
				 ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {

    	ActionForward forward = null;

    	// return value
    	SearchForm searchForm = (SearchForm) form;

    	String keyword = searchForm.getKeyword();
    	Collection<MusicItem> results = SearchUtility.findByKeyword(keyword);
    	System.out.println("Results of search - size = " + results.size());
    	request.setAttribute("results", results);    	

    	// Logic determining how the user should be forwarded.
    	if (searchForm.getKeyword().equals("prince")) {		
    	    forward = mapping.findForward("prince");
    	}
    	else {
    	    forward = mapping.findForward("success");
    	}
    		
    	// Finish with
    	return (forward);

    }
}

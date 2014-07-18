/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-11 LearningPatterns Inc.
 */
 
package com.javatunes.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javatunes.web.forms.SearchForm;


public class SearchAction extends Action {

    public ActionForward execute(
				 ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {

	// return value
	ActionForward forward = null;

	SearchForm searchForm = null; // TODO: Cast ActionForm to SearchForm

	// TODO: Write logic determining how the user should be forwarded.
		
	// Finish with
	return (forward);

    }
}

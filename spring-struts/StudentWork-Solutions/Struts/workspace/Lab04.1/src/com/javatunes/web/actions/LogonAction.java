/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-11 LearningPatterns Inc.
 */

package com.javatunes.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javatunes.web.forms.LogonForm;


public class LogonAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

	    LogonForm lform = (LogonForm)form;
	    request.setAttribute("name",lform.getName());		
		// Logic determining how the user should be forwarded.
		ActionForward forward = mapping.findForward("success");

		// Finish with
		return (forward);

	}
}
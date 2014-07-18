/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-11 LearningPatterns Inc.
 */
 
package com.javatunes.web.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 2 fields on this form:
 * <ul>
 * <li>name - 
 * <li>password - 
 * </ul>
 */

public class LogonForm extends ActionForm {


	private static final long serialVersionUID = 1L;

	private String name = null;
	private String password = null;

	/**
	 * Get name
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param <code>String</code>
	 */
	public void setName(String k) {
		this.name = k;
	}

	/**
	 * Get password
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 * @param <code>String</code>
	 */
	public void setPassword(String s) {
		this.password = s;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		name = null;
		password = null;

	}

}

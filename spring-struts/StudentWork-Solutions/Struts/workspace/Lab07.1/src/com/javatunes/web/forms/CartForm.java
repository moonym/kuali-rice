/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-11 LearningPatterns Inc.
 */

package com.javatunes.web.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 1 field on this form:
 * <ul>
 * <li>itemID - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */
public class CartForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String itemID = null;

	/**
	 * Get itemID
	 * @return String
	 */
	public String getItemID() {
		return itemID;
	}

	/**
	 * Set itemID
	 * @param <code>String</code>
	 */
	public void setItemID(String i) {
		this.itemID = i;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// Reset values are provided as samples only. Change as appropriate.

		itemID = null;

	}

}

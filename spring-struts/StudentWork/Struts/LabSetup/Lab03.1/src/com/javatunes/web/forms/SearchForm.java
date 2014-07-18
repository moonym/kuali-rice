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
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Form bean for a Struts application.
 * Users may access 2 fields on this form:
 * <ul>
 * <li>keyword - [your comment here]
 * <li>searchArtist - [your comment here]
 * </ul>
 * @version 	1.0
 * @author
 */

public class SearchForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private String keyword = null;
    // TODO: Add variable for searchArtist

    /**
     * Get keyword
     * @return String
     */
    public String getKeyword() {
	return keyword;
    }

    /**
     * Set keyword
     * @param <code>String</code>
     */
    public void setKeyword(String k) {
	this.keyword = k;
    }

    // TODO: Add accessors (get/set) for searchArtist

    public void reset(ActionMapping mapping, HttpServletRequest request) {


	keyword = null;
	// TODO: Add any reset logic for searchArtist

    }

}

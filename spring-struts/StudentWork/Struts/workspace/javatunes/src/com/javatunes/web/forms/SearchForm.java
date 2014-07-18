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
import org.apache.struts.action.ActionMessage;

/**
 * Form bean for a Struts application.
 * Users may access 2 fields on this form:
 * <ul>
 * <li>keyword - [your comment here]
 * <li>searchArtist - [your comment here]
 * </ul>
 */

public class SearchForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private String keyword = null;
    private String searchArtist = null;
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
	public String getSearchArtist() {
		return searchArtist;
	}

	public void setSearchArtist(String searchArtist) {
		this.searchArtist = searchArtist;
	}    

    public void reset(ActionMapping mapping, HttpServletRequest request) {


	keyword = null;
	searchArtist = null;
	// TODO: Add any reset logic for searchArtist

    }
    
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

    	if (checkForVulgarity(keyword)) {
    	    ActionMessage vulgar = new ActionMessage("error.searchForm.vulgar", keyword);
    	    errors.add("error.searchForm.vulgar",vulgar);
    	}
        
        return errors;

    }
    
    private boolean checkForVulgarity(String s) {
    	if ("vulgar".equals(s)) {
    	    return true;
    	}
    	return false;
    }
    


}

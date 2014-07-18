package com.campustraffic.web.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SearchForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private String lotName = null;
    
    public String getLotName() {
		return lotName;
	}
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
    	lotName = null;
    }
}
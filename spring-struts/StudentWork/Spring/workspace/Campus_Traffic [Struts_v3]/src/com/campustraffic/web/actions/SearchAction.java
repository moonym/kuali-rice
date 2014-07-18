package com.campustraffic.web.actions;

import com.campustraffic.web.dao.DatabaseAccess;
import com.campustraffic.util.ParkingLot;
import com.campustraffic.web.forms.SearchForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * Servlet implementation class lotGet
 */
public class SearchAction extends Action {
	public ActionForward execute(
    		ActionMapping mapping,
    		ActionForm form,
    		HttpServletRequest request,
    		HttpServletResponse response)
	throws Exception{
		ActionForward forward = null;
		SearchForm searchForm = (SearchForm) form;
		String lotName = searchForm.getLotName();
		
		DatabaseAccess DBAccess = new DatabaseAccess();
		
		ParkingLot parkingLot = DBAccess.getParkingLot(lotName);
		request.setAttribute("xCoord", parkingLot.getxCoord());
		request.setAttribute("yCoord", parkingLot.getyCoord());
		request.setAttribute("parkingLot", parkingLot);
		
		forward = mapping.findForward("success");
		
		return(forward);
    }
}

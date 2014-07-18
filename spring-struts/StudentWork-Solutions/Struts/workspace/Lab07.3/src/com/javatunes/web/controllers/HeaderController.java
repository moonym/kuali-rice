package com.javatunes.web.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.ControllerSupport;

import com.javatunes.util.Artists;

/**
 * Controller to put artist list on request for 
 * header drop down
 */
public class HeaderController extends ControllerSupport {

    public void execute	(ComponentContext tileContext,
    		HttpServletRequest request, HttpServletResponse response,
			ServletContext servletContext) 
    throws ServletException, IOException {
    	
    	Artists artists = new Artists();
    	request.setAttribute("artistLabels", artists.getArtistLabels());
    }
}

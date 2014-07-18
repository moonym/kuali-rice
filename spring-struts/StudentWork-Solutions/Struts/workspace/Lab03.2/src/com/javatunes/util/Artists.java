/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.util;

import java.util.Collection;
import java.util.ArrayList;

import org.apache.struts.util.LabelValueBean;

public class Artists {
    
    public Collection<LabelValueBean> getArtistLabels() {
	Collection<MusicItem> catalog = SearchUtility.getCDCatalog();
	ArrayList<LabelValueBean> artistLabels = new ArrayList<LabelValueBean>(catalog.size());
    for (MusicItem curItem : catalog) {
	    artistLabels.add(new LabelValueBean(curItem.getArtist(), curItem.getArtist()));
	}
	return artistLabels;
    }
}
			      
	    
	
	

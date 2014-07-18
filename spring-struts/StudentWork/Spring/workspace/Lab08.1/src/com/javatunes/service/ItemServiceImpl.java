package com.javatunes.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

import com.javatunes.persist.MusicItemDAO;
import com.javatunes.persist.MusicItem;

public class ItemServiceImpl implements ItemService {
	
	MusicItemDAO dao;

	public MusicItemDAO getDao() {
		return dao;
	}

	public void setDao(MusicItemDAO dao) {
		this.dao = dao;
	}

	public void runTest() {
        MusicItem createItem = new MusicItem(null, "CD599", "Transaction Blues", 
    		    "We are Committed", Date.valueOf("1984-09-16"), 
    			new BigDecimal("9.99"), new BigDecimal("7.77"));
        System.out.println("runTest - about to Create");
        dao.create(createItem);        
        dao.blowUp();
	}

	public void checkResults() {
        // See if the music item was created
        Collection<MusicItem> results = dao.searchByKeyword("Transaction");
        System.out.println("*** searchByKeyword for 'Transaction' found the following: ***\n");
		 for (MusicItem curItem : results) {
           System.out.println(curItem);
        }
	}
}

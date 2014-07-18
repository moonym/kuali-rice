/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
 package com.javatunes.catalog;

import com.javatunes.util.MusicItem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaTunes {

	public static void main(String[] args) {
		String[] configFiles = {"beans.xml", "javaTunesSearch.xml"};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext( configFiles );
		System.out.println("Created container");
		Catalog cat = (Catalog)ctx.getBean("javaTunesCatalog");
		System.out.println(cat.findById(new Long(2)));
		// The following lookup should fail now that we're using inner beans.  Uncomment to see an exception.
		// MusicItem mi = (MusicItem)ctx.getBean("mi1");
		ctx.close();
	}
}
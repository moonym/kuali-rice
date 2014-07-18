/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
package com.javatunes.catalog;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import java.util.Collection;

public class JavaTunes {

	public static void main(String[] args) {
		// TODO - Uncomment below and create the resource that reads the spring configuration file to initialize the res variable
		Resource res = new FileSystemResource("src/beans.xml");
		// TODO - Uncomment below and create a BeanFactory - using the resource above- to initilize the factory variable
		BeanFactory factory = new XmlBeanFactory(res);
		// TODO - Look up the javaTunesCatalog bean 
		Catalog cat = (Catalog) factory.getBean("JavaTunesCatalog");

		// TODO - the following compiles, but will only run properly when you finish the wiring up in the Spring configuration
		// and the initilialization above
		// Search by id - returns a single item
		System.out.println(cat.findById(new Long(1)));
		// Search by keyword - returns up to maxSearchResults items for JavaTunesCatalog
		Collection col = cat.findByKeyword("a");
		for (Object cur : col) {
		   System.out.println(cur);
		}
	}
}
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
		Resource res = new FileSystemResource("src/beans.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Catalog cat = (Catalog)factory.getBean("javaTunesCatalog");
		System.out.println(cat.findById(new Long(1)));
		
		Collection col = cat.findByKeyword("a");
		for (Object cur : col) {
		   System.out.println(cur);
		}
	}
}
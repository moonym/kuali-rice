/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
 package com.javatunes.teach;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class TeachMeSpring {

	public static void main(String[] args) {
		Resource res = new FileSystemResource("src/beans.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Teacher teacher = (Teacher)factory.getBean("springGuru");
		teacher.teach();
	}
}
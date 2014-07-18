/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */

package com.javatunes.teach;

// TODO - Import the needed Spring classes
import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class TeachMeSpring {

	public static void main(String[] args) {
		System.out.println("We're ready to learn Spring");
		// TODO - Uncomment below and create the resource that reads the spring configuration file to initialize the res variable
		Resource res = new FileSystemResource("src/beans.xml");
		// TODO - Uncomment below and create a BeanFactory - using the resource above- to initilize the factory variable
		BeanFactory factory = new XmlBeanFactory(res);
		// TODO - Uncomment below and look up the springGuru bean to initialize the teacher variable
		Teacher teacher = (Teacher)factory.getBean("springGuru");
		// TODO - Have the teacher teach.
		teacher.teach();
	}
}
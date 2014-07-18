package com.javatunes.catalog;

import com.javatunes.util.MusicItem;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class JavaTunes {

	public static void main(String[] args) {
		Resource res = new FileSystemResource("src/beans.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Catalog cat = (Catalog)factory.getBean("javaTunesCatalog");
		System.out.println(cat.findById(new Long(2)));
		MusicItem mi = (MusicItem)factory.getBean("mi1");
		System.out.println(mi);
	}
}
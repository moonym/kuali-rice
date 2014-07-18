/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
 package com.javatunes.teach;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;

import java.util.Locale;

public class JavaInstructor implements Teacher, ApplicationContextAware {
	private InfoSource info;
	public void setInfo (InfoSource infoIn) {
      info=infoIn;
  }

	private String favoriteTopic;
	public void setFavoriteTopic (String topic) {
      favoriteTopic = topic;
  }
	public String getFavoriteTopic() { return favoriteTopic; }

	private Double age;
	public void setAge (Double d) {
      age = d;
  }
	public Double getAge() { return age; }
	
  private ApplicationContext ctx;
  public void setApplicationContext(ApplicationContext ctxIn) {
    ctx = ctxIn;
  }
  public void teach() {
		Object[] args = { getFavoriteTopic() };
		// Lookup of "greeting" using the es Locale
		String message = ctx.getMessage("greeting", args, new Locale("es"));
		System.out.println(message);
		System.out.println(info.getData());
	}
}


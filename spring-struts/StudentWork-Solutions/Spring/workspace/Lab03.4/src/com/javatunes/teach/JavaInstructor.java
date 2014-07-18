/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
package com.javatunes.teach;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component("springGuru")
public class JavaInstructor implements Teacher {
	
	@Resource(name="springBook")
	private InfoSource info;
	public void setInfo (InfoSource infoIn) {
      info=infoIn;
  }
	public void teach() {
		System.out.println(info.getData());
	}
}


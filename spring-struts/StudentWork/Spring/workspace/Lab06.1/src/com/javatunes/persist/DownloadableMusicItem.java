/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-7 LearningPatterns Inc.
 */
 
 package com.javatunes.persist;

import java.math.BigDecimal;
import java.sql.Date;

public class DownloadableMusicItem extends MusicItem {

	private static final long serialVersionUID = 1L;
	
	private String URL;
	private String fileType;

	public String getFileType() { return fileType; }
	public String getURL() { return URL; }
	
	public void setFileType(String fileType) { this.fileType = fileType; }
	public void setURL(String url) { URL = url; }

	public DownloadableMusicItem() {
	}

	public DownloadableMusicItem(Long id, String num, String title,
			String artist, Date releaseDate, BigDecimal listPrice,
			BigDecimal price) {
		super(id, num, title, artist, releaseDate, listPrice, price);
	}

	   public String toString() {
		   String comma = ", ";
		   StringBuffer sb = new StringBuffer();
		   sb.append("DownloadableItem: ");
		   sb.append(getURL());
		   sb.append(comma);
		   sb.append(getFileType());
		   sb.append(comma);
		   sb.append(super.toString());
		   return sb.toString();
	   }
	   	
	
}

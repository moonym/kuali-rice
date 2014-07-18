/*
 *
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2008 LearningPatterns Inc.
 */

package com.javatunes.persist;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;


public class MusicItem
implements java.io.Serializable
{
   // properties

	private static final long serialVersionUID = 1L;

private Long       id;

   private String     num;
   private String     title;
   private String     artist;
   private Date       releaseDate;
   private BigDecimal listPrice;
   private BigDecimal price;
   
   private int version;
   
   private Set<String> bandMembers = new HashSet<String>();
   
   private Set<Inventory> inventoryRecords = new HashSet<Inventory>();

   public MusicItem() { }

   public MusicItem(Long id)
   {
      this.setId(id);
   }


   public MusicItem(Long id, String num, String title, String artist,
                    Date releaseDate, BigDecimal listPrice, BigDecimal price)
   {
	  this.setId(id);
      this.setNum(num);
      this.setTitle(title);
      this.setArtist(artist);
      this.setReleaseDate(releaseDate);
      this.setListPrice(listPrice);
      this.setPrice(price);
   }

   public Long getId() { return id; }
   public String getNum() { return num; }
   public String getTitle() { return title; }
   public String getArtist() { return artist; }
   public Date getReleaseDate() { return releaseDate; }
   public BigDecimal getListPrice() { return listPrice; }
   public BigDecimal getPrice() { return price; }
   public int getVersion() {  return version;  }
   public Set<String> getBandMembers() { return bandMembers; }
   public Set<Inventory> getInventoryRecords() { return inventoryRecords; }

   private void setId(Long id) { this.id = id; }
   public void setNum(String num) { this.num = num; }
   public void setTitle(String title) { this.title = title; }
   public void setArtist(String artist) { this.artist = artist; }
   public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }
   public void setListPrice(BigDecimal listPrice) { this.listPrice = listPrice; }
   public void setPrice(BigDecimal price) { this.price = price; }
   private void setVersion(int version) {  this.version = version;   }
   public void setBandMembers(Set<String> bandMembers) { this.bandMembers = bandMembers; }
   public void setInventoryRecords(Set<Inventory> inventoryRecords) { this.inventoryRecords = inventoryRecords; }

  	public void addInventoryRecord(String location, int quantity) {
  		Inventory inv = new Inventory(location,quantity);
  		inv.setItem(this);
  		getInventoryRecords().add(inv);
  	}	   
   
   // override Object.equals
   public boolean equals(Object other) {
	   if (this==other) return true;
	   else if (!(other instanceof MusicItem)) return false; 
	   else return ((MusicItem)other).getNum().equals(this.getNum()) ;
   }
   
   // override Object.hashCode
   public int hashCode() {
	   return getNum().hashCode();
   }

   // override Object.toString
   public String toString()
   {
      return this.getClass().getName() +
         ": id=" + this.getId() +
         ": num=" + this.getNum() +
         " title=" + this.getTitle() +
         " artist=" + this.getArtist() +
         " releaseDate=" + this.getReleaseDate() +
         " listPrice=" + this.getListPrice() +
         " price=" + this.getPrice();
   }
}
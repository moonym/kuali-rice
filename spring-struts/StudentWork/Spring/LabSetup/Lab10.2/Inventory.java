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

public class Inventory
{
   private Long       id;
   private int        version = -1;

   private String     location;
   private int        quantity;

   public Inventory() {}

   public Inventory(String location, int quantity) {
	   setLocation(location);
	   setQuantity(quantity);
   }


   public Long getId() { return id; }
   public int  getVersion() { return version; }

   public String getLocation() { return location; }
   public int    getQuantity() { return quantity; }

   public void setLocation(String loc)    { location = loc; }
   public void setQuantity(int q)         { quantity = q; }

   public void add(int amt)
   {
      setQuantity(getQuantity() + amt);
   }

   public void sub(int amt) throws InsufficientInventory
   {
      if (amt > getQuantity())
      {
         throw new InsufficientInventory(getLocation() + " only has " + getQuantity() + " copies of " + getItem().getId());
      }
      else
      {
         setQuantity(getQuantity() - amt);
      }
   }

   // override Object.equals
   public boolean equals(Object other)
   {
	   if (this==other) return true;
	   else if (!(other instanceof MusicItem)) return false;
	   else {
		   	// cast to Inventory
		   	final Inventory compare =(Inventory) other;
		   	// Uncomment this when you add in the item property
		   	// if (!compare.getItem().getId().equals(this.getItem().getId())) return false;
		   	if (!compare.getLocation().equals(this.getLocation())) return false;
		    return true;
	   }
   }

   public int hashcode() {
	    // TODO: Uncomment the below when you add in the item property
	   	// return getItem().getId().hashCode()
	   	  //     + 29 * getLocation().hashCode();
   }

   public String toString() {
	   String comma = ", ";
	   StringBuffer sb = new StringBuffer();
	   sb.append("Inventory: ");
	   sb.append(getItem().getId());
	   sb.append(comma);
	   sb.append(getLocation());
	   sb.append(comma);
	   sb.append(getQuantity());
	   return sb.toString();
   }

}

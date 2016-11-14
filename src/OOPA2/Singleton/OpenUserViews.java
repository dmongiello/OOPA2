/*
 * File name : OpenUserViews.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  This holds all the userID's of the userView windows open.
 */
package OOPA2.Singleton;

import OOPA2.Composite.Composite;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author davidmongiello
 */
public class OpenUserViews 
{
  public final static OpenUserViews INSTANCE = new OpenUserViews();
  ArrayList<Composite> openned = new ArrayList<>(); 
  public OpenUserViews()
  {
    
  }
  
  // Add the user to the list to let other objects knew it is already open
  // so another window can not be open with the same user. 
  public void open(Composite composite)
  {
    openned.add(composite);
  }
  // Removes a user from the list so a new window can be opened with this user
  public void close(Composite composite)
  {
    Iterator<Composite> iter = openned.iterator();

    while (iter.hasNext()) 
    {
      Composite c = iter.next();

      if (c.equals(composite))
      {
        iter.remove();
      }
    }
  }
  // Checks to see if there is a window open with this user
  public boolean isOpen(Composite composite)
  {
    for(Composite c: openned)
    {
      if (c.equals(composite))
      {
        return true;
      }
    }
    return false; 
  }
  
}

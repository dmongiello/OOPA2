/*
 * File name : Group.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  Create a componet of the composite pattern. 
 */
package OOPA2.Composite;

import OOPA2.Composite.Composite;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public class Group implements Composite {
  private String userID;
  private List<Composite> composites; 
  
  public Group(String iD)
  {
    this.userID = iD; 
  }
  
  public List<Composite> getComposites()
  {
    return composites; 
  }
  
  public void add(Composite composite)
  {
    composites.add(composite);
  }
  public DefaultListModel getNewsFeed()
  {
   return null; 
  }
  
  @Override
  public String toString()
  {
    return userID; 
  }
}

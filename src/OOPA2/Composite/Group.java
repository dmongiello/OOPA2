/*
 * File name : Group.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  Create a componet of the composite pattern. 
 */
package OOPA2.Composite;

import OOPA2.Visitor.Visitor;
import java.util.ArrayList;
import java.util.List; 
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public class Group implements Composite {
  private String userID;
  private List<Composite> composites = new  ArrayList<>();
  
  public Group(String iD)
  {
    this.userID = iD; 
  }
  // Give the list of components
  public List<Composite> getComposites()
  {
    return composites; 
  }
  // Add a component to this composite
  public void add(Composite composite)
  {
    composites.add(composite);
  }
 // if something is trying to access a group's newfeed it is wrong. 
  public DefaultListModel getNewsFeed()
  {
   return null; 
  }
  // This enables visitors for the visitor pattern. 
  public void accept(Visitor visitor)
  {
    visitor.visitGroup(this);
    for(Composite c : composites) {
			c.accept(visitor);
		}
  }
  
  @Override
  public String toString()
  {
    return userID; 
  }
}

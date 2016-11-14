/*
 * File name : Visitor.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  Create an interface for visitors to the user and group classes. 
 */
package OOPA2.Visitor;

import OOPA2.Composite.Group;
import OOPA2.Composite.Tweet;
import OOPA2.Composite.User;

/**
 *
 * @author davidmongiello
 */
public interface Visitor {
  public void visitGroup(Group group);
  public void visitUser(User user); 
  public void visitTweet(Tweet tweet);
}

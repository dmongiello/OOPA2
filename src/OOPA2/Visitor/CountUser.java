/*
 * File name : CountUser.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  Impemants Visitor interface to count the amount of users. 
 */
package OOPA2.Visitor;

import OOPA2.Composite.Group;
import OOPA2.Composite.Tweet;
import OOPA2.Composite.User;

/**
 *
 * @author davidmongiello
 */
public class CountUser implements Visitor {
  private Integer counter = 0;

  
  @Override
  public void visitGroup(Group group) 
  {
    // don't add to count if it is a group. 
  }

  @Override
  public void visitUser(User user) 
  {
     setCounter(getCounter() + 1);
  }
  
  public int getCounter() 
  {
    return counter;
  }

  public void setCounter(int counter)
  {
    this.counter = counter;
  }

  @Override
  public void visitTweet(Tweet tweet) 
  {
   
  }
}

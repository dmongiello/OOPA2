/*
 * File name : CountGroup.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  creats a visitor class that counts how many groups it visits. 
 */
package OOPA2.Visitor;

import OOPA2.Visitor.Visitor;
import OOPA2.Composite.Group;
import OOPA2.Composite.Tweet;
import OOPA2.Composite.User;

/**
 *
 * @author davidmongiello
 */
public class CountGroup implements Visitor
{
  private Integer counter = 0;

  
  @Override
  public void visitGroup(Group group) 
  {
    setCounter(getCounter() + 1);
  }

  @Override
  public void visitUser(User user) 
  {
     
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
    // Groups do not tweet
  }
  
}

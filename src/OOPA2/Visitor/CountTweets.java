/*
 * File name : CountTweets.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  This creats a class to visit users and count how many tweets they have.
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
public class CountTweets implements Visitor 
{
  private int counter = 0; 

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }
  @Override
  public void visitGroup(Group group) 
  {
    // Groups don't have tweets
  }

  @Override
  public void visitUser(User user)
  {
  
  }

  @Override
  public void visitTweet(Tweet tweet)
  {
    setCounter(getCounter() + 1);
  }
  
}

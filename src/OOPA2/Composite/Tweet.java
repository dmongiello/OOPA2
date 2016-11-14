/*
 * File name : Tweet.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/14/2016
 * Purpose :  Creates a tweet when the user sends a tweet.
              Allows a visitor pattern to count tweets. 
 */
package OOPA2.Composite;

import OOPA2.Visitor.Visitor;

/**
 *
 * @author davidmongiello
 */
public class Tweet implements Composite {
  private String tweet = "";
  
  public Tweet(String tweet)
  {
    this.tweet = tweet; 
  }
  public String getTweet() {
    return tweet;
  }

  public void setTweet(String tweet) {
    this.tweet = tweet;
  }
  
  @Override
  public void accept(Visitor visitor) 
  {
     visitor.visitTweet(this);
  }
  
  @Override
  public String toString()
  {
    return tweet; 
  }
  
}

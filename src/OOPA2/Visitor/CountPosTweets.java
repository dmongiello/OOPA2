/*
 * File name : 
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  
 */
package OOPA2.Visitor;

import OOPA2.Visitor.Visitor;
import OOPA2.Composite.Group;
import OOPA2.Composite.Tweet;
import OOPA2.Composite.User;
import OOPA2.Singleton.PositiveWords;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidmongiello
 */
public class CountPosTweets implements Visitor
{
  private int counter = 0; 

  public int getCounter() 
  {
    return counter;
  }

  public void setCounter(int counter) 
  {
    this.counter = counter;
  }
  @Override
  public void visitGroup(Group group) 
  {
    // Groups are not tweets
  }

  @Override
  public void visitUser(User user)
  {
    // users are not tweets
  }

  @Override
  public void visitTweet(Tweet tweet) 
  {
    ArrayList<String> words = PositiveWords.INSTANCE.getWords();
    for(String w: words)
    {
      if(tweet.toString().contains(w))
      {
        setCounter(getCounter() + 1);
        break; 
      }
    }
    
  }
  
}

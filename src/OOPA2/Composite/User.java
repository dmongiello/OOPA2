/*
 * File name : User.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  Create a leaf of the composite pattern. 
 */
package OOPA2.Composite;

import OOPA2.Composite.Composite;
import OOPA2.Observer.Follower;
import OOPA2.Observer.Observer;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public class User implements Composite {
  private  Observer follower;
  
  
  public User(String iD)
  {
    follower = new Follower(iD); 
  }
  
  // This method sends the tweet to the subject 
  public void sendTweet(String tweet)
  {
    follower.setTweet(tweet);
  }
  
  // This opens the newsFeed to public
  public DefaultListModel getNewsFeed()
  {
    return follower.getNewsFeed(); 
  }
  // This opens the newsFeed to public
  public DefaultListModel getFollowings()
  {
    return follower.getFollowings();
  }
  public void attach(Observer observer)
  {
    follower.attach(observer);
  }
  public void addFollow(String newFollow)
  {
    follower.addFollow(newFollow);
  }
  public Observer getObserver()
  {
    return follower.getObserver(); 
  }
  
  // makes sure the user id is used for list and treeViews
  @Override
  public String toString()
  {
    return follower.getID(); 
  }
  
}

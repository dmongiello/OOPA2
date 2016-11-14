/*
 * File name : UserGUI.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  To contain all the GUI elements for a user.
              The tweets and followers list. 
 */
package OOPA2.Composite;

import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public class UserGUI {
  private DefaultListModel tweets = new DefaultListModel();
  private DefaultListModel followings = new DefaultListModel();
  
  
  // Method: getFollowingsFollow()
  // Parameters: none
  // Purpose: return to the listview who this subject is following.  
  public DefaultListModel getFollowings()
  {
    return followings; 
  }
  // Method: addFollow()
  // Parameters: newFollow
  // Purpose: Attach a new following to the subject
  // another subject that this subject is following. 
  public void addFollow(String newFollow)
  {
    followings.addElement(newFollow);
  }
  
  // Method: addTweet()
  // Parameters: newTweet 
  // Purpose: Attach the latest tweet to the tweet list. (newsFeed).
  public void addTweet(String newTweet)
  {
    tweets.addElement(newTweet); 
  }
  // Method: getNewsFeed()
  // Parameters: newTweet 
  // Purpose: Show the newsFeed to the listView. 
  public DefaultListModel getNewsFeed()
  {
    return tweets; 
  }
  
  public int getNewsFeedSize()
  {
    return tweets.getSize();
  }
}

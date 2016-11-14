/*
 * File name : User.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  Create a leaf of the composite pattern. 
 */
package OOPA2.Composite;
import OOPA2.Observer.Follower;
import OOPA2.Observer.Observer;
import OOPA2.Subject.Tweeter;
import OOPA2.Visitor.Visitor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public class User implements Composite {
  private  Observer follower;
  private Tweeter tweeter;
  private UserGUI userGUI; 
  private List<Composite> composites = new  ArrayList<>();
  
  public User(String iD)
  {
    userGUI = new UserGUI(); 
    follower = new Follower(iD, userGUI);
    tweeter = new Tweeter();
    tweeter.attach(follower);
    addFollow(iD);
  }
  
  // This method sends the tweet to the subject 
  public void sendTweet(String tweet)
  {
    Tweet newTweet = new Tweet(tweet);
    this.add(newTweet);
    tweeter.setTweet(tweet);
  }
  
   public void add(Composite composite)
  {
    composites.add(composite);
  }
  
  // This opens the newsFeed to public
  public DefaultListModel getNewsFeed()
  {
    return userGUI.getNewsFeed(); 
  }
  // This sends the list of followers to the listView
  public DefaultListModel getFollowings()
  {
    return userGUI.getFollowings();
  }
  
  // Attach a new follower to the subject
  public void attach(Observer observer)
  {
    tweeter.attach(observer);
  }
  // Attach a new follower to this user view list
  public void addFollow(String newFollow)
  {
   userGUI.addFollow(newFollow);
  }
  // returns an observer for the subject to add to the list
  public Observer getObserver()
  {
    return follower.getObserver(); 
  }
  // This is for the visitor pattern to work and visit this object. 
  public void accept(Visitor visitor)
  {
    visitor.visitUser(this);
    for(Composite c : composites) {
			c.accept(visitor);
		}
  }
  public int getNewsFeedSize()
  {
    return userGUI.getNewsFeedSize(); 
  }
  // makes sure the user id is used for list and treeViews
  @Override
  public String toString()
  {
    return follower.getID(); 
  }
  
}

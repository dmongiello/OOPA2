/*
 * File name : Follower.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  To create a concreat observer class 
 */
package OOPA2.Observer;

import OOPA2.Subject.Subject;
import OOPA2.Subject.Tweeter;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public class Follower implements Observer 
{
  
  private String latestTweet;
	private Tweeter tweeter; 
  private String userID;
  public Follower(String ID)
  {
    this.userID = ID; 
    tweeter = new Tweeter();
    tweeter.attach(this);
  }
	public void update(Subject subject) 
  {
		if (subject instanceof Tweeter) 
    {
			latestTweet = ((Tweeter) subject).getTweet(); 
					
			displayTweet();
		} 
	}
  public void addFollow(String newFollow)
  {
    tweeter.addFollow(newFollow);
  }
  public DefaultListModel getNewsFeed()
  {
    return tweeter.getNewsFeed();
  }
  public DefaultListModel getFollowings()
  {
    return tweeter.getFollowings();
  }
  
  public Subject getSubject()
  {
    return tweeter; 
  }
  
  public String getID()
  {
    return userID; 
  }
  public void setTweet(String newTweet)
  {
    tweeter.setTweet(newTweet);
  }
  public Observer getObserver()
  {
    return this; 
  }
	public void attach(Observer observer)
  {
    tweeter.attach(observer);
  }
	private void displayTweet() {
		tweeter.addTweet(latestTweet);
	}
  
  
}

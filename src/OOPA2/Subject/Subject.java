/*
 * File name : 
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose : Create a base class for future subject classes. 
 */
package OOPA2.Subject;

import OOPA2.Observer.Observer;
import java.util.List;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public abstract class Subject {
  
  // Keep track of the observers of this subject
  private List<Observer> observers = new ArrayList<>();
  private DefaultListModel followings = new DefaultListModel();
  private DefaultListModel tweets = new DefaultListModel();

  // Method: addTweet()
  // Parameters: newTweet 
  // Purpose: Attach the latest tweet to the tweet list. (newsFeed).
  public void addTweet(String newTweet)
  {
    tweets.addElement(newTweet); 
  }
  // Method: addFollow()
  // Parameters: newFollow
  // Purpose: Attach a new following to the subject
  // another subject that this subject is following. 
  public void addFollow(String newFollow)
  {
    followings.addElement(newFollow);
  }
	// Method: attach()
  // Parameters: Observer
  // Purpose: Attach a new observer to this subject
	public void attach(Observer observer) {
		observers.add(observer);
	}
	// Method: detach()
  // Parameters: Observer
  // Purpose: Remove an observer from the list of observers
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
  // Method: notifyObservers()
  // Parameters: None
  // Purpsose: loop through all the observers and notify them of the change. 
	public void notifyObservers() {
    observers.stream().forEach((ob) -> {
      ob.update(this);
    });
	}
  
  public DefaultListModel getNewsFeed()
  {
    return tweets; 
  }
  
  public DefaultListModel getFollowings()
  {
    return followings; 
  }
  
}

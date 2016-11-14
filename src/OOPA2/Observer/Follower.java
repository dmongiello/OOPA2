/*
 * File name : Follower.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  To create a concreat observer class 
 */
package OOPA2.Observer;

import OOPA2.Composite.UserGUI;
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
  private String userID;
  
  // UserGUI handles all the Graphical user interface
  // The listview of the followers and all that stuff.
  private UserGUI userGUI; 
  
  public Follower(String ID, UserGUI userGUI)
          
  {
    this.userID = ID; 
    this.userGUI = userGUI; 
  }
  
  // This method updates when the subject sends an update
	public void update(Subject subject) 
  {
		if (subject instanceof Tweeter) 
    {
			latestTweet = ((Tweeter) subject).getTweet(); 
					
			userGUI.addTweet(latestTweet);
		} 
	}
  
  // Returns the user id of the follower
  public String getID()
  {
    return userID; 
  }
  public Observer getObserver()
  {
    return this; 
  }
	
  
  
}

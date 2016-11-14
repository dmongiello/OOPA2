/*
 * File name : Tweeter.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  Derived from subject to make a subject that tweets. 
 */
package OOPA2.Subject;

/**
 *
 * @author davidmongiello
 */
public class Tweeter extends Subject
{
  // Holds the msg tweeted 
  private String tweet;

	public String getTweet()
  {
		return tweet;
	}

	public void setTweet(String tweet) 
  {
    // 
		this.tweet = tweet;
    // Tell observers that are interested
		notifyObservers();
	}
  
}

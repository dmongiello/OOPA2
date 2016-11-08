/*
 * File name : Tweeter.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  
 */
package OOPA2.Subject;

/**
 *
 * @author davidmongiello
 */
public class Tweeter extends Subject {
  
  // Holds the msg tweeted 
  
  private String tweet;

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
    // 
		this.tweet = tweet;
    // Tell observers that are interested
		notifyObservers();
	}
  
}

/*
 * File name : Subject.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
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
public abstract class Subject 
{
  
  // Keep track of the observers of this subject
  private List<Observer> observers = new ArrayList<>();
 
	// Method: attach()
  // Parameters: Observer
  // Purpose: Attach a new observer to this subject
	public void attach(Observer observer) 
  {
		observers.add(observer);
	}
	// Method: detach()
  // Parameters: Observer
  // Purpose: Remove an observer from the list of observers
	public void detach(Observer observer) 
  {
		observers.remove(observer);
	}
	
  // Method: notifyObservers()
  // Parameters: None
  // Purpsose: loop through all the observers and notify them of the change. 
	public void notifyObservers() 
  {
    observers.stream().forEach((ob) -> {
      ob.update(this);
    });
	}
  
  
}

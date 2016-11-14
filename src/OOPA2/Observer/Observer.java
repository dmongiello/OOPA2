/*
 * File name : Observer
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignement 2
 * Date Last Modified : 11/7/2016
 * Purpose :  create an observer interface. 
 */
package OOPA2.Observer;

import OOPA2.Subject.Subject;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public interface Observer {
  public void update(Subject subject); 
  public String getID();  
  public Observer getObserver();
  
  
  
}

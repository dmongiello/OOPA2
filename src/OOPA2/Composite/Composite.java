/*
 * File name : Composite.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  create an inteface for composite pattern
 */
package OOPA2.Composite;

import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public interface Composite {
  
  public DefaultListModel getNewsFeed(); 
  
  @Override
  public String toString();
  
  
}

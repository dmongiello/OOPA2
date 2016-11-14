/*
 * File name : Composite.Java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  create an inteface for composite pattern
 */
package OOPA2.Composite;

import OOPA2.Visitor.Visitor;
import javax.swing.DefaultListModel;

/**
 *
 * @author davidmongiello
 */
public interface Composite {
  // This is to enable visitor pattern into the composite pattern. 
  public void accept(Visitor visitor);
  
  @Override
  public String toString();
  
  
}

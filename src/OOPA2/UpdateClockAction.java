/*
 * File name : UpdatedClockAction.java
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP Assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  This is a anctionLister class that run the clock for the 
              splash screen.
 */
package OOPA2;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author davidmongiello
 */

  
  // All this timer stuff is for the splash screen action. 
        public class UpdateClockAction implements ActionListener {
        private CardLayout c;
        private Container p;

        public UpdateClockAction( CardLayout cc,Container pp  ) 
        {
        c = cc;
        p = pp;
        }
    
        public void actionPerformed(ActionEvent e) {
            c.show(p, "Main Screen");
            
        }
  
}

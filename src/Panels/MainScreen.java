/*
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  To create the panel for the admin view
 *             This class if for Java Swing componites
 *             Mostly
 */
package Panels;

import OOPA2.Singleton.TreePanel;
import OOPA2.Composite.Composite;
import OOPA2.Composite.User;
import OOPA2.Composite.Group;
import OOPA2.Singleton.OpenUserViews;
import OOPA2.Visitor.CountGroup;
import OOPA2.Visitor.CountPosTweets;
import OOPA2.Visitor.CountTweets;
import OOPA2.Visitor.CountUser;
import OOPA2.Visitor.Visitor;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author davidmongiello
 */
public final class MainScreen extends JPanel {
   
    private JTextField userID = new JTextField();
    JTextField groupID = new JTextField();
    JLabel systemText = new JLabel("<html><font color='red'>System Online:</font></html>");
      
  public MainScreen()
  {
    // This is for the button user view
    // it displays a new window for a user to follow and tweet. 
    ActionListener userView;
    userView = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (TreePanel.INSTANCE.getSelection() != null) {
          // Add the penel user view to the new JFrame
          Composite newComposite = TreePanel.INSTANCE.getSelection();
          if (newComposite instanceof User) {
            if (OpenUserViews.INSTANCE.isOpen(newComposite)) {
            } else {
              // This creats a new instance of a JFrame (window)
              JFrame f = new JFrame(newComposite.toString());
              f.add(new UserView((User) newComposite));
              f.pack();
              // Show the newly created frame to the user. 
              f.setVisible(true);
              OpenUserViews.INSTANCE.open(newComposite);
              f.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                  OpenUserViews.INSTANCE.close(newComposite);
                }
              });
            }
            
          }
          
        }
      }      
    };

    // This is to add a new user to the tree
    // It makes a new user node as well. 
    ActionListener addUserListener;
    addUserListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode test = TreePanel.INSTANCE.addObject(new User(userID.getText()));
        if (test == null) {
          systemText.setText("<html><font color='red'>"
                  + "Unable to add that user"
                  + "</font></html>");
        }
      }      
    };

    // This adds a new group to the tree.
    ActionListener addGroupListener;
    addGroupListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode test = TreePanel.INSTANCE.addObject(new Group(groupID.getText()));
        if (test == null) {
          systemText.setText("<html><font color='red'>"
                  + "Unable to add that group"
                  + "</font></html>");
        }        
      }      
    };

    // This is for counting the total users. It uses the visitor pattern.
    ActionListener countUserListener;
    countUserListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        CountUser count = new CountUser();        
        Composite composite = TreePanel.INSTANCE.getSelection();
        composite.accept(count);
        systemText.setText("<html><font color='red'>"
                + "There count of users from " + composite.toString()
                + " is "
                + String.valueOf(count.getCounter())
                + "</font></html>");
      }      
    };

    // This is for counting the total groups. It uses the visitor pattern.
    ActionListener countGroupListener;
    countGroupListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        CountGroup count = new CountGroup();        
        Composite composite = TreePanel.INSTANCE.getSelection();
        composite.accept(count);
        systemText.setText("<html><font color='red'>"
                + "There count of groups from " + composite.toString()
                + " is "
                + String.valueOf(count.getCounter())
                + "</font></html>");
      }      
    };

    // This is for counting the total Tweets. It uses the visitor pattern.
    ActionListener countTweetsListener;
    countTweetsListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        CountTweets count = new CountTweets();        
        Composite composite = TreePanel.INSTANCE.getSelection();
        composite.accept(count);
        systemText.setText("<html><font color='red'>"
                + "There count of tweets from " + composite.toString()
                + " is "
                + String.valueOf(count.getCounter())
                + "</font></html>");
      }      
    };

    // This is for counting the total positive Tweets. It uses the visitor pattern.
    ActionListener countPosTweetsListener;
    countPosTweetsListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Get total tweets
        CountTweets countTweets = new CountTweets();        
        Composite composite = TreePanel.INSTANCE.getSelection();
        composite.accept(countTweets);
        // Get positive tweets
        
        CountPosTweets count = new CountPosTweets();
        composite.accept(count);
        
        double percent = 0;        
        if (countTweets.getCounter() != 0) {
          percent = (double) ((double) count.getCounter() / (double) countTweets.getCounter()) * 100;
        }
        systemText.setText("<html><font color='red'>"
                + "The percent of Positive tweets from " + composite.toString()
                + " is : "
                + String.format("%.2f", percent)
                + "% </font></html>");
      }      
    };


    // Set the boarder color of the panel
    setBorder(BorderFactory.createLineBorder(Color.darkGray));
    // Set the background color of the panel
    this.setBackground(new Color(3,25,99) );
    // Set up the top grid buttons
    
    JButton addUser = new JButton("Add User");
    addUser.addActionListener(addUserListener);
    JButton addGroup = new JButton("Add Group");
    addGroup.addActionListener(addGroupListener);
    // Set up the mid grid buttons
    JButton openUserView = new JButton("Open User View");
    openUserView.addActionListener(userView);
    // Set up the button grid buttons
    JButton showUserTotal = new JButton("Show User Total");
    showUserTotal.addActionListener(countUserListener);
    JButton showGroupTotal = new JButton("Show Group Total");
    showGroupTotal.addActionListener(countGroupListener);
    JButton showMsgTotal = new JButton("Show Messages Total");
    showMsgTotal.addActionListener(countTweetsListener);
    JButton showPositivePercentage = new JButton("Show Positive Percentage");
    showPositivePercentage.addActionListener(countPosTweetsListener);
    
    // Define the grids
    final Container mainGrid = new Container();
    final Container topGrid = new Container();
    final Container bottumGrid = new Container();
  
    // Set up the grids
    mainGrid.setLayout(new GridLayout(4, 0));
    topGrid.setLayout(new GridLayout(2, 2));
    bottumGrid.setLayout(new GridLayout(2, 2));
    // Set the layout of the panel
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    // Add buttons to top grid
    topGrid.add(userID);
    topGrid.add(addUser);
    topGrid.add(groupID);
    topGrid.add(addGroup);
    // Add buttons to buttom grid
    bottumGrid.add(showUserTotal);
    bottumGrid.add(showGroupTotal);
    bottumGrid.add(showMsgTotal);
    bottumGrid.add(showPositivePercentage);
    // Add the grids to the main grid
    mainGrid.add(topGrid);
    mainGrid.add(openUserView);
    mainGrid.add(bottumGrid);
    mainGrid.add(systemText);
    // Add treeView and maingrid to the panel.
    add(TreePanel.INSTANCE);
    add(mainGrid); 
}
  
}
 


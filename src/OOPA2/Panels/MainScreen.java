/*
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  To create the panel for the admin view
 *             This class if for Java Swing componites
 *             Mostly
 */
package OOPA2.Panels;

import OOPA2.Composite.User;
import OOPA2.Composite.Group;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author davidmongiello
 */
public final class MainScreen extends JPanel {
   
    private JTextField userID = new JTextField();
    JTextField groupID = new JTextField();
      
  public MainScreen()
  {
    // This is for the button user view
    // it displays a new window for a user to follow and tweet. 
    ActionListener userView;
        userView = new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
            if(TreePanel.INSTANCE.getSelection() != null)
            {
            // This creats a new instance of a JFrame (window)
            JFrame f = new JFrame("User View");
            // Add the penel user view to the new JFrame
            
            f.add(new UserView(TreePanel.INSTANCE.getSelection()));
            f.pack();
            // Show the newly created frame to the user. 
            f.setVisible(true);
            }
        }   
    };
        
        ActionListener addUserListener;
        addUserListener = new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
            TreePanel.INSTANCE.addObject(new User(userID.getText()));
        }   
    };
        
     ActionListener addGroupListener;
        addGroupListener = new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
            TreePanel.INSTANCE.addObject(new Group(groupID.getText()));
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
    JButton showGroupTotal = new JButton("Show Group Total");
    JButton showMsgTotal = new JButton("Show Messages Total");
    JButton showPositivePercentage = new JButton("Show Positive Percentage");
    
    // Define the grids
    final Container mainGrid = new Container();
    final Container topGrid = new Container();
    final Container bottumGrid = new Container();
  
    // Set up the grids
    mainGrid.setLayout(new GridLayout(3, 0));
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
    // Add treeView and maingrid to the panel.
    add(TreePanel.INSTANCE);
    add(mainGrid); 
}
  
}
 


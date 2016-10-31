/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOPA2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author davidmongiello
 */
public final class MainScreen extends JPanel {
      
  public MainScreen()
  {
    ActionListener userView;
        userView = new ActionListener() 
    {
        public void actionPerformed(ActionEvent e) 
        {
            JFrame f = new JFrame("User View");
            f.add(new UserView());
            f.pack();
            f.setVisible(true);
        }   
    };
    // Set the boarder color of the panel
    setBorder(BorderFactory.createLineBorder(Color.darkGray));
    // Set the background color of the panel
    this.setBackground(new Color(3,25,99) );
    // Create the tree View.
    DefaultMutableTreeNode top =
        new DefaultMutableTreeNode("The Java Series");
    createNodes(top);
    JTree tree = new JTree(top);
    JScrollPane treeView = new JScrollPane(tree);
    treeView.setMaximumSize(new Dimension(250,400));
    treeView.setPreferredSize(new Dimension(250,400));
    // Set up the top grid buttons
    JTextField userID = new JTextField();
    JTextField groupID = new JTextField();
    JButton addUser = new JButton("Add User");
    JButton addGroup = new JButton("Add Group");
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
    add(treeView);
    add(mainGrid); 
}
  

// This method was stolen from docs.oracle.com used to test tree view.   
public void createNodes(DefaultMutableTreeNode top) {
    DefaultMutableTreeNode category = null;
    DefaultMutableTreeNode book = null;
    
    category = new DefaultMutableTreeNode("Books for Java Programmers");
    top.add(category);
    
    //original Tutorial
    book = new DefaultMutableTreeNode(new BookInfo
        ("The Java Tutorial: A Short Course on the Basics",
        "tutorial.html"));
    category.add(book);
    
    //Tutorial Continued
    book = new DefaultMutableTreeNode(new BookInfo
        ("The Java Tutorial Continued: The Rest of the JDK",
        "tutorialcont.html"));
    category.add(book);
    
    //Swing Tutorial
    book = new DefaultMutableTreeNode(new BookInfo
        ("The Swing Tutorial: A Guide to Constructing GUIs",
        "swingtutorial.html"));
    category.add(book);

    //...add more books for programmers...

    category = new DefaultMutableTreeNode("Books for Java Implementers");
    top.add(category);

    //VM
    book = new DefaultMutableTreeNode(new BookInfo
        ("The Java Virtual Machine Specification",
         "vm.html"));
    category.add(book);

    //Language Spec
    book = new DefaultMutableTreeNode(new BookInfo
        ("The Java Language Specification",
         "jls.html"));
    category.add(book);
}
/*
*  Method: getPreferredSize
*  Purpose: To get the perfered size of the Panel
*/
 public Dimension getPreferredSize(){
 return new Dimension(600,400);
 }
}
 


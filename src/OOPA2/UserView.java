/*
 * This Class is for the User View
 * The purpose of this class is to act as an object for a user to 
 * follow users and send msg. 
 * creates and instance of a User View object 
 * Parameters User
 */
package OOPA2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


/**
 *
 * @author davidmongiello
 */
public class UserView extends JPanel {
   
  public UserView()
  {
    // Set the border color of the panel
    setBorder(BorderFactory.createLineBorder(Color.darkGray));
    // Set the background of this panel
    this.setBackground(new Color(47,153,189) );
    // Declare all the controls and set their max values 
    // and prefered values. They are declared in order they show up on the
    // panel. 
    JTextField userID = new JTextField(); 
    userID.setMaximumSize(new Dimension(250,60));
    JButton followUser = new JButton("Follow User");
    followUser.setMaximumSize(new Dimension(150,60));
    followUser.setPreferredSize(new Dimension(150,60));
    JTextField tweetMsg = new JTextField();
    tweetMsg.setMaximumSize(new Dimension(250,60));
    JButton postTweet = new JButton("Post Tweet");
    postTweet.setMaximumSize(new Dimension(150,60));
    postTweet.setPreferredSize(new Dimension(150,60));
    // Make a tempary list of people to add to the list views
    DefaultListModel listModel = new DefaultListModel();
    listModel.addElement("Jane Doe");
    listModel.addElement("John Smith");
    listModel.addElement("Kathy Green");
     // Jlist view 1 for whom the user is currently following. 
    JList currentFollowing = new JList(listModel);
    currentFollowing.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    currentFollowing.setLayoutOrientation(JList.VERTICAL);
    currentFollowing.setVisibleRowCount(-1);
    // put Jlist in a scroll panel
    JScrollPane listScroller = new JScrollPane(currentFollowing);
    listScroller.setPreferredSize(new Dimension(250, 80));
    listScroller.setMaximumSize(new Dimension(380, 100));
    // JList two for newsfeed. 
    JList newsFeed = new JList(listModel);
    newsFeed.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    newsFeed.setLayoutOrientation(JList.VERTICAL);
    newsFeed.setVisibleRowCount(-1);
    // Put newsfeed in a scroll panel. 
    JScrollPane newFeedScroller = new JScrollPane(newsFeed);
    newFeedScroller.setMaximumSize(new Dimension(380, 100));
    // Containers for layout control
    final Container contentPane = new Container();
    final Container contentPane2 = new Container();
    final Container contentPane3 = new Container();
    final Container contentPane4 = new Container();
    // Create first Line of controls
    contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.X_AXIS)); 
    contentPane.add(userID);
    contentPane.add(followUser);
    // The following list view
    contentPane2.setLayout(new BoxLayout(contentPane2,BoxLayout.X_AXIS));  
    contentPane2.add(listScroller);
    // Create second list of controls
    contentPane3.setLayout(new BoxLayout(contentPane3,BoxLayout.X_AXIS));  
    contentPane3.add(tweetMsg);
    contentPane3.add(postTweet);
    // Create the news feed list view
    contentPane4.setLayout(new BoxLayout(contentPane4,BoxLayout.X_AXIS));  
    contentPane4.add(newFeedScroller);
    // Add it all to the panel 
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(Box.createRigidArea(new Dimension(5,10)));
    add(contentPane);
    add(Box.createRigidArea(new Dimension(5,10)));
    add(contentPane2);
    add(Box.createRigidArea(new Dimension(5,10)));
    add(contentPane3);
    add(Box.createRigidArea(new Dimension(5,10)));
    add(contentPane4);  
}
/*
*  Method: getPreferredSize
*  Purpose: To get the perfered size of the Panel
*/
 public Dimension getPreferredSize(){
 return new Dimension(400,350);
 }   
}

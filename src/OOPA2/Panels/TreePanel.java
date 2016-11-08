/*
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  Create a Singlton class that handles the display of 
 *            The tree view controller. 
 */
package OOPA2.Panels;

import OOPA2.Composite.User;
import OOPA2.Composite.Group;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author davidmongiello
 */
public class TreePanel extends JPanel {
    // This implemantation of the singleton pattarn works with multi
    // threading in java. To reference this class we just reference
    // INSTANCE and there is no way two instances can be created 
    // because of multi threading. 
    public final static TreePanel INSTANCE = new TreePanel(); 
    
    // Create a main group that holds everybody and place at top of
    // the tree. 
    DefaultMutableTreeNode rootNode =
        new DefaultMutableTreeNode(new Group("Everybody"));
    
    // Create a tree model that we can work with. 
    DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    // Create the Jtree with the our tree model. 
    JTree tree = new JTree(treeModel);
    
    private int lastIndex = 0 ;
    
    // The contructor to set up the GUI of the tree
    public TreePanel()
    {
    tree.setEditable(true);
    tree.getSelectionModel().setSelectionMode
        (TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.setShowsRootHandles(true);
    // We want to put the tree on a scroll pane for when it expands
    JScrollPane treeView = new JScrollPane(tree);
    // This is to regulate the size so that viewing is more predictable. 
    treeView.setMaximumSize(new Dimension(250,400));
    treeView.setPreferredSize(new Dimension(250,400));
    // Alays add it to the panel or users can't see it. 
    add(treeView);
    }
    
 
public DefaultMutableTreeNode addObject(Object child) {
    DefaultMutableTreeNode parentNode = null;
    TreePath parentPath = tree.getSelectionPath();
    if (findID(child.toString()))
    {
      return null; 
    } 
    
    if (parentPath == null) {
        //There is no selection. Default to the root node.
        parentNode = rootNode;
        parentPath = new TreePath(rootNode); 
        
    }
    
    // Test to get the type of tree node User or Group
    DefaultMutableTreeNode node = (DefaultMutableTreeNode)parentPath.getLastPathComponent(); 
    Object nodeInfo = node.getUserObject();
    
    if(nodeInfo instanceof Group)
    {
      parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
    
    }
    // It is not a group so get its parent which is a group. 
    else
    {
      parentNode = (DefaultMutableTreeNode)parentPath.getLastPathComponent();
      parentNode = (DefaultMutableTreeNode)parentNode.getParent(); 
    }
    // Call the Overload of add to actually at the element in the right index.
    // And update the jtree so the new element is visable. 
    return addObject(parentNode, child, true);
    
}

public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                        Object child,
                                        boolean shouldBeVisible) {
    DefaultMutableTreeNode childNode =
            new DefaultMutableTreeNode(child);

    treeModel.insertNodeInto(childNode, parent,
                             parent.getChildCount());

    //Make sure the user can see the lovely new node.
    if (shouldBeVisible) {
        tree.scrollPathToVisible(new TreePath(childNode.getPath()));
    }
    return childNode;
}

// This is used to check if the Id is already in the tree. 
public boolean findID(String iD)
{
  ArrayList<String> composites = getChildren(rootNode);
  for (int x = 0; x < composites.size();x++)
  {
    if (composites.get(x).equals(iD))
    {
      lastIndex = x; 
      return true; 
    }
  }
  return false; 
}

public User getUser()
{
  DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                     tree.getModel().getChild(rootNode, lastIndex);
  Object temp = node.getUserObject();
  if (temp instanceof User) {
       
      return (User)temp;
        
    } 
 
 return null; 
}

public ArrayList<String> getChildren(DefaultMutableTreeNode rootNode)
{
  ArrayList<String> composites = new ArrayList();
  for (int x = 0; x < rootNode.getChildCount();x++)
  {
    composites.add((tree.getModel().getChild(rootNode, x).toString()));
  }
  return composites; 
}

public User getSelection()
{
  DefaultMutableTreeNode node = null;
  TreePath parentPath = tree.getSelectionPath();
 if (parentPath == null) {
        //There is no selection. Default to the root node.
        node = rootNode;
    } else {
        node = (DefaultMutableTreeNode)
                     (parentPath.getLastPathComponent());
    }
    if (node == null)
    {
    //Nothing is selected.     
    return null;
    }
    
    Object nodeInfo = node.getUserObject();
    if (nodeInfo instanceof User) {
       
      return (User)nodeInfo;
        
    } 
 
 return null; 
}
/*
*  Method: getPreferredSize
*  Purpose: To get the perfered size of the Panel
*/
 @Override
 public Dimension getPreferredSize(){
 return new Dimension(250,400);
 }
}

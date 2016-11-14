/*
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/13/2016
 * Purpose :  Create a Singlton class that handles the display of 
 *            The tree view controller. 
              This class creates new instances of Users and groups.
              Allow for accessing these instances and adding them
              in the tree. 
 */
package OOPA2.Singleton;

import OOPA2.Composite.Composite;
import OOPA2.Composite.User;
import OOPA2.Composite.Group;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author davidmongiello
 */
public class TreePanel extends JPanel 
{
  // This implemantation of the singleton pattarn works with multi
  // threading in java. To reference this class we just reference
  // INSTANCE and there is no way two instances can be created 
  // because of multi threading. 

  public final static TreePanel INSTANCE = new TreePanel();

  // Create a main group that holds everybody and place at top of
  // the tree. 
  DefaultMutableTreeNode rootNode
          = new DefaultMutableTreeNode(new Group("Everybody"));

  // Create a tree model that we can work with. 
  DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
  // Create the Jtree with the our tree model. 
  JTree tree = new JTree(treeModel);

  // The contructor to set up the GUI of the tree
  public TreePanel() {
    tree.setCellRenderer(new MyTreeCellRenderer());
    tree.setEditable(true);
    tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    tree.setShowsRootHandles(true);
    // We want to put the tree on a scroll pane for when it expands
    JScrollPane treeView = new JScrollPane(tree);
    // This is to regulate the size so that viewing is more predictable. 
    treeView.setMaximumSize(new Dimension(250, 400));
    treeView.setPreferredSize(new Dimension(250, 400));
    // Alays add it to the panel or users can't see it. 
    add(treeView);
  }
    
// This method was taking from Oricles JTree tutorial and was 
// adjusted to the needs of this project. 
public DefaultMutableTreeNode addObject(Object child)
{
    DefaultMutableTreeNode parentNode = null;
    TreePath parentPath = tree.getSelectionPath();
    if (findID(child.toString()) != null) {
      return null;
    }

    if (parentPath == null) {
      //There is no selection. Default to the root node.
      parentNode = rootNode;
      parentPath = new TreePath(rootNode);
    }

    // Test to get the type of tree node User or Group
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
    Object nodeInfo = node.getUserObject();

    if (nodeInfo instanceof Group) {
      parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
      node.setAllowsChildren(true);
    } // It is not a group so get its parent which is a group. 
    else {
      parentNode = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
      parentNode = (DefaultMutableTreeNode) parentNode.getParent();
      node.setAllowsChildren(false);
    }
    // Call the Overload of add to actually at the element in the right index.
    // And update the jtree so the new element is visable. 
    return addObject(parentNode, child, true);

  }
// This method was taken from the javaswing tutorial website and 
// altered to fit this project. 
// It adds a node to the tree and adds a composite to the composite parent node. 

  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
          Object child,
          boolean shouldBeVisible) {
    DefaultMutableTreeNode childNode
            = new DefaultMutableTreeNode(child);

    // Insert the node to the tree. 
    treeModel.insertNodeInto(childNode, parent,
            parent.getChildCount());
    // Insert pointer to the list of composites in the parent. 
    // The child can be a User or a Group. 
    insertUser(getObject(child), getObject(parent.getUserObject()));
    //Make sure the user can see the lovely new node.
    if (shouldBeVisible) {
      tree.scrollPathToVisible(new TreePath(childNode.getPath()));
    }
    return childNode;
  }
// This method adds a user to the group. this is its own method for functianality
//   encapsalation.

  private void insertUser(Composite user, Composite parent) {
    Group temp = (Group) parent;
    temp.add((Composite) user);
  }
// Returns a user or group from the tree node. 

  private Composite getObject(Object temp) {
    if (temp instanceof User) {
      return (User) temp;
    } else if (temp instanceof Group) {
      return (Group) temp;
    }
    return null;
  }
// find an ID and return the node.  

  public DefaultMutableTreeNode findID(String iD) {
    Enumeration e = rootNode.preorderEnumeration();
    while (e.hasMoreElements()) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
      if (node.toString().equals(iD)) {
        return node;
      }
    }
    return null;
  }

// this method returns a User object from the tree by the userID. 
  public User getUser(String userID) {
    DefaultMutableTreeNode node = findID(userID);
    Object temp = node.getUserObject();
    if (temp instanceof User) {
      return (User) temp;
    }
    return null;
  }

  public ArrayList<DefaultMutableTreeNode> getChildren(DefaultMutableTreeNode rootNode) {
    ArrayList<DefaultMutableTreeNode> composites = new ArrayList();
    for (int x = 0; x < rootNode.getChildCount(); x++) {
      composites.add((DefaultMutableTreeNode) (tree.getModel().getChild(rootNode, x)));
    }
    return composites;
  }

  public Composite getSelection() {
    DefaultMutableTreeNode node = null;
    TreePath parentPath = tree.getSelectionPath();
    if (parentPath == null) {
      //There is no selection. Default to the root node.
      node = rootNode;
    } else {
      node = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
    }
    if (node == null) {
      //Nothing is selected.     
      return null;
    }

    Object nodeInfo = node.getUserObject();
    return getObject(nodeInfo);
  }
// I took this from stack overflow and adjusted to my needs. 
// It sets the icons for the defferent kinds of composites(User or Group). 

  private static class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
      super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
      if (value instanceof DefaultMutableTreeNode) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        if (node.getUserObject() instanceof Group) {
          setIcon(UIManager.getIcon("FileChooser.homeFolderIcon"));
        } else if (node.getUserObject() instanceof User) {
          setIcon(UIManager.getIcon("FileView.fileIcon"));
        }
      }
      return this;
    }

  }

  /*
*  Method: getPreferredSize
*  Purpose: To get the perfered size of the Panel
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(250, 400);
  }
}

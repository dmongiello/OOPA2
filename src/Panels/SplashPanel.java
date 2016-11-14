/*
 * Author:  David R. Mongiello
 * Course Name: Object Oreinted Programing
 * Assignment : OOP assignment 2
 * Date Last Modified : 11/7/2016
 * Purpose :  Creates a classy splash screen to look at while loading.
 */
package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author davidmongiello
 */

/*
*  Class: SplashPanel
*  Purpose: To present a splash screen to the user on startup.
*/
public class SplashPanel extends JPanel {
    private BufferedImage pic = null;
public SplashPanel()
{
setBorder(BorderFactory.createLineBorder(Color.darkGray));
this.setBackground(new Color(47,153,189) );
JLabel caption = new JLabel("Assignment (2)Two", SwingConstants.CENTER);
JLabel team = new JLabel("By : Realistic Design", SwingConstants.CENTER);
caption.setFont(new Font("Jokerman", Font.PLAIN, 48));
team.setFont(new Font("Jokerman", Font.PLAIN, 20));
caption.setAlignmentX(Component.CENTER_ALIGNMENT);
team.setAlignmentX(Component.CENTER_ALIGNMENT);
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

add(Box.createRigidArea(new Dimension(5,30)));
add(caption);
add(Box.createRigidArea(new Dimension(5,200)));
add(team);

}

/*
*  Method: getPreferredSize
*  Purpose: To get the perfered size of the Panel
*/
 public Dimension getPreferredSize(){
 return new Dimension(600,400);
 }
 /*
*  Method: paintComponent
*  Purpose: to paint the components of the panel
*/
 public void paintComponent(Graphics g){
 super.paintComponent(g);
 
 g.drawImage(pic,50,50, 100, 100, this); 
 }
}

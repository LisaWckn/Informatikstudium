/**
 * Program for task sheet 10
 * 
 * Exercise 10a - ChristmasGUI
 * 
 * This is the Canvas class for the left part of the GUI. The test class can be found in ChristmasTest.java.
 * Further classes for this sheet can be found in the files ChristmasTest.java, Menu.java,
 * Santa.java, Stars.java and Tree.java.
 * 
 * @author Lisa Weickenmeier
 */

 import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel{

    /**
     * Constructor for the canvas. An empty canvas contains only te background and the snow.
     * @param content array of boolean. The zero entry is for the christmas tree, 
     * the first entry is for the christmas tree plus stars and the second entry is for santa.
     * @param starCount the stars to show, if content[1] is true
     */
    public Canvas(boolean[] content, int starCount){
        setSize(400, 300);
        setBackground(new Color(26,26,54));
        setLayout(null);

        if(content[0]){
            Tree tree = new Tree();
            tree.setBounds(0, 0, 400, 300);
            add(tree);
        }

        if(content[1]){
            Stars stars = new Stars(starCount);
            stars.setBounds(0, 0, 400, 300);
            add(stars);
        }

        if(content[2]){
            Santa santa = new Santa();
            santa.setBounds(0, 0, 400, 300);
            add(santa);
        }

        JPanel snow = snow();
        snow.setBounds(0, 0, 400, 300);
        add(snow);
    }
 
    /**
     * Extra method to paint the bottom white as snow.
     * @return the snow as JPanel.
     */
    private JPanel snow(){
         JPanel snow = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 200, 400, 100);
                }
            };
            
        snow.setPreferredSize(new Dimension(400, 300));
        snow.setOpaque(false);
        snow.setToolTipText("Snow");
        return snow;
    }
}

/**
 * Program for task sheet 10
 * 
 * Exercise 10b - Christmastree and Stars
 * 
 * This is the Stars class for the stars on the canvas. The test class can be found in ChristmasTest.java.
 * Further classes for this sheet can be found in the files ChristmasTest.java, Menu.java,
 * Santa.java, Canvas.java and Tree.java.
 * 
 * @author Lisa Weickenmeier
 */

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Stars extends JPanel{

    /**
     * Constructor to a JPanel with stars.
     * @param starCount the stars to paint.
     */
    public Stars(int starCount){
        setOpaque(false);
        setLayout(null);
        for(int i=0;i<starCount;i++){
            JPanel star = oneStar();
            star.setBounds(0, 0, 400, 300);
            add(star);
        }
    }

    /**
     * Method to paint one star on a random position with a random color.
     * @return JPanel with one star.
     */
    private JPanel oneStar(){
        JPanel star = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(getRandomColor());
                    int x = getRandomXInt();
                    int y = getRandomYInt();
                    g.fillOval(x, y, 2, 2);
                }
            };
        star.setPreferredSize(new Dimension(400, 300));
        star.setOpaque(false);
        star.setToolTipText("Star");
        return star;
    }

    /**
     * Method to get a random int for the x position.
     * @return int between 0 and 400
     */
    private int getRandomXInt(){
        int rand = (int)(Math.random()*400);
        return rand;
    }

    /**
     * Method to get a random int for the y position in the sky.
     * @return int between 0 and 200
     */
    private int getRandomYInt(){
        int rand = (int)(Math.random()*200);
        return rand;
    }

    /**
     * Method to get a random color.
     * @return random Color
     */
    private Color getRandomColor(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }
}

/**
 * Program for task sheet 11
 * 
 * Exercise 11a - CircleSection
 * 
 * This is the CircleSectionCanvas class for the left size of the frame. The test class can be found in CircleSectionTest.java.
 * Further classes for this sheet can be found in the files CircleSection.java and CircleSectionMenu.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.*;

public class CircleSectionCanvas extends JPanel {
    /**
     * Constructor which creates a grid with n*n fields and paints a circle section in each field.
     * @param n The count of circles in each row and the count of rows.
     */
    public CircleSectionCanvas(int n){
        setSize(500, 600);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(n,n));
        double deg = 360/(n*n);
        double diameter = 500/n;
        for(int i=0;i<n*n;i++){
            add(drawCircle(deg*(i+1), diameter));
        }
    }

    /**
     * This method draws one circle section. The background is a random color.
     * @param deg The angular of the section to draw as double.
     * @param diameter The diameter of the circle as double.
     * @return The circle section as JPanel.
     */
    public JPanel drawCircle(double deg, double diameter){
        JPanel circle = new JPanel() {
            @Override
            public void paint(Graphics g) {
                Graphics2D ga = (Graphics2D) g;

                ga.setPaint(getRandomColor());
                Arc2D arc2D4 = new Arc2D.Double(0, 0, diameter, diameter, 0, deg, Arc2D.PIE);
                ga.fill(arc2D4);
                ga.draw(arc2D4);
            }
        };
        circle.setOpaque(false);
        return circle;
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

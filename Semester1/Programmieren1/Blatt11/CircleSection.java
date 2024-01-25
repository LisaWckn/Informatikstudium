/**
 * Program for task sheet 11
 * 
 * Exercise 11a - CircleSection
 * 
 * This is the CircleSection class the frame. The test class can be found in CircleSectionTest.java.
 * Further classes for this sheet can be found in the files CircleSectionMenu.java and CircleSectionCanvas.java.
 * 
 * @author Lisa Weickenmeier
 */

import javax.swing.*;
import java.awt.*;

public class CircleSection extends JFrame {
    private CircleSectionCanvas canvas = new CircleSectionCanvas(3);
    private CircleSectionMenu menu = new CircleSectionMenu(this);

    /**
     * Constructor for the frame with the canvas on the left side and the menu with the slider on the right side.
     */
    public CircleSection(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                setSize(600, 600);
                setLayout(new BorderLayout());
                add(canvas, BorderLayout.CENTER);
                add(menu, BorderLayout.LINE_END);
                setTitle("Circlesection");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });
    }

    /**
     * Method to refresh the canvas with the new count.
     * @param n Value for the row count and the circles in each row.
     */
    public void refresh(int n){
        getContentPane().remove(canvas);
        canvas = new CircleSectionCanvas(n);
        add(canvas, BorderLayout.CENTER);
        revalidate();
    }
}

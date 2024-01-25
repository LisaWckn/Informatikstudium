/**
 * Program for task sheet 10
 * 
 * Exercise 10c - Santa
 * 
 * This is the Santa class for the flying santa. The test class can be found in ChristmasTest.java.
 * Further classes for this sheet can be found in the files ChristmasTest.java, Menu.java,
 * Canvas.java, Stars.java and Tree.java.
 * 
 * @author Lisa Weickenmeier
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Santa extends JPanel{

    private int x = 0;
    private int y = 25;

    private BufferedImage santaPic;
    private final String PATH = "C:/Users/lisaw/Desktop/santa.png";

    /**
     * Constructor to paint the santa and let him fly in an endless loop from left to right.
     */
    public Santa(){
        try{
            santaPic = ImageIO.read(new File(PATH));
        } catch(Exception e){
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(400, 300));
        setOpaque(false);
        setToolTipText("Santa Clause");

        Action upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y -= 2;
                if (y < 0) {
                    y = 0;
                }
                repaint();
            }
        };

        Action downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y += 2;
                if (y + 30 > 200) {
                    y = 170;
                }
                repaint();
            }
        };

        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), upAction);
        bindKeyStroke(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), downAction);

        /**
         * Endless timer which increases the x position of santa.
         */
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    x+=1;
                    if(x>400){
                        x=0;
                    }
                    repaint();
            }
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }

    /**
     * Method to bind the key strokes. 
     * @param condition for the input map e.g. when focused in window.
     * @param name of the binding
     * @param keyStroke for the key
     * @param action to call when the key is clicked
     */
    protected void bindKeyStroke(int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }

    /**
     * Method to paint the santa.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(santaPic, x, y,30,30, null);
    }
}

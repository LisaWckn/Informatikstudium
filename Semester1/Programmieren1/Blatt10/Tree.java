/**
 * Program for task sheet 10
 * 
 * Exercise 10b - Christmastree and Stars
 * 
 * This is the ChristmasTree class for the christmastree on the canvas. The test class can be found in ChristmasTest.java.
 * Further classes for this sheet can be found in the files ChristmasTest.java, Menu.java,
 * Santa.java, Canvas.java and Stars.java.
 * 
 * @author Lisa Weickenmeier
 */

 import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tree extends JPanel{

    /**
     * Constructor to show the tree.
     */
    public Tree(){
        setOpaque(false);
        setLayout(null);
        JPanel treeTop = treeTriangle(80, 80, 25);
        treeTop.setBounds(0, 0, 400, 300);
        add(treeTop);
        JPanel treeMiddle = treeTriangle(120, 80, 70);
        treeMiddle.setBounds(0, 0, 400, 300);
        add(treeMiddle);
        JPanel treeBottom = treeTriangle(140, 80, 110);
        treeBottom.setBounds(0, 0, 400, 300);
        add(treeBottom);
        JPanel treeTrunk = treeTrunk(190);
        treeTrunk.setBounds(0, 0, 400, 300);
        add(treeTrunk);
    }

    /**
     * Method to paint the tree trunk.
     * @param paddingTop distance to the top of the canvas
     * @return JPanel with the tree trunk
     */
    private JPanel treeTrunk(int paddingTop){
        JPanel treeTrunk = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(new Color(51, 25, 0));
                    g.fillRect(185, paddingTop, 30, 2);
                    g.setColor(new Color(102, 51, 0));
                    g.fillRect(185, paddingTop+2, 30, 33);

                }
            };
        treeTrunk.setPreferredSize(new Dimension(400, 300));
        treeTrunk.setOpaque(false);  
        treeTrunk.setToolTipText("Treetrunk");
        return treeTrunk;
    }

    /**
     * Method to paint one triangle of the tree with the christmasbulbs on the edges.
     * @param triangleWidth the width of the bottom of the triangle
     * @param triangleHeight the height of the triangle
     * @param paddingTop distance to the top of the canvas
     * @return JPanel with a green triangle and two christmasbulbs
     */
    private JPanel treeTriangle(int triangleWidth, int triangleHeight, int paddingTop){
        JPanel treeTriangle = new JPanel();
        treeTriangle.setOpaque(false);
        treeTriangle.setLayout(null);

        JPanel christmasBulb1 = christmasBulb(195 - triangleWidth/2, triangleHeight + paddingTop -5);
        christmasBulb1.setBounds(0, 0, 400, 300);
        treeTriangle.add(christmasBulb1);

        JPanel christmasBulb2 = christmasBulb(195 + triangleWidth/2, triangleHeight + paddingTop -5);
        christmasBulb2.setBounds(0, 0, 400, 300);
        treeTriangle.add(christmasBulb2);

        JPanel triangle = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Polygon triangle = new Polygon();
                    triangle.addPoint(200 - triangleWidth/2, triangleHeight + paddingTop);
                    triangle.addPoint(200 + triangleWidth/2, triangleHeight + paddingTop);
                    triangle.addPoint(200, paddingTop);

                    g.setColor(new Color(20, 69, 13));
                    g.fillPolygon(triangle);
                }
            };
        triangle.setPreferredSize(new Dimension(400, 300));
        triangle.setOpaque(false);
        triangle.setBounds(0, 0, 400, 300);
        treeTriangle.add(triangle);
        treeTriangle.setToolTipText("Tree");

        return treeTriangle;
    }

    /**
     * Method to paint one christmasbulb with a random color.
     * @param paddingLeft distance to the left side of the canvas
     * @param paddingTop distance to the top of the canvas
     * @return JPanel with one christmasbulb
     */
    private JPanel christmasBulb(int paddingLeft, int paddingTop){
        JPanel christmasBulb = new JPanel(){
            @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(getRandomColor());
                    g.fillOval(paddingLeft, paddingTop, 10, 10);
                }
        };
        christmasBulb.setPreferredSize(new Dimension(400, 300));
        christmasBulb.setOpaque(false);
        christmasBulb.setToolTipText("Christmasbulb");
        return christmasBulb;
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

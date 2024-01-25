/**
 * Program for task sheet 10
 * 
 * Exercise 10a - ChristmasGUI
 * 
 * This is the menu class for the right part of the GUI. The test class can be found in ChristmasTest.java.
 * Further classes for this sheet can be found in the files ChristmasTest.java, 
 * Santa.java, Canvas.java, Stars.java and Tree.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Menu extends JPanel implements ActionListener{
    private ChristmasGUI cGUI;
    private JButton btn;
    private JTextField textStars;
    private JRadioButton rbTree = new JRadioButton("Christmastree");
    private JRadioButton rbTreeStars = new JRadioButton("Christmastree + Stars");
    private JCheckBox cbSanta = new JCheckBox("Santa");

    /**
     * Constructor for the menu.
     * @param cGUI the christmas GUI which contains this menu.
     */
    public Menu(ChristmasGUI cGUI){
        this.cGUI = cGUI;
        setBorder(new EmptyBorder(2, 2, 2, 2));
        setPreferredSize(new Dimension(200, 300));
        setLayout(new BorderLayout());

        add(menuCenter(), BorderLayout.CENTER);

        btn = new JButton("Start");
        btn.addActionListener(this);
        add(btn, BorderLayout.PAGE_END);
    }

    /**
     * Method which is called when the button is clicked.
     * It gets the selection and the entered stars from the menu and refreshes the christmas GUI.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        /**
         * In this parts the method gets the text from the text box and trys to parse it to an integer value.
         * If this isn't possible the starCount is set to zero.
         */
        String starText = textStars.getText();
        int starCount;
        try{
            starCount = Integer.parseInt(starText);
        }catch(NumberFormatException nfe){
            starCount = 0;
        }

        boolean[] content = {false, false, false};
        if(rbTree.isSelected()){
            content[0] = true;
        }else if(rbTreeStars.isSelected()){
            content[0] = true;
            content[1] = true;
        }
        content[2] = cbSanta.isSelected();

        cGUI.refresh(content, starCount);
    }

    /**
     * The center of the menu which contains the radiobuttons for the christmastree and the stars, 
     * the checkbox for santa and the textbox for the starcount.
     * @return the menu as JPanel.
     */
    private JPanel menuCenter(){
        JPanel menuCenter = new JPanel();
        menuCenter.setPreferredSize(new Dimension(200, 250));
        menuCenter.setLayout(new FlowLayout());

        menuCenter.add(selection());

        menuCenter.add(starTB());

        return menuCenter;
    }

    /**
     * Method to create a textbox for the starcount.
     * @return JPanel with label and textbox.
     */
    private JPanel starTB(){
        JPanel starTB = new JPanel();
        starTB.setSize(new Dimension(200, 30));
        starTB.setLayout(new BorderLayout());

        JLabel ta = new JLabel("# stars: ");
        starTB.add(ta, BorderLayout.LINE_START);
        textStars = new JTextField("100");
        textStars.setPreferredSize(new Dimension(150, 30));
        textStars.setToolTipText("Textbox for the starcount.");
        starTB.add(textStars, BorderLayout.CENTER);

        return starTB;
    }

    /**
     * Method to create the JPanel with the radiobuttons and the checkbox inside.
     * @return JPanel for the selection part.
     */
    private JPanel selection(){
        JPanel selection = new JPanel();

        TitledBorder title = BorderFactory.createTitledBorder("Selection");
        selection.setBorder(title);
        selection.setPreferredSize(new Dimension(200, 100));

        selection.setLayout(new GridLayout(0,1));

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbTree);
        bg.add(rbTreeStars);

        rbTree.setToolTipText("Select for the christmastree.");
        rbTreeStars.setToolTipText("Select for the christmastree and the stars.");
        cbSanta.setToolTipText("Select for the flying santa.");

        selection.add(rbTree);
        selection.add(rbTreeStars);
        selection.add(cbSanta);

        return selection;
    }
}

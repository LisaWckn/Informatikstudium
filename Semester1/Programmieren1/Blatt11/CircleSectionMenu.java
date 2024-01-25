/**
 * Program for task sheet 11
 * 
 * Exercise 11a - CircleSection
 * 
 * This is the CircleSectionMenu class for the right size of the frame. The test class can be found in CircleSectionTest.java.
 * Further classes for this sheet can be found in the files CircleSection.java and CircleSectionCanvas.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.awt.*;
import java.util.Hashtable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleSectionMenu extends JPanel implements ActionListener{
    private JSlider _jSlider = new JSlider(SwingConstants.VERTICAL, 1, 10, 3);
    private CircleSection _circleSection;

    /**
     * Constructor to create the slider and the button which starts the painting.
     * @param cS related CircleSection
     */
    public CircleSectionMenu(CircleSection cS){
        _circleSection = cS;
        setLayout(new BorderLayout());
        setSize(100, 600);
        _jSlider.setMajorTickSpacing(1);
        _jSlider.setPaintTicks(true);
        _jSlider.setLabelTable(sliderLabels());
        _jSlider.setPaintLabels(true);
        add(_jSlider, BorderLayout.CENTER);
        JButton btn = new JButton("Start");
        btn.addActionListener(this);
        add(btn, BorderLayout.PAGE_END);
    }

    /**
     * Method to create the custom labels for the slider.
     * @return custom labels
     */
    private Hashtable<Integer, JLabel> sliderLabels(){
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
        labelTable.put(1, new JLabel("1x1"));
        labelTable.put(5, new JLabel("5x5") );
        labelTable.put(10, new JLabel("10x10") );

        return labelTable;
    }

    /**
     * Method which is called when the button is clicked. It refreshes the CircleSectionCanvas with the new circle count n.
     */
    @Override
    public void actionPerformed(ActionEvent e){
        int n = _jSlider.getValue();
        _circleSection.refresh(n);
    }
}

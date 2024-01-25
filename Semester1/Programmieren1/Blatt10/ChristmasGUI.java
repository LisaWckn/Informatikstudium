/**
 * Program for task sheet 10
 * 
 * Exercise 10a - ChristmasGUI
 * 
 * This is the ChristmasGUI class which starts the GUI. The test class can be found in ChristmasTest.java.
 * Further classes for this sheet can be found in the files Menu.java, 
 * Santa.java, Canvas.java, Stars.java and Tree.java.
 * 
 * @author Lisa Weickenmeier
 */

 import java.awt.*;
import javax.swing.*;

public class ChristmasGUI extends JFrame{
    private boolean[] content = {false, false, false};
    private Canvas canvas = new Canvas(content, 0);
    private Menu menu = new Menu(this);
    private JLabel statusBar = statusBar(content);

    /**
     * Constructor which starts the GUI without content.
     */
    public ChristmasGUI(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                setSize(600,300);
                setLayout(new BorderLayout());
                add(canvas, BorderLayout.CENTER);
                add(menu, BorderLayout.LINE_END);
                add(statusBar, BorderLayout.PAGE_END);
                setTitle("ChristmasGUI");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }
        });
    }

    /**
     * Method to refresh the canvas.
     * @param content array of boolean. The zero entry is for the christmas tree, 
     * the first entry is for the christmas tree plus stars and the second entry is for santa.
     * @param starCount the stars to show, if content[1] is true
     */
    public void refresh(boolean[] content, int starCount){
        getContentPane().remove(canvas);
        getContentPane().remove(statusBar);
        canvas = new Canvas(content, starCount);
        statusBar = statusBar(content);
        add(canvas, BorderLayout.CENTER);
        add(statusBar, BorderLayout.PAGE_END);
        revalidate();
    }

    /**
     * Method to return the label for the status bar.
     * @param content array of boolean. The zero entry is for the christmas tree, 
     * the first entry is for the christmas tree plus stars and the second entry is for santa.
     * @return status as JLabel.
     */
    private JLabel statusBar(boolean[] content){
        JLabel statusBar = new JLabel();
        statusBar.setToolTipText("Status of the selection.");

        String status = "-";
        if(content[0] || content[1]){
            status="Christmastree";
        }
        if(content[1]){
            status+="+Stars";
        }
        if(content[2] && status == "-"){
            status = "Santa";
        }else if(content[2]){
            status += " plus Santa";
        }

        statusBar.setText(status);

        return statusBar;
    }
}
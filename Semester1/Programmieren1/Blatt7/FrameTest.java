/**
 * Programm zum Aufgabenblatt 7
 * 
 * Aufgabe 7b - Frame
 * 
 * This is the test class. The Frame class could be find in Frame.java.
 * 
 * @author Lisa Weickenmeier
 */

public class FrameTest {
    public static void main(String[] args) {
        //first test
        Frame f = new Frame();
        String[] strArr1 = {"Rahmen","sind","toll"};
        f.printFrame(strArr1);

        //second test
        String[] strArr2 = {"Das ist", "ein", "Test"};
        f.printFrame(strArr2);
    }
}

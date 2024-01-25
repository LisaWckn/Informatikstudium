/**
 * Programm zum Aufgabenblatt 6
 * 
 * Aufgabe 6b,c - Picture
 * 
 * This is the test class. The Picture class could be find in Picture.java.
 * 
 * @author Lisa Weickenmeier
 */

public class PictureTest {
    public static void main(String[] args) {
        Picture pic = new Picture();
        pic.readPic("java.pgm");
        pic.rotatePic();
        pic.writePic("directory");
    }
}

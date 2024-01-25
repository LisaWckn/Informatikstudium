/**
 * Programm zum Aufgabenblatt 5
 * 
 * Aufgabe 5c - Zoom
 * 
 * This is the test class. The Zoom class could be find in Zoom.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class ZoomTest {
    public static void main(String[] args) {
        //Testpic 1:
        System.out.println("First test:");
        int[][] pic1 = {{1,7,0},{1,0,3},{0,2,1}};
        Zoom zoom1 = new Zoom(pic1);
        System.out.println("Original pic:");
        zoom1.print(pic1);
        int[][] zoomedPic1 = zoom1.zoom(2);
        System.out.println("\nZoomed pic with f=2:");
        zoom1.print(zoomedPic1);
        int[][] zoomedPic2 = zoom1.zoom(3);
        System.out.println("\nZoomed pic with f=3:");
        zoom1.print(zoomedPic2);

        //Testpic 2:
        System.out.println("\n\nSecond test:");
        int[][] pic2 = {{1,0,2},{4,2,4},{2,0,1}};
        Zoom zoom2 = new Zoom(pic2);
        System.out.println("Original pic:");
        zoom2.print(pic2);
        int[][] zoomedPic21 = zoom2.zoom(2);
        System.out.println("\nZoomed pic with f=2:");
        zoom2.print(zoomedPic21);
        int[][] zoomedPic22 = zoom2.zoom(3);
        System.out.println("\nZoomed pic with f=3:");
        zoom2.print(zoomedPic22);
    }
}

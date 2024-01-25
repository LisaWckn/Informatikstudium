/** 
 * Programm zum Aufgabenblatt 3
 * 
 * Aufgabe 3c - Bild
 * 
 * This is the test class. The Bild class could be find in Bild.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class BildTest {
    public static void main(String[] args){
        //first test
        System.out.println("First Test:");
        int[][] mat1 = {{1,1,0,1},{0,1,0,1},{0,1,1,1},{1,0,1,0}};
        Bild pic1 = new Bild(mat1);
        System.out.println("Originalbild:");
        pic1.ausgabe();
        System.out.println("Bild nach flipAndInvert():");
        pic1.flipAndInvert();
        pic1.ausgabe();

        //second test
        System.out.println("\nSecond Test:");
        int[][] mat2 = {{0,0,1,1,0},{0,1,0,1,1},{1,0,0,1,1},{0,1,0,1,0}};
        Bild pic2 = new Bild(mat2);
        System.out.println("Originalbild:");
        pic2.ausgabe();
        System.out.println("Bild nach flipAndInvert():");
        pic2.flipAndInvert();
        pic2.ausgabe();
    }
}

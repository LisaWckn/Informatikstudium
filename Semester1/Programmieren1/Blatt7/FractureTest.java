/**
 * Programm zum Aufgabenblatt 7
 * 
 * Aufgabe 7a - Fracture
 * 
 * This is the test class. The Fracture class could be find in Fracture.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class FractureTest {
    public static void main(String[] args) {
        Fracture frac1 = new Fracture(34, 42);
        System.out.println("Frac1: " + frac1.toString());

        Fracture frac2 = new Fracture(2, 3);
        System.out.println("Frac2: " + frac2.toString());

        Fracture frac3 = new Fracture(4, 2);
        System.out.println("Frac3: " + frac3.toString());

        Fracture add3to2 = frac2.add(frac3);
        System.out.println("Frac2 + Frac3 = " + add3to2.toString());

        Fracture multiply3to2 = frac2.multiply(frac3);
        System.out.println("Frac2 * Frac3 = " + multiply3to2.toString());
    }
}

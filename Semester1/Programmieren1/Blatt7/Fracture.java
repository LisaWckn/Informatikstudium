/**
 * Programm zum Aufgabenblatt 7
 * 
 * Aufgabe 7a - Fracture
 * 
 * This is the Fracture class. The test class could be find in FractureTest.java.
 * 
 * @author Lisa Weickenmeier
 */

public class Fracture {
    private int numerator = 0;
    private int denominator = 1;

    /**
     * Constructor which only constructs a fracture if the denominator is not zero.
     * @param numerator
     * @param denominator
     * @throws IllegalArgumentException if the denominator is zero to avoid an invalid fracture.
     */
    public Fracture(int numerator, int denominator) throws IllegalArgumentException{
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }else{
            throw new IllegalArgumentException("The denumerator cannot be zero.");
        }
    }

    /**
     * This method adds to the fracture a given fracture.
     * @param f
     * @return the result of the sum
     */
    public Fracture add(Fracture f){
        int newNum = this.numerator * f.denominator + f.numerator * this.denominator;
        int newDen = f.denominator * this.denominator;

        return new Fracture(newNum, newDen);
    }

    /**
     * This method multiply the class fracture with a given fracture.
     * @param f
     * @return the result of the multiplication
     */
    public Fracture multiply(Fracture f){
        int newNum = this.numerator * f.numerator;
        int newDen = f.denominator * this.denominator;

        return new Fracture(newNum, newDen);
    }

    /**
     * This method makes a string from the fracture.
     * @return the fracture as string
     */
    public String toString(){
        return this.numerator + " / " + this.denominator;
    }
}

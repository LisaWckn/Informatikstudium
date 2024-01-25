/**
 * Program for task sheet 9
 * 
 * Exercise 9a - Arithmetic
 * 
 * This is the MathApplication test class. The matching class can be found in Arithmetic.java.
 * Further classes/interfaces for this task can be found in the files MathApplication2.java, ArithmeticGeneric.java, 
 * RakePath.java, RakePathPlus.java, RakePathMinus.java and RakePathTimes.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class MathApplication {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic();
        double result;

        arithmetic.determineRakePath(new RakePathPlus());
        result = arithmetic.calculate(2, 3);
        System.out.println("Result 2+3:" + result);

        arithmetic.determineRakePath(new RakePathMinus());
        result = arithmetic.calculate(2, 3);
        System.out.println("Result 2-3:" + result);

        arithmetic.determineRakePath(new RakePathTimes());
        result = arithmetic.calculate(2, 3);
        System.out.println("Result 2-3:" + result);
    }
}
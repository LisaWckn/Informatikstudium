/**
 * Program for task sheet 9
 * 
 * Exercise 9a - Arithmetic
 * 
 * This is the MathApplication2 test class. The matching class can be found in ArithmeticGeneric.java.
 * Further classes/interfaces for this task can be found in the files MathApplication.java, Arithmetic.java, 
 * RakePath.java, RakePathPlus.java, RakePathMinus.java and RakePathTimes.java.
 * 
 * @author Lisa Weickenmeier
 */

public class MathApplication2 {
    public static void main(String[] args) {
        double result;

        ArithmeticGeneric<RakePathPlus> arithmeticPlus = new ArithmeticGeneric<>();
        arithmeticPlus.determineRakePath(new RakePathPlus());
        result = arithmeticPlus.calculate(2, 3);
        System.out.println("Result 2+3:" + result);

        ArithmeticGeneric<RakePathMinus> arithmeticMinus = new ArithmeticGeneric<>();
        arithmeticMinus.determineRakePath(new RakePathMinus());
        result = arithmeticMinus.calculate(2, 3);
        System.out.println("Result 2-3:" + result);

        ArithmeticGeneric<RakePathTimes> arithmeticTimes = new ArithmeticGeneric<>();
        arithmeticTimes.determineRakePath(new RakePathTimes());
        result = arithmeticTimes.calculate(2, 3);
        System.out.println("Result 2-3:" + result);
    }
}

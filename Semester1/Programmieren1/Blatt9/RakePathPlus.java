/**
 * Program for task sheet 9
 * 
 * Exercise 9a - Arithmetic
 * 
 * This is the RakePathPlus class which implements the RakePath interface.
 * Further classes for this task can be found in the files MathApplication.java, Arithmetik.java, 
 * MathApplication2.java, ArithmeticGeneric.java, 
 * RakePathMinus.java and RakePathTimes.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class RakePathPlus implements RakePath{
    @Override
    public double calcResult(double a, double b){
        return a+b;
    }
}

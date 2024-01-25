/**
 * Program for task sheet 9
 * 
 * Exercise 9a - Arithmetic
 * 
 * This is the Arithmetic class. The matching test class can be found in MathApplication.java.
 * Further classes/interfaces for this task can be found in the files MathApplication2.java, ArithmeticGeneric.java, 
 * RakePath.java, RakePathPlus.java, RakePathMinus.java and RakePathTimes.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Arithmetic {
    private RakePath calculation;

    /**
     * Method to set the private var calculation to a RakePath.
     * @param rakePath 
     */
    public void determineRakePath(RakePath rakePath){
        this.calculation = rakePath;
    }

    /**
     * Method to calculate the correct result.
     * @param a first operant
     * @param b second operant
     * @return the result of the operation 
     */
    public double calculate(double a, double b){
        try {
            return calculation.calcResult(a, b);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}

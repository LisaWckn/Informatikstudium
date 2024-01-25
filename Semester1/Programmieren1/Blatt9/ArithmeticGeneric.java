/**
 * Program for task sheet 9
 * 
 * Exercise 9a - Arithmetic
 * 
 * This is the ArithmeticGeneric class. The matching test class can be found in MathApplication2.java.
 * Further classes/interfaces for this task can be found in the files MathApplication.java, Arithmetic.java, 
 * RakePath.java, RakePathPlus.java, RakePathMinus.java and RakePathTimes.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class ArithmeticGeneric<T extends RakePath> {
    private T calculation;

    /**
     * Method to set the private var calculation to a RakePath.
     * @param rakePath 
     */
    public void determineRakePath(T rakePath){
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

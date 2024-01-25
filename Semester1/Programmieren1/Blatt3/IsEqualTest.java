/** 
 * Programm zum Aufgabenblatt 3
 * 
 * Aufgabe 3b - IsEqual
 * 
 * This is the test class. The IsEqual class could be find in IsEqual.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class IsEqualTest {
    public static void main(String[] args){
        //first test
        System.out.println("First test:");
        IsEqual isEqualElement = new IsEqual();
        int[] a = {1,2,3,4};
        int[] b = {3,-1,6,2};
        printArray(a);
        printArray(b);
        System.out.println("Arrays are equal: "+ isEqualElement.isEqual(a, b));

        //second test
        System.out.println("\nSecond test:");
        int[] c = {3,5,1,3};
        int[] d = {1,5,3,3};
        printArray(c);
        printArray(d);
        System.out.println("Arrays are equal: "+isEqualElement.isEqual(c, d));
    }

    /**
     * @method to print Array without Arrays.toString().
     * @name printArray
     * @param x array to print
     */
    public static void printArray(int[] x){
        for(int i=0;i<x.length-1;i++){
            System.out.print(x[i]+", ");
        }
        System.out.println(x[x.length-1]);
    }
}

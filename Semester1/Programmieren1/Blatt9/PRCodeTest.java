/**
 * Program for task sheet 9
 * 
 * Exercise 9b - PRCode
 * 
 * This is the test class. The PRCode class can be found in PRCode.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class PRCodeTest {
    public static void main(String[] args) {
        //first test with n=3
        System.out.println("First test with n=3:");
        PRCode prCode = new PRCode(3);
        int[][] pic = {{0,0,0},{0,1,0},{0,0,1}};
        prCode.setPic(pic);
        prCode.printPic();
        System.out.println("PRCode: " + prCode.getPRCode() +"\n");
        System.out.println("First test for maximal PRCode: ");
        prCode.maxPRCode();

        //second test with n=4
        System.out.println("\nSecond test with n=4:");
        PRCode prCode2 = new PRCode(4);
        int[][] pic2 = {{0,0,0,1},{0,1,0,0},{1,0,0,1},{1,1,0,0}};
        prCode2.setPic(pic2);
        prCode2.printPic();
        System.out.println("PRCode: " + prCode2.getPRCode() + "\n");
        System.out.println("Second test for maximal PRCode: ");
        prCode2.maxPRCode();
    }
}

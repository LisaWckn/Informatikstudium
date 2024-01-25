/** 
 * Programm zum Aufgabenblatt 3
 * 
 * Aufgabe 3a - MyArray
 * 
 * This is the test class. The MyArray class could be find in MyArray.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class MyArrayTest {
    public static void main(String[] args){
        //first test:
        System.out.println("First Test:");
        int[][] mat1 = {{1, 2, 3, 4},{ 4, -3, 2, 1},{ 5, -6, 7, 8},{ 8, -7, 6, 5}};
        System.out.println("2D Array:");
        printMatrix(mat1);

        MyArray arr3 = new MyArray(3);
        arr3.reduce(mat1);
        arr3.ausgabe();

        //second test:
        System.out.println("\nSecond Test:");
        int[][] mat2 = {{1, 6, 0, 4},{ 7, 3, 9, 1},{ 5, 16, 3, 8},{ 8, 2, 0, 5}};
        System.out.println("2D Array:");
        printMatrix(mat2);

        MyArray arr5 = new MyArray(5);
        arr5.reduce(mat2);
        arr5.ausgabe();
    }

    /**
     * @method Print the values of the matrix with a new line after each row.
     * @name printMatrix
     * @param mat matrix to print
     * 
     * This method isn't relevant for the exercise, but it is helpful to easily find out if the method reduce is working.
     * Also it gives us a nice output.
     */
    static void printMatrix(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}


/** 
 * Programm zum Aufgabenblatt 3
 * 
 * Aufgabe 3a - MyArray
 * 
 * This is the MyArray class. The test class could be find in MyArrayTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class MyArray {
    private int size = 1;
    private int[] arr = new int[size];
    private int[] intervalLengths = new int[size];

    /**
     * Constructor for an MyArray element. 
     * @param size The size should be greater than 0. If not, the array size will be 0, 
     *             so that the error message is displayed in the print method.
     */
    public MyArray(int size){
        if(size<=0){
            System.out.println("Error! The array size cannot be negative or zero.");
            arr = new int[0];
        }else{
            this.size = size;
            arr = new int[size];
            intervalLengths = new int[size];
        }
    }

    /**
     * @method Reduce the matrix to an array. The elements of the array result from the count of numbers in the appropriate interval.
     * @param mat The matrix to reduce. The count of rows should match the count of columns.
     */
    public void reduce(int[][] mat){
        /**
         * To avoid crashes first will be proved, if the matrix fulfill all requirements. 
         */
        if (mat == null || mat.length == 0) {
            System.out.println("Error!");
        }else{
            if(!matrixPositive(mat)){
                System.out.println("Error! All numbers in the matrix must be positive.");
                arr = new int[0];
            }else if(!matrixSquare(mat)){
                System.out.println("Error! The matrix must be square.");
                arr = new int[0];
            }else{
                setIntervalLengths(mat);
                int iMin = 0;
                for(int i=0;i<size;i++){
                    int iMax= iMin + intervalLengths[i];
                    for(int[] row : mat){
                        for(int element : row){
                            if (element>=iMin && element < iMax) {
                                arr[i]+=1;
                            }
                        }
                    }
                    iMin=iMax;
                }
            }
        }
    }

    /**
     * @method The general interval length is calculated from the value range of the matrix. 
     *         In addition, the number of intervals, which must be one larger, is calculated using modulo.
     *         Each interval of the array is then assigned a unique size.
     * @name setIntervalLengths
     * @param mat matrix for the value range
     */
    private void setIntervalLengths(int[][] mat){
        int matRangeLength = maxMatrix(mat) - (minMatrix(mat)-1);
        int intervalLength = matRangeLength/size;
        int countLongerIntervalls = matRangeLength % size;
        for(int i=0;i<size;i++){
            if (countLongerIntervalls>0) {
                intervalLengths[i]=intervalLength+1;
                countLongerIntervalls--;
            }else{
                intervalLengths[i]=intervalLength;

            }
        }
    }

    /**
     * @method Determine the maximum of all values of the matrix.
     * @name maxMatrix
     * @param mat matrix to get all values
     * @return the maximum
     */
    private int maxMatrix(int[][] mat){
        int max = 0;
        for(int[] row : mat){
            for(int element : row){
                if (element>max) {
                    max = element;
                }
            }
        }
        return max;
    }

    /**
     * @method Determine the minimum of all values of the matrix.
     * @name minMatrix
     * @param mat matrix to get all values
     * @return the minimum
     */
    private int minMatrix(int[][] mat){
        int min = mat[0][0];
        for(int[] row : mat){
            for(int element : row){
                if (element<min) {
                    min = element;
                }
            }
        }
        return min;
    }

    /**
     * @method Check if the matrix is square.
     * @param mat Matrix to check.
     * @return True if the matrix is square else return false.
     */
    private boolean matrixSquare(int[][] mat){
        boolean matrixSquare = true;

        for(int i=0;i<mat.length;i++){
            if (mat[i].length != mat.length) {
                matrixSquare = false;
            }
        }
        return matrixSquare;
    }

    /**
     * @method Check if all elements of the matrix are positive.
     * @param mat Matrix to check.
     * @return True if all elements are positive else return false.
     */
    private boolean matrixPositive(int[][] mat){
        boolean matrixPositive = true;

        for(int[] row : mat){
            for(int element : row){
                if (element<0) {
                    matrixPositive = false;
                }
            }
        }

        return matrixPositive;
    }

    /**
     * @method Print the size and the values of the array.
     * @name ausgabe
     */
    public void ausgabe(){
        if(arr == null || arr.length == 0){
            System.out.println("No array available to output.");
        }else{
            System.out.print("Number of entries = " + size + ": ");
            for(int i=0;i<size-1;i++){
                System.out.print(arr[i] + ", ");
            }
            System.out.println(arr[size-1]);
        }
    }
}

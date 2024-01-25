/**
 * Programm zum Aufgabenblatt 5
 * 
 * Aufgabe 5c - Zoom
 * 
 * This is the Zoom class. The test class could be find in ZoomTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Zoom {
    private int[][] pic;

    /**
     * Conctructor which sets the private pic to the transfered pic, if it is valid.
     * @param pic 
     */
    public Zoom(int[][] pic){
        if(picIsValid(pic)){
            this.pic=pic;
        }else{
            System.out.println("Error! Your pic isn't valid.");
        }
    }

    /**
     * Method to zoom into a pic with factor f. 
     * Each element will increased to a matrix with size fxf.
     * @param f zoomfactor as int
     * @return zoomed pic as a matrix with size (n*f)x(n*f)
     */
    public int[][] zoom(int f){
        int n = pic.length;
        int[][] zoomedPic = new int[n*f][n*f];

        int row = 0;
        for(int z=1;z<=n;z++){
            while (row < f*z) {
                zoomedPic[row] = setLine(z-1, f);
                row++;
            }
        }

        return zoomedPic;
    }

    /**
     * Method to set one row of the zoomed pic, with each element f times in the row.
     * @param row the index of the row of the original pic, where the elements come from
     * @param f the zoom factor
     * @return an array int[] with one row of the zoomed pic
     */
    public int[] setLine(int row, int f){
        int[] zoomedRow = new int[pic.length * f];

        int index = 0;
        for(int z = 1; z<=pic.length;z++){
            while(index<f*z){
                zoomedRow[index]=pic[row][z-1];
                index++;
            }
        }

        return zoomedRow;
    }

    /**
     * This method prints a transfered pic, not the private pic of the class.
     * @param pic to be printed as int[][]
     */
    public void print(int[][] pic){
        for(int[] row : pic){
            for(int element : row){
                System.out.print(element + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Method to check if the pic matrix is square 
     * and if all elements are in the interval [0,7].
     * @param pic to check if it's valid
     * @return true if the pic fulfills the conditions, else return false.
     */
    private boolean picIsValid(int[][] pic){
        boolean picIsValid = true;

        if(pic.length != pic[0].length){
            picIsValid = false;
        }else{
            for(int[] row : pic){
                for(int element : row){
                    if(element < 0 || element >7){
                        picIsValid = false;
                    }
                }
            }
        }

        return picIsValid;
    }
}

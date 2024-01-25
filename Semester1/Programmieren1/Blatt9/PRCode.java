/**
 * Program for task sheet 9
 * 
 * Exercise 9b - PRCode
 * 
 * This is the PRCode class. The test class can be found in PRCode.java.
 * 
 * @author Lisa Weickenmeier
 */

public class PRCode {
    private int[][] pic;
    private int n;

    /**
     * Constructor which only constructs a class element if n is greater than zero.
     * @param n Size of the squared pic
     */
    public PRCode(int n){
        if(n>0){
            this.n = n;
        }else{
            throw new IllegalArgumentException("The matrix size must be greater than zero.");
        }
    }

    /**
     * Method to set a pic if it's valid.
     * @param pic pic as 2D Array with only 0 and 1 as elements
     */
    public void setPic(int[][] pic){
        if(pic!=null & pic.length!= 0 & picIsValid(pic)){
            this.pic = pic;
        }else{
            System.err.println("This pic isn't valid.");
        }
    }

    /**
     * Method to print the pic.
     */
    public void printPic(){
        if(this.pic != null && this.pic.length != 0){
            for(int[] row : pic){
                for(int element : row){
                    System.out.print(element + " ");
                }
                System.out.println("");
            }
        }
    }

    /**
     * Method to determine the PRCode of the current pic and returns it as an int.
     * @return PRCode as int. If -1 is returned, the pic doesn't exists.
     */
    public int getPRCode(){
        try{
            int prCode = 0;
            for(int i=0;i<pic.length;i++){
                for(int j=0;j<pic.length;j++){
                    int k=(n*n-1)-n*i-j;
                    prCode+=twoPowerK(k)*pic[i][j];
                }
            }
            return prCode;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return -1;
        }
    }

    /**
     * Method to determine and print the maximal PRCode of the pic and it's rotations.
     */
    public void maxPRCode(){
        try{
            int[][] originalPic = pic;
            System.out.println("Original pic: ");
            printPic();
            int maxPRCode = getPRCode();
            System.out.println("Original PRCode: " + maxPRCode);
            int[][] rotatedPic = pic;
            int rotations = 0;

            for(int i=1;i<4;i++){
                rotatePic();
                if(getPRCode() >= maxPRCode){
                    maxPRCode = getPRCode();
                    rotatedPic = pic;
                    rotations = i;
                }
            }

            pic = rotatedPic;
            System.out.println("Pic with max PRCode:");
            printPic();
            System.out.println("Max PRCode: " + maxPRCode);
            System.out.println("Necessary Rotations: "+ rotations);

            pic = originalPic;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }

    /**
     * Method to calculate two to the power of k.
     * @param k the exponent
     * @return the potency
     */
    private int twoPowerK(int k){
        int twoPowerK = 1;
        for(int i=0;i<k;i++){
            twoPowerK *= 2;
        }
        return twoPowerK;
    }

    /**
     * Method to check, if the pic only contains 0 and 1 and if it's squared and matching the size n.
     * @param pic
     * @return
     */
    private boolean picIsValid(int[][] pic){
        boolean picIsValid = true;
        if (pic.length != n) {
            picIsValid = false;
        }
        for(int[] row : pic){
            if(row.length != n){
                picIsValid = false;
            }
            for(int element : row){
                if(!(element == 0 | element == 1)){
                    picIsValid = false;
                }
            }
        }
        return picIsValid;
    }

    /**
     * Method to rotate the pic by 90 degrees.
     */
    private void rotatePic(){
        int[][] rotatedPic = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                rotatedPic[i][n-j-1] = pic[j][i];
            }
        }

        this.pic = rotatedPic;
    }
}

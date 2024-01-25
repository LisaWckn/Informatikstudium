/**
 * Programm zum Aufgabenblatt 7
 * 
 * Aufgabe 7b - Frame
 * 
 * This is the Frame class. The test class could be find in FrameTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Frame {
    /**
     * This method prints the string array line by line in a frame.
     * @param strArr the array to print in the frame
     */
    public void printFrame(String[] strArr){
        if(strArr != null && strArr.length != 0){
            //Because of the stars and empty spaces before and after every string, the frame have to be 4 times longer than the longest string.
            int frameWidth = getMaxLenght(strArr) + 4;
            
            printStarRow(frameWidth);
            for(int i=0;i<strArr.length;i++){
                System.out.print("* " + strArr[i]);
                int emptySpaces = getMaxLenght(strArr)-strArr[i].length();
                for(int j=0;j<emptySpaces+1;j++){
                    System.out.print(" ");
                }
                System.out.println("*");
            }
            printStarRow(frameWidth);
        }
    }

    /**
     * Method for print a line only with stars in the matching width.
     * @param frameWidth
     */
    private void printStarRow(int frameWidth){
        for(int i=0;i<frameWidth;i++){
            System.out.print("*");
        }
        System.out.println("");
    }

    /**
     * This method iterates through the string array and stores the max lenght of the strings.
     * @param strArr
     * @return the lenght of the longest string in the array
     */
    private int getMaxLenght(String[] strArr){
        if(strArr != null && strArr.length != 0){
            int maxLenght = strArr[0].length();
            for(int i=1;i<strArr.length;i++){
                if (strArr[i].length()>maxLenght) {
                    maxLenght = strArr[i].length();
                }
            }
            return maxLenght;
        }else{
            return -1;
        }
    }
}

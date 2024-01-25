/** 
 * Programm zum Aufgabenblatt 2
 * 
 * Aufgabe 2a - zeichneBerge(int w1, int w2, int w3)
 * 
 * @author Lisa Weickenmeier
 */

 public class ZeichneBerge {
    public static void main(String[] args){
        //first test:
        System.out.println("Test 1: w1=5, w2=3, w3=7");
        zeichneBerge(5, 3, 7);

        //second test:
        System.out.println("\nTest 2: w1=3, w2=5, w3=9");
        zeichneBerge(3, 5, 9);
    }

    /**
     * @method The method prints all lines of the mountains.
     * @name zeichneBerge
     * @param w1 This param is the count of stars in the last line of the first mountain. It has to be odd.
     * @param w2 This param is the count of rhombs in the last line of the second mountain. It has to be odd.
     * @param w3 This param is the count of circles in the last line of the third mountain. It has to be odd.
     */
    public static void zeichneBerge(int w1, int w2, int w3){
        if(!isValidInt(w1) || !isValidInt(w2) || !isValidInt(w3)){
            System.out.println("Error! Die Parameter müssen ungerade sein!");
        }else{

            int rowsMax = maximumRowsOf(w1, w2, w3);

            //To avoid the repetation of the same lines, the print loops are relocated.
            for(int i = rowsMax; i>=0; i--){
                //First Mountain
                int stars = w1 - 2*i;
                printMountainLine(w1, stars, (char)42);

                System.out.print(" ");

                //Second Mountain
                int rhombs = w2 - 2*i;
                printMountainLine(w2, rhombs, (char)35);

                System.out.print(" ");

                //Third Mountain
                int circles = w3 - 2*i;
                printMountainLine(w3, circles, (char)111 );

                System.out.print("\n");
            }
        }
    }

    /**
     * @method Test if integer fulfills the given criterias.
     * @param i Integer to test.
     * @return Boolean: true if integer is valid and false if it isn't valid.
     */
    public static boolean isValidInt(int i){
        boolean isValid = true;

        if(i%2==0 || i<0 || i>21){
            isValid = false;
        }

        return isValid;
    }

    /**
     * @method This mehtod prints only one line of one mountain depent on the width and the symbols.
     * @name printMountainLine
     * @param maxChars The width of the mountain. Equals the count of symbols in the last line.
     * @param filledChars The count of symbols in the current line.
     * @param symbol The symbol to print the mountain.
     */
    public static void printMountainLine(int maxChars, int filledChars, char symbol){
       if(filledChars <= 0){
            for(int i=0; i<maxChars;i++){
                System.out.print(" ");
            }
        }else{
            int blanks = (maxChars - filledChars)/2;
            for(int i=0; i<blanks; i++){
                System.out.print(" ");
            }
            for(int i=0; i<filledChars; i++){
                System.out.print(symbol);
            }
            for(int i=0; i<blanks; i++){
                System.out.print(" ");
            }
        }
    }

    /**
     * @method This method determine the mountain with the longest bottom line and calculate the rows of this mountain.
     * @name maximumRowsOf
     * @param w1,w2,w3 The count of the symbols in the last lines of the trees like in the zeichneBerge method.
     * @return The maxRows of the heighest mountain.
     */
    public static int maximumRowsOf(int w1, int w2, int w3){
        int max = w1;

        if(w2>w1 && w2>w3){
            max = w2;
        }else if(w3>w1 && w3>w2){
            max = w3;
        }

        return (max/2 + 1);
    }
}

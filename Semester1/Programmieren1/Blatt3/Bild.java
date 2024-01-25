/** 
 * Programm zum Aufgabenblatt 3
 * 
 * Aufgabe 3c - Bild
 * 
 * This is the Bild class. The test class could be find in BildTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Bild {
    private int[][] pic;

    /**
     * Constructor for a Bild element.
     * @param pic 2D Array with 0 and 1 as elements.
     */
    public Bild(int [][] pic){
        if(picIsValid(pic)){
            this.pic = pic;
        }else{
            System.out.println("Error! Die Matrix darf nur die Werte 0 und 1 enthalten!");
            pic = new int[0][0];
        }
    }

    /**
     * @method Flip and invert the private pic.
     * @name flipAndInvert
     */
    public void flipAndInvert(){
        if(pic == null || pic.length == 0){
            System.out.println("Kein Bild vorhanden.");
        }else{
            pic = flipPic(pic);
            pic = invert(pic);
        }
    }

    /**
     * @method print the private pic as matrix.
     * @name ausgabe
     */
    public void ausgabe(){
        if(pic == null || pic.length == 0){
            System.out.println("Kein Bild vorhanden.");
        }else{
            for(int i=0;i<pic.length;i++){
                for(int j=0;j<pic[i].length;j++){
                    System.out.print(pic[i][j] + " ");
                }
                System.out.print("\n");
            }
        }
    }

    /**
     * @method Flip the picture over so that the last row becomes the first and vice versa.
     * @name flipPic
     * @param pic The pic to flip.
     * @return the flipped pic
     */
    private int[][] flipPic(int[][] pic){
        int[][] flippedPic = new int[pic.length][pic[0].length];

        for(int i=0;i<pic.length;i++){
            for(int j=0;j<pic[0].length;j++){
                flippedPic[i][j] = pic[pic.length-1-i][j];
            }
        }

        return flippedPic;
    }

    /**
     * @method Invert the pic so that every 0 becomes 1 and every 1 becomes 0.
     * @name invert
     * @param pic The pic to invert.
     * @return the inverted pic
     */
    private int[][] invert(int[][] pic){
        for(int i=0;i<pic.length;i++){
            for(int j=0;j<pic[i].length;j++){
                if(pic[i][j]==0){
                    pic[i][j] = 1;
                }else{
                    pic[i][j] = 0;
                }
            }
        }
        return pic;
    }

    /**
     * @method Check if the pic only contains 0 and 1.
     * @param pic
     * @return false, if there are other numbers than 0 and 1 in the pic.
     */
    private boolean picIsValid(int[][] pic){
        boolean picIsValid = true;

        for(int[] row : pic){
            for(int element : row){
                if (element!= 0 && element != 1) {
                    picIsValid = false;
                }
            }
        }

        return picIsValid;
    }
}

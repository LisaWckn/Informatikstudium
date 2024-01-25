/**
 * Programm zum Aufgabenblatt 5
 * 
 * Aufgabe 5a - Memory
 * 
 * This is the Memory class. The test class could be find in MemoryTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Memory {
    /**
     * This method generates a matrix with n rows and n columns. 
     * An integer greater than or equal to 3 is written into each field. 
     * Every number appears twice. 
     * The positions of the numbers are randomly determined.
     * @param n size of the sqared matrix as int
     * @return the memory field
     */
    public int[][] generateField(int n){
        if(n%2 == 0){
            int[][] memoryField = new int[n][n];

            for(int i=0;i<n*n/2;i++){
                setRandomEmptyField(memoryField, i+3);
                setRandomEmptyField(memoryField, i+3);
            }

            return memoryField;
        }else{
            System.out.println("Error! The size need to be even.");
            return null;
        }
        
    }

    /**
     * This method prints the memory field.
     * @param memoryField
     */
    public void printField(int[][] memoryField){
        for(int[] row : memoryField){
            for(int element : row){
                if(element<10){
                    System.out.print(element + "   ");
                }else{
                    System.out.print(element + "  ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * This method determines two random numbers 
     * that represent the row and column position of the field to set.
     * If the field isn't empty (!=0), the method determines a new position.
     * Otherwise the field becomes the item.
     * @param memoryField the current memory field
     * @param item the integer which should be set in one field
     * @return the new memory field with the item at one position
     */
    private int[][] setRandomEmptyField(int[][] memoryField, int item){
        int n = memoryField.length;
        int i = randomNumber(n);
        int j = randomNumber(n);

        while (memoryField[i][j] != 0) {
            i = randomNumber(n);
            j = randomNumber(n);
        }

        memoryField[i][j] = item;

        return memoryField;
    }

    /**
     * This method determines a random index for a row or column of the memory field.
     * @param n the size of the memory field
     * @return the random index
     */
    private int randomNumber(int n){
        int random = (int)(Math.random() * n);
        return random;
    }
}

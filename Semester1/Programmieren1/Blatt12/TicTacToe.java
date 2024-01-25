/**
 * Program for task sheet 12
 * 
 * Exercise 12b - TicTacToe
 * 
 * This is the TicTacToe class. The test class can be found in TicTacToeTest.java.
 * 
 * @author Lisa Weickenmeier
 */

public class TicTacToe {
    private int[] field = new int[9];
    private boolean characterX = true;

    /**
     * Method to reset the game.
     */
    public void reset(){
        field = new int[9];
        characterX = true;
    }

    /**
     * Method to make a move. The player (X/O) is detemined automatically.
     * @param x the column for the sign
     * @param y the row for the sign
     */
    public void makeAMove(int x, int y){
        if(characterX){
            field[y*3+x]=1;
            characterX = false;
        }else{
            field[y*3+x]=2;
            characterX = true;
        }
    }

    /**
     * Method to print the current game field.
     */
    public void showGamefield(){
        System.out.println(getCharacter(field[0]) + "|" + getCharacter(field[1]) + "|" + getCharacter(field[2]));
        System.out.println("-+-+-");
        System.out.println(getCharacter(field[3]) + "|" + getCharacter(field[4]) + "|" + getCharacter(field[5]));
        System.out.println("-+-+-");
        System.out.println(getCharacter(field[6]) + "|" + getCharacter(field[7]) + "|" + getCharacter(field[8]));
    }

    /**
     * Method to return the character for the field.
     * @param status the status of the field (0,1,2)
     * @return the character depending on the status (0 - " ", 1 - "X", 2 - "O")
     */
    private String getCharacter(int status){
        switch (status) {
            case 0: return " ";
            case 1: return "X";
            case 2: return "O";
            default: return " ";
        }
    }
}

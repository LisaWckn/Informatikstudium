/**
 * Program for task sheet 12
 * 
 * Exercise 12b - TicTacToe
 * 
 * This is the test class. The TicTacToe class can be found in TicTacToe.java.
 * 
 * @author Lisa Weickenmeier
 */

public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.showGamefield();

        System.out.println("\nFirst move: ");
        ttt.makeAMove(2, 2);
        ttt.showGamefield();

        System.out.println("\nSecond move: ");
        ttt.makeAMove(2, 0);
        ttt.showGamefield();

        System.out.println("\nThird move: ");
        ttt.makeAMove(0, 1);
        ttt.showGamefield();
    }
}

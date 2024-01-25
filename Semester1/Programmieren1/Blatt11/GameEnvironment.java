/**
 * Program for task sheet 11
 * 
 * Exercise 11c - Game
 * 
 * This is the test class.
 * Further classes/interfaces for this exercise can be found in the files Game.java, Player.java and NewsChannel.java.
 * 
 * @author Lisa Weickenmeier
 */

public class GameEnvironment {
    public static void main(String[] args) {
        Game newGame = new Game();
        Player alfred = new Player("Alfred");
        Player berta = new Player("Berta");
        Player caspar = new Player("Caspar");
        newGame.addPlayer(alfred);
        newGame.addPlayer(berta);
        newGame.addPlayer(caspar);
        newGame.newMessage("Welcome to the game!");
        alfred.printMessage();
    }
}

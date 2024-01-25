/**
 * Program for task sheet 11
 * 
 * Exercise 11c - Game
 * 
 * This is the Player class which implements the NewsChannel interface.
 * Further classes/interfaces for this exercise can be found in the files Game.java, NewsChannel.java and GameEnvironment.
 * 
 * @author Lisa Weickenmeier
 */

public class Player implements NewsChannel{
    private String _name;
    private String _message;

    /**
     * Constructor for the player.
     * @param name of the player
     */
    public Player(String name){
        this._name = name;
    }

    /**
     * Method to print the name and the current message of the player.
     */
    public void printPlayerData(){
        System.out.println("Name: " + _name +"\nMessage: " + _message);
    }

    @Override
    public void notifiy(String message){
        this._message = message;
    }

    @Override
    public void printMessage(){
        System.out.println(_message);
    }

}

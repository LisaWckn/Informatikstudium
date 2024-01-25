/**
 * Program for task sheet 11
 * 
 * Exercise 11c - Game
 * 
 * This is the NewsChannel interface.
 * Further classes for this exercise can be found in the files Game.java, Player.java and GameEnvironment.java.
 * 
 * @author Lisa Weickenmeier
 */

public interface NewsChannel {
    /**
     * Method to set a new message.
     * @param message the new message.
     */
    public void notifiy(String message);

    /**
     * Method to print the current message.
     */
    public void printMessage();
}

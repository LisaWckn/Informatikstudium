/**
 * Program for task sheet 11
 * 
 * Exercise 11c - Game
 * 
 * This is the Game class.
 * Further classes/interfaces for this exercise can be found in the files Player.java, NewsChannel.java and GameEnvironment.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> _players = new ArrayList<Player>();
    private String _message;

    /**
     * Method to add a player to the game.
     * @param player The player to add.
     */
    public void addPlayer(Player player){
        _players.add(player);
    }

    /**
     * Method to remove a player from the game.
     * @param player The player to remove.
     */
    public void removePlayer(Player player){
        if(_players != null && _players.size() != 0)
        {
            _players.remove(player);
        }
    }

    /**
     * Method to set a new message and notify each player.
     * @param message the new message.
     */
    public void newMessage(String message){
        this._message = message;
        for(Player p: _players){
            p.notifiy(this._message);
        }
    }
}

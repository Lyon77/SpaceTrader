package com.example.rjl77.spacetrader.game;

import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.entities.Universe;

public class Game {
    private GameDifficulty level;
    private Player p;
    private Universe universe;

    /**
     *No-args constructor for Game
     */
    public Game() {
        this(GameDifficulty.EASY, new Player());
    }

    /**
     *Constructor for Game
     * @param _level enum for game difficulty
     * @param p player
     */
    public Game(GameDifficulty _level, Player p) {
        level = _level;
        this.p = p;

        universe = new Universe();
    }

    /**
     *Getter for level
     *@return level attribute value
     */
    public GameDifficulty getLevel() {
        return this.level;
    }

    /**
     *Setter for level
     *@param level the game should be set to
     */
    public void setLevel(GameDifficulty level) {
        this.level = level;
    }

    /**
     *Getter for player
     *@return player attribute value
     */
    public Player getPlayer() {
        return this.p;
    }

    /**
     *Method to get player information
     *@return string representation of player attributes
     */
    public String getPlayerInfo() {
        return this.p.toString();
    }

    /**
     *Setter for player
     *@param p player
     */
    public void setPlayer(Player p) {
        this.p = p;
    }


}

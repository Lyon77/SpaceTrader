package com.example.rjl77.spacetrader.game;

import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Market;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.entities.Ship;
import com.example.rjl77.spacetrader.entities.SolarSystem;
import com.example.rjl77.spacetrader.entities.Universe;
import android.util.Log;

import java.util.HashMap;

public class Game {
    private GameDifficulty level;
    private Player p;
    private Universe universe;

    //making the class a singleton
    private static Game instance = new Game();

    public static Game getInstance() { return instance; }

    /**
     *No-args constructor for Game
     */
    private Game() {
        this(GameDifficulty.EASY, new Player());
    }

    /**
     *Constructor for Game
     * @param _level enum for game difficulty
     * @param p player
     */
    private Game(GameDifficulty _level, Player p) {
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

    public Ship getPlayerShip() {
        return p.getShip();
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

    public HashMap<String, Integer> getCurrentSystemMarket() {
        return universe.getCurrentSystemMarket();
    }

    public String currentPlanetName() {
        return universe.getCurrentSystem().getName();
    }


}

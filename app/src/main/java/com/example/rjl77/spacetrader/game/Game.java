package com.example.rjl77.spacetrader.game;

import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Market;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.entities.Ship;
import com.example.rjl77.spacetrader.entities.SolarSystem;
import com.example.rjl77.spacetrader.entities.Universe;
import com.google.gson.Gson;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
     *Method to get universe
     *@return universe
     */
    public Universe getUniverse() {
        return this.universe;
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

    public boolean loadJson(File file) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            //Since we saved the json as a string, we just read in the string normally
            String inString = input.readLine();
            Log.d("DEBUG", "JSON: " + inString);
            //Then we use the Gson library to recreate the object references and links automagically
            Gson gson = new Gson();

            instance = gson.fromJson(inString, Game.class);

            input.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Failed to open/read the buffered reader for json");
        }

    }

    public boolean saveJson(File file ) {

        try {
            PrintWriter writer = new PrintWriter(file);
            /*
                We are using the Google Gson library to make things easy.  You will need to add the
                following line to your gradle file so the proper dependencies are set up:
                compile 'com.google.code.gson:gson:2.3'

                Gson, like object serialization will take a single object and save all the objects
                it refers to.  You can save everything by one reference, as long as it is the
                top-level reference.


             */
            Gson gson = new Gson();
            // convert our objects to a string for output
            String outString = gson.toJson(instance);
            Log.d("DEBUG", "JSON Saved: " + outString);
            //then just write the string
            writer.println(outString);
            writer.close();
        } catch (FileNotFoundException e) {
            Log.e("UserManagementFacade", "Failed to open json file for output");
        }
    }

}

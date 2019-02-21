package com.example.rjl77.spacetrader.game;

import android.util.Log;

import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.entities.SolarSystem;

import java.util.HashSet;
import java.util.Random;

public class Game {
    private GameDifficulty level;
    private Player p;
    private HashSet<SolarSystem> universe;

    public Game() {
        this(GameDifficulty.EASY, new Player());
    }

    public Game(GameDifficulty _level, Player p) {
        level = _level;
        this.p = p;

        universe = new HashSet<>();
        Random cood = new Random();
        while (universe.size() < 10) {
            int x = cood.nextInt(20);
            int y = cood.nextInt(15);

            Log.i("Planet", "Creating SolarSystem at " + x + " " + y);
            SolarSystem newSystem = new SolarSystem(x, y);
            Log.i("Planet", newSystem.toString());
            universe.add(newSystem);
        }
    }

    public GameDifficulty getLevel() {
        return this.level;
    }

    public void setLevel(GameDifficulty level) {
        this.level = level;
    }

    public Player getPlayer() {
        return this.p;
    }

    public String getPlayerInfo() {
        return this.p.toString();
    }

    public void setPlayer(Player p) {
        this.p = p;
    }


}

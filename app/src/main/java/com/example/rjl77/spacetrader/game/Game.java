package com.example.rjl77.spacetrader.game;

import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.entities.Universe;

public class Game {
    private GameDifficulty level;
    private Player p;
    private Universe universe;

    public Game() {
        this(GameDifficulty.EASY, new Player());
    }

    public Game(GameDifficulty _level, Player p) {
        level = _level;
        this.p = p;

        universe = new Universe();
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

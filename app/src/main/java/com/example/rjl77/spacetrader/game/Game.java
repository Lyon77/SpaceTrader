package com.example.rjl77.spacetrader.game;

import com.example.rjl77.spacetrader.entities.Player;

public class Game {
    private String level;
    private Player p;

    public Game() {
        this("easy", new Player());
    }

    public Game(String level, Player p) {
        this.level = level;
        this.p = p;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Player getPlayer() {
        return this.p;
    }

    public void setPlayer(Player p) {
        this.p = p;
    }
}

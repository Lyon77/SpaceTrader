package com.example.rjl77.spacetrader.entities;
import java.io.Serializable;

public enum GameDifficulty implements Serializable{
    EASY ("EASY"),
    NORMAL("NORMAL"),
    DIFFICULT("DIFFICULT"),
    IMPOSSIBLE("IMPOSSIBLE");

    private String difficulty;

    GameDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLevel() {
        return difficulty;
    }

    public String toString() {
        return difficulty;
    }
}

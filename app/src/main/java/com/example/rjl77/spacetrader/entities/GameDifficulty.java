package com.example.rjl77.spacetrader.entities;
import java.io.Serializable;

public enum GameDifficulty implements Serializable{
    BEGINNER("BEGINNER"),
    EASY("EASY"),
    NORMAL("NORMAL"),
    HARD("HARD"),
    IMPOSSIBLE("IMPOSSIBLE");

    private String difficulty;

    GameDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLevel() {
        return difficulty;
    }

    @Override
    public String toString() {
        return difficulty;
    }
}

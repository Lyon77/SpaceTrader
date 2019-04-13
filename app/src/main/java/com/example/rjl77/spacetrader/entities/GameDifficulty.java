
package com.example.rjl77.spacetrader.entities;

//import java.io.Serializable;

/**
 * Represents an enum for game difficulty
 * @author Team 71
 * @version 1.0
 */
public enum GameDifficulty{
    BEGINNER("BEGINNER"),
    EASY("EASY"),
    NORMAL("NORMAL"),
    HARD("HARD"),
    IMPOSSIBLE("IMPOSSIBLE");

    private final String difficulty;

    /**
     * Constructor for game difficulty
     * @param difficulty string version of the difficulty level
     */
    GameDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

//    public String getLevel() {
//        return difficulty;
//    }

    @Override
    public String toString() {
        return difficulty;
    }
}

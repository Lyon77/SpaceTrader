package com.example.rjl77.spacetrader.entities;

public class Player {
    private String name;
    private int credits;
    private String ship;

    public Player() {
        this("Ryan");
    }

    public Player(String name) {
        this.name = name;
        this.credits = 1000;
        this.ship = "Gnat";
    }

    public String getName() {
        return this.name;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getShip() {
        return this.ship;
    }
}

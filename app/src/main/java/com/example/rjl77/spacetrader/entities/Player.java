package com.example.rjl77.spacetrader.entities;

public class Player {
    private String name;
    private int credits;
    private Ship ship;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;

    public Player() {
        this("Ryan");
    }

    public Player(String name) {
        this.name = name;
        this.credits = 1000;
        this.ship = new Ship();
    }

    public String getName() {
        return this.name;
    }

    public int getCredits() {
        return this.credits;
    }

    public Ship getShip() {
        return this.ship;
    }

//    @androidx.annotation.NonNull
    @Override
    public String toString() {
        return "Name: " + this.name + " " + "Credits: " + credits + " " + "Ship: " + ship.toString();
    }
}

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
        this("Ryan", 4, 4, 4, 4);
    }

    public Player(String name, int pil, int fight, int trade, int eng) {
        this.name = name;
        this.pilot = pil;
        this.fighter = fight;
        this.trader = trade;
        this.engineer = eng;
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
        return "Name: " + this.name + "\n" + "Credits: " + credits + "\n" + "Ship: " + ship.toString()
                + "\n" + "Pilot Skill: " + pilot + "\n" + "Fighter Skill: " + fighter + "\n" + "Trader Skill: "
                + trader + "\n" + "Engineer Skill: " + engineer + "\n";
    }
}

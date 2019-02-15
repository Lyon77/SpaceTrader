package com.example.rjl77.spacetrader.entities;

public class Ship {
    private String name;

    public Ship() {
        this("Gnat");
    }

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

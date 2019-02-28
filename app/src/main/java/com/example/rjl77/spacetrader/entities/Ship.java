package com.example.rjl77.spacetrader.entities;

import java.util.HashMap;

public class Ship {
    private String name;
    private int maxCargo;
    private HashMap<String, int> cargo;

    public Ship() {
        this("Gnat");
    }

    public Ship(String name) {
        this.name = name;
        this.maxCargo = 15;
        cargo = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public int getMaxCargo() {return this.maxCargo;}

    public boolean hasCargo(String c) {return cargo.containsKey(c);}

    public int cargoAmount(String c) {return cargo.getOrDefault(c, 0);}

    public boolean sellCargo(String c, int amount) {
        //if there isn't enough cargo, return a fail
        if (!cargo.containsKey(c) || cargo.get(c) < amount) {
            return false;
        }
        cargo.put(c, cargo.get(c) - amount);
        return true;
    }

    public void addCargo(String c, int amount) {
        cargo.put(c, cargo.getOrDefault(c, 0) + amount);
    }

//    @androidx.annotation.NonNull
    @Override
    public String toString() {
        return this.name;
    }
}

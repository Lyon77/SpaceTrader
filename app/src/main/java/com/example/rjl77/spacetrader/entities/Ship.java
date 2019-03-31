package com.example.rjl77.spacetrader.entities;

import java.util.HashMap;

public class Ship {
    private String name;
    private int maxCargo;
    private HashMap<String, Integer> cargo;
    private int fuel;
    private int totalCargo;

    public Ship() {
        this("Gnat");
    }

    public Ship(String name) {
        this.name = name;
        this.maxCargo = 15;
        this.cargo = new HashMap<>();
        this.fuel = 14;
        this.totalCargo = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxCargo() {return this.maxCargo;}

    public boolean hasCargo(String c) {return cargo.containsKey(c);}

    public int cargoAmount(String c) {
        System.out.println("Has " + c + " " + cargo.containsKey(c));
        if (cargo.containsKey(c)) {
            return cargo.get(c);
        } else {
            return 0;
        }
    }

    public boolean hasRoomToBuy(int amount) {
        return maxCargo >= totalCargo + amount;
    }

    public void sellCargo(String c, int amount) {
        cargo.put(c, cargo.get(c) - amount);
        totalCargo -= amount;
    }

    public void addCargo(String c, int amount) {
        if (cargo.containsKey(c)) {
            cargo.put(c, cargo.get(c) + amount);
            System.out.println("Cargo " + cargo.get(c));
        } else {
            cargo.put(c, amount);
            System.out.println("Added " + cargo.get(c));
        }
        totalCargo += amount;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    //    @androidx.annotation.NonNull
    @Override
    public String toString() {
        return this.name;
    }
}

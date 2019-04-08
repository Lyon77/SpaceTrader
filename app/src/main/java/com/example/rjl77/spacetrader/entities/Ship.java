package com.example.rjl77.spacetrader.entities;

import android.util.Log;

import java.util.HashMap;


/**
 * Represents a ship
 * @author Team 71
 * @version 1.0
 */
public class Ship {
    private String name;
    private int maxCargo;
    private HashMap<String, Integer> cargo;
    private int fuel;
    private int totalCargo;

    /**
     * No args constructor for Ship class
     */
    public Ship() {
        this("Gnat");
    }

    /**
     * Constructor for Ship class
     * @param name ship's name
     */
    private Ship(String name) {
        this.name = name;
        this.maxCargo = 15;
        this.cargo = new HashMap<>();
        this.fuel = 14;
        this.totalCargo = 0;
    }

    /**
     * Getter for ship name
     * @return name attribute
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for max cargo of ship
     * @return maxCargo attribute
     */
    public int getMaxCargo() {return this.maxCargo;}

    /**
     * Checks if the ship currently contains a given type of cargo
     * @param c name of the type of cargo
     * @return whether the ship contains that type of cargo
     */
    public boolean hasCargo(String c) {return cargo.containsKey(c);}

    public HashMap<String, Integer> getCargo() {return this.cargo;}

    /**
     * Checks how much of a given cargo the ship contains
     * @param c name of the type of cargo
     * @return amount of that type of cargo in the ship
     */
    public int cargoAmount(String c) {
        Log.i("Ship", "Has " + c + " " + cargo.containsKey(c));
        if (cargo.containsKey(c)) {
            return cargo.get(c);
        } else {
            return 0;
        }
    }

    /**
     * Determines whether the ship has space to buy a given amount of cargo
     * @param amount amount of cargo
     * @return whether the ship has space for that amount of cargo
     */
    public boolean hasRoomToBuy(int amount) {
        return maxCargo >= totalCargo + amount;
    }

    /**
     * Removes cargo from the ship
     * @param c type of cargo to remove
     * @param amount amount of cargo to remove
     */
    public void sellCargo(String c, int amount) {
        cargo.put(c, cargo.get(c) - amount);
        totalCargo -= amount;
    }

    /**
     * Adds cargo to the ship
     * @param c type of cargo to add
     * @param amount amount of cargo to add
     */
    public void addCargo(String c, int amount) {
        if (cargo.containsKey(c)) {
            cargo.put(c, cargo.get(c) + amount);
            Log.i("Ship", "Cargo " + cargo.get(c));
        } else {
            cargo.put(c, amount);
            Log.i("Ship", "Added " + cargo.get(c));
        }
        totalCargo += amount;
    }

    /**
     * Getter for amount of fuel in ship
     * @return amount of fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * Setter for amount of fuel in ship
     * @param fuel amount of fuel the ship should now have
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    //    @androidx.annotation.NonNull
    @Override
    public String toString() {
        return this.name;
    }
}

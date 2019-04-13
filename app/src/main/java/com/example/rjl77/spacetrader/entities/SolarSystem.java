package com.example.rjl77.spacetrader.entities;

import java.util.HashMap;
import java.util.Random;

/**
 * Represents a solar system/planet
 * @author Team 71
 * @version 1.0
 */
public class SolarSystem {
    private final int x;
    private final int y;
    private final String name;
    private final int techLevel;
    private final int resource;
    private final Market market;


    /**
    *Constructor for SolarSystem
    * @param x coordinate
    * @param y coordinate
    * @param name of SolarSystem
    */
    public SolarSystem(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
        Random r = new Random();
        techLevel = r.nextInt(7);

        //sets up resources so that nospecialresources is the most common result
        //as listed in the game description
        int hasResources = r.nextInt(1);
        if (hasResources == 1) {
            resource = r.nextInt(12);
        } else {
            resource = 0;
        }

        market = new Market(techLevel, resource);
    }

    /**
    *Getter for x
    *@return x attribute value
    */
    private int getX() {
        return x;
    }

    /**
    *Getter for y
    *@return y attribute value
    */
    private int getY() {
        return y;
    }

    /**
    *Getter for name
    *@return name attribute value
    */
    public String getName() {
        return name;
    }

//    /**
//    *Getter for techLevel
//    *@return techLevel attribute value
//    */
//    public int getTechLevel() {
//        return techLevel;
//    }

    /**
    *Getter for resource
    *@return resource attribute value
    */
//    public int getResource() {
//        return resource;
//    }

    /**
     * Getter for market items
     * @return hashmap of items and prices
     */
    public HashMap<String, Integer> getMarket() {
        return market.getPrices();
    }

    //@androidx.annotation.NonNull
    @Override
    public String toString() {
        return "Planet named " + this.name + " exists at x: " + this.x + " y: " + this.y
                + ". Its tech level is " + this.techLevel + " and its resource level is "
                + this.resource + ".";
    }

    @Override
    public int hashCode() {
        int val = 17;
        val = val*7 + x*5;
        val = val*7 + y*5;
        return val;
    }

    //@androidx.annotation.Nullable
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (!(obj instanceof SolarSystem)) {return false;}
        SolarSystem copy = (SolarSystem) obj;
        return this.x == copy.getX() && this.y == copy.getY();
    }

    /**
     * Checks if the solar system's name equals an input string
     * @param s name to check
     * @return whether the names are the same
     */
    public boolean equalName(String s) {
        return this.name.equals(s);
    }
}

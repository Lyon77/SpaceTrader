package com.example.rjl77.spacetrader.entities;

import java.util.Random;

public class SolarSystem {
    private int x;
    private int y;
    private String name;
    private int techLevel;
    private int resource;


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
    }

    /**
    *Getter for x
    *@return x attribute value
    */
    public int getX() {
        return x;
    }

    /**
    *Getter for y
    *@return y attribute value
    */
    public int getY() {
        return y;
    }

    /**
    *Getter for name
    *@return name attribute value
    */
    public String getName() {
        return name;
    }

    /**
    *Getter for techLevel
    *@return techLevel attribute value
    */
    public int getTechLevel() {
        return techLevel;
    }

    /**
    *Getter for resource
    *@return resource attribute value
    */
    public int getResource() {
        return resource;
    }

    //@androidx.annotation.NonNull
    @Override
    public String toString() {
        return "Planet named " + this.name + " exists at x: " + this.x + " y: " + this.y
                + ". Its tech level is " + this.techLevel + " and its resource level is " + this.resource + ".";
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
}

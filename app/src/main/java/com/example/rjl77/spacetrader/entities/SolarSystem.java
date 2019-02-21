package com.example.rjl77.spacetrader.entities;

public class SolarSystem {
    private int x;
    private int y;

    public SolarSystem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //@androidx.annotation.NonNull
    @Override
    public String toString() {
        return "Planet exists at x:" + this.x + " y:" + this.y;
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

package com.example.rjl77.spacetrader.entities;

import android.util.Log;

import java.util.HashSet;
import java.util.Random;

public class Universe {

    private HashSet<SolarSystem> system;

    public Universe() {
        Random cood = new Random();
        while (system.size() < 10) {
            int x = cood.nextInt(20);
            int y = cood.nextInt(15);

            Log.i("Planet", "Creating SolarSystem at " + x + " " + y);
            SolarSystem newSystem = new SolarSystem(x, y);
            Log.i("Planet", newSystem.toString());
            system.add(newSystem);
        }
    }
}

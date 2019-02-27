package com.example.rjl77.spacetrader.entities;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Universe {

    private HashSet<SolarSystem> system;

    /**
     *Constructor for Universe
     *
     */
    public Universe() {
        system = new HashSet<>();
        Random cood = new Random();
        List<String> systemNames = new ArrayList<>(10);
        systemNames.addAll(Arrays.asList("Bretel", "Guinifer", "Rubicum", "Iodine", "Laertes",
                "Omphalos", "Tantalos", "Xerxes", "Helena", "RIP Kishan"));

        while (system.size() < 10) {
            int x = cood.nextInt(20);
            int y = cood.nextInt(15);
            String name = systemNames.get(system.size());

            SolarSystem newSystem = new SolarSystem(x, y, name);

            if (!system.contains(newSystem)) {
                Log.i("Planet", "Creating SolarSystem " + name + "at " + x + " " + y);
                Log.i("Planet", newSystem.toString());
                system.add(newSystem);
            }
        }
    }

//    @Override
//    public String toString() {
//        for (int i = 0; i < system.size(); i++) {
//
//        }
//    }

}

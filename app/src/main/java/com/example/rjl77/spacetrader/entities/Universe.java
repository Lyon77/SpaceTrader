package com.example.rjl77.spacetrader.entities;

//import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Represents the universe
 * @author Team 71
 * @version 1.0
 */
public class Universe {

    private HashSet<SolarSystem> system;
    private SolarSystem currentSystem;
    private List<String> systemNames;

    /**
     *Constructor for Universe
     */
    public Universe() {
        system = new HashSet<>();
        Random r = new Random();
        systemNames = new ArrayList<>(Arrays.asList("Bretel", "Guinifer", "Rubicum", "Iodine",
                "Laertes", "Omphalos", "Tantalos", "Xerxes", "RIP Kishan", "Exo"));

        while (system.size() < 10) {
            int x = r.nextInt(20);
            int y = r.nextInt(15);
            String name = systemNames.get(system.size());

            SolarSystem newSystem = new SolarSystem(x, y, name);

            if (!system.contains(newSystem)) {
                //Log.i("Planet", "Creating SolarSystem " + name + "at " + x + " " + y);
                //Log.i("Planet", newSystem.toString());
                system.add(newSystem);
                currentSystem = newSystem;
            }
        }
    }

//    public SolarSystem getCurrentSystem() {
//        return currentSystem;
//    }

    /**
     * Getter for system name
     * @return name of current solar system
     */
    public String getCurrentSystemName() {
        return currentSystem.getName();
    }

    /**
     * Setter for current system
     * @param systemName String name of desired solar system
     * @return whether it is possible to travel to that system
     */
    public boolean setCurrentSystem(String systemName) {
        if (currentSystem.getName().equals(systemName)){
            return false;
        }
        for (SolarSystem ss : system) {
            if (ss.equalName(systemName)){
                currentSystem = ss;
                return true;
            }
        }
        //Log.i("Planet", "Something with the Spinner Failed");
        return false;
    }

    /**
     * Getter for market in current system
     * @return HashMap of items and prices
     */
    public HashMap<String, Integer> getCurrentSystemMarket() {
        return currentSystem.getMarket();
    }

    /**
     * Getter for all solar system names
     * @return List of all solar system names
     */
    public List<String> getSystemNames() {return systemNames;}

}

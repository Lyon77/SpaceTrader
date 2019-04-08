package com.example.rjl77.spacetrader;

import com.example.rjl77.spacetrader.entities.Ship;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Jonathan He
 */

public class ShipTest {
    private Ship ship;

    @Before
    public void setUp() {
        ship = new Ship();
    }

    @Test
    public void testInvalidCargo() {
        assertEquals("Invalid cargo: ", 0, ship.cargoAmount("apple"));
    }

    @Test
    public void testNewValidCargo() {
        ship.addCargo("pear", 1);
        assertEquals("Valid cargo: ", 1, ship.cargoAmount("pear"));
    }

    @Test
    public void testExistingValidCargo() {
        ship.addCargo("pear", 1);
        assertEquals("Valid cargo: ", 1, ship.cargoAmount("pear"));
        ship.addCargo("pear", 5);
        assertEquals("Valid cargo: ", 6, ship.cargoAmount("pear"));
    }
}

package com.example.rjl77.spacetrader;

import com.example.rjl77.spacetrader.entities.Ship;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by Kiersten Schutz
 * Tests Ship's addCargo method
 */

public class ShipTest2 {
    private Ship ship;

    @Before
    public void setUp() {
        ship = new Ship();
    }

    @Test
    public void testAddNewCargo() {
        assertEquals("cargoAmount method identifies nonexistent cargo as existing", 0, ship.cargoAmount("food"));
        ship.addCargo("food", 1);
        assertEquals("Cargo amount not updated correctly.", 1, ship.cargoAmount("food"));
        assertEquals("Total cargo not updated correctly.", 1, ship.getTotalCargo());

    }

    @Test
    public void testAddExistingCargo() {
        ship.addCargo("food", 1);
        ship.addCargo("food", 1) ;
        assertEquals("Cargo amount not updated correctly.", 2, ship.cargoAmount("food"));
        assertEquals("Total cargo not updated correctly.", 2, ship.getTotalCargo());
    }

    @Test
    public void testAddMultipleCargos() {
        ship.addCargo("food", 3);
        assertEquals("Cargo amount not updated correctly.", 3, ship.cargoAmount("food"));
        assertEquals("Total cargo not updated correctly.", 3, ship.getTotalCargo());
    }

    @Test
    public void testAddRemovedCargo() {
        ship.addCargo("food", 1);
        ship.sellCargo("food", 1);
        ship.addCargo("food", 1);
        assertEquals("Cargo amount not updated correctly.", 1, ship.cargoAmount("food"));
        assertEquals("Total cargo not updated correctly.", 1, ship.getTotalCargo());
    }
}

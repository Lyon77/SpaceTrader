package com.example.rjl77.spacetrader;

import com.example.rjl77.spacetrader.entities.SolarSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SolarSystemTest {

    private SolarSystem solarSystem;
    private SolarSystem solarSystem2;
    private SolarSystem solarSystem3;
    @Before
    public void setUp() {
        solarSystem = new SolarSystem(1,1,"Huhu");
        solarSystem2 = new SolarSystem(1,1,"Huhu");
        solarSystem3 = new SolarSystem(1,3,"Huhu");
    }

    @Test
    public void testSystemNotEqual() {
        assertEquals("solar system not equal", false, solarSystem.equals(solarSystem3));
    }

    @Test
    public void testSystemEqual() {
        assertEquals("solar system equal", true, solarSystem.equals(solarSystem2));
    }

    @Test
    public void testNameEqual() {
        assertEquals("solar system name equal", true, solarSystem.equalName(solarSystem3.getName()));
    }
}
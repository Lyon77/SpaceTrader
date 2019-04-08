package com.example.rjl77.spacetrader;

import com.example.rjl77.spacetrader.entities.Universe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Ryan Li
 */
public class UniverseTest {
    private Universe uni;

    @Before
    public void setUp() {
        uni = new Universe();
    }

    @Test
    public void testAddCurrentName() {
        assertEquals("Universe set current name", false,
                uni.setCurrentSystem(uni.getCurrentSystemName()));
    }
    @Test
    public void testAddUnknownName() {
        assertEquals("Universe set unknown name", false,
                uni.setCurrentSystem("Fun zone"));
    }
    @Test
    public void testAddKnownName() {
        assertEquals("Universe set known name", true,
                uni.setCurrentSystem("Iodine"));
    }
}

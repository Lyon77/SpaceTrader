package com.example.rjl77.spacetrader.entities;
import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

/**
 * Represents a cargo item
 * @author Team 71
 * @version 1.0
 */
public class Item implements Serializable {

    private final String name;

    private final int price;

    private int cargoAmt;

    /**
     * Constructor for Item
     * @param name name of item
     * @param price price of item
     * @param cargoAmt amount in hold
     */
    public Item(String name, int price, int cargoAmt) {
        this.name = name;
        this.price = price;
        this.cargoAmt = cargoAmt;
    }

    /**
     * Getter for item name
     * @return name attribute
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for item price
     * @return price attribute
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter for cargo amount
     * @return cargoAmt attribute
     */
    public int getCargoAmt() {
        return cargoAmt;
    }

//    public void setCargoAmt(int amount) { cargoAmt = amount; }
}

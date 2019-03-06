package com.example.rjl77.spacetrader.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {

    private String name;

    private int price;

    private int cargoAmt;

    public Item(String name, int price, int cargoAmt) {
        this.name = name;
        this.price = price;
        this.cargoAmt = cargoAmt;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCargoAmt() {
        return cargoAmt;
    }
}

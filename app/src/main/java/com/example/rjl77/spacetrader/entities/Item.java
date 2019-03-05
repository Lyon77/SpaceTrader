package com.example.rjl77.spacetrader.entities;
import java.io.Serializable;

public enum Item implements Serializable{
    Water("Water"),
    Furs("Furs"),
    Food("Food"),
    Ore("Ore"),
    Games("Games"),
    Firearms("Firearms"),
    Medicine("Medicine"),
    Machines("Machines"),
    Narcotics("Narcotics"),
    Robots("Robots");

    private String item;

    Item(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item;
    }
}

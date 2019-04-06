package com.example.rjl77.spacetrader.entities;

public class Player {
    private String name;
    private int credits;
    private Ship ship;
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
//    private String _level;

    /**
     *No-args constructor for Player
     */
    public Player() {
        this("Ryan", 4, 4, 4, 4);
    }

    /**
     *Constructor for Player
     * @param name player's name
     * @param pil number of pilot points
     * @param fight number of fighter points
     * @param trade number of trader points
     * @param eng number of engineer points
     */
    public Player(String name, int pil, int fight, int trade, int eng) {
        this.name = name;
        this.pilot = pil;
        this.fighter = fight;
        this.trader = trade;
        this.engineer = eng;
        this.credits = 1000;
        this.ship = new Ship();
//        this._level = lev;
    }

    /**
     *Getter for name
     *@return name attribute value
     */
    public String getName() {
        return this.name;
    }

    /**
     *Getter for credits
     *@return credits attribute value
     */
    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int cred) { credits = cred; }

    /**
     *Getter for ship
     *@return ship attribute value
     */
    public Ship getShip() {
        return this.ship;
    }

//    /**
//     *Getter for level
//     *@return level attribute value
//     */
//    public String getLevel() {return _level;};

//    /**
//     *Setter for level
//     *@return level attribute value
//     */
//    public void set_level(String difficulty) {
//        _level = difficulty;
//    }

    //    @androidx.annotation.NonNull
    @Override
    public String toString() {
        return "\nName: " + this.name + "\n" + "Credits: " + credits + "\n" + "Ship: "
                + ship.toString() + "\n" + "Pilot Skill: " + pilot + "\n" + "Fighter Skill: "
                + fighter + "\n" + "Trader Skill: " + trader + "\n" + "Engineer Skill: "
                + engineer;
    }
}

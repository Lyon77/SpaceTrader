package com.example.rjl77.spacetrader.entities;

import java.util.HashMap;
import java.util.Random;


public class Market {

    private int techLevel;
    private int resource;
    private HashMap<String, Integer> prices;

    public enum TradeGood {
        WATER(0, 0, 2, 30, 3, 4, 4, 3),
        FURS(0, 0, 0, 250, 10, 10, 7, 8),
        FOOD(1, 0, 1, 100, 5, 5, 5, 6),
        ORE(2, 2, 3, 350, 20, 10, 1, 2),
        GAMES(3, 1, 6, 250, -10, 5, 11, -1),
        FIREARMS(3, 1, 5, 1250, -75, 100, 12, -1),
        MEDICINE(4, 1, 6, 650, -20, 10, 10, -1),
        MACHINES(4, 3, 5, 900, -30, 5, -1, -1),
        NARCOTICS(5, 0, 5, 35000, -125, 150, 9, -1),
        ROBOTS(6, 4, 7, 5000, 150, 100, -1, -1);

        private final int MTLP;
        private final int MTLU;
        private final int TTP;
        private final int basePrice;
        private final int IPL;
        private final int var;
        private final int CR;
        private final int ER;


        private TradeGood(int MTLP, int MTLU, int TTP, int basePrice, int IPL, int var, int CR, int ER) {
            this.MTLP = MTLP;
            this.MTLU = MTLU;
            this.TTP = TTP;
            this.basePrice = basePrice;
            this.IPL = IPL;
            this.var = var;
            this.CR = CR;
            this.ER = ER;
        }

        public int getMTLP() {return MTLP;}
        public int getMTLU() {return MTLU;}
        public int getTTP() {return TTP;}
        public int getBasePrice() {return basePrice;}
        public int getIPL() {return IPL;}
        public int getVar() {return var;}
        public int getCR() {return CR;}
        public int getER() {return ER;}

    }

    public Market(int techLevel, int resource) {
        this.techLevel = techLevel;
        this.resource = resource;
    }

    public void visit() {
        prices = new HashMap<>();
        Random r = new Random();
        for (TradeGood tg : TradeGood.values()) {
            if (tg.getMTLU() < techLevel) {
                int varSign = r.nextInt(1);
                int varActual = r.nextInt(tg.getVar());
                if (varSign == 0) {
                    varActual *= -1;
                }
                int price = tg.getBasePrice() + tg.getIPL() * (techLevel - tg.getMTLP()) + varActual;
                if (resource == tg.getCR()) {
                    price /= varActual;
                } else if (resource == tg.getER()) {
                    price *= varActual;
                }
                prices.put(tg.toString(), price);
            }
        }
    }

    public HashMap<String, Integer> getPrices() {
        return prices;
    }
}

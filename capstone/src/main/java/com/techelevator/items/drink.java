package com.techelevator.items;

import java.math.BigDecimal;

public class Drink extends FoodItem{


    public Drink(String name, String price, String slot) {
        super(name, price, slot);

    }

    @Override
    public String toString() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}

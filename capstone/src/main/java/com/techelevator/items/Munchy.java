package com.techelevator.items;

import java.math.BigDecimal;

public class Munchy extends FoodItem{

    public Munchy(String name, String price, String slot) {
        super(name, price, slot);
    }

    @Override
    public String toString() {
        return "Munchy, Munchy, so Good!";
    }
}

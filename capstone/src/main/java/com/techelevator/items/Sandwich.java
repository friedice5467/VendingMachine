package com.techelevator.items;

public class Sandwich extends FoodItem {

    public Sandwich(String name, String price, String slot) {
        super(name, price, slot);
    }

    @Override
    public String toString() {
        return "Sandwich So Delicious, Yum!";
    }
}

package com.techelevator.items;

public class Dessert extends FoodItem{

    public Dessert(String name, String price, String slot) {
        super(name, price, slot);
    }

    @Override
    public String toString() {
        return "Sugar, Sugar, so Sweet!";
    }
}

package com.techelevator.items;

import java.math.BigDecimal;

public class FoodItem {
    String name;
    BigDecimal price;
    String slot;

    public FoodItem(String name, String price, String slot) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlot() {
        return slot;
    }
}

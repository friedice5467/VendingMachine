package com.techelevator.items;

import java.math.BigDecimal;

public class FoodItem {
    String name;
    BigDecimal price;

    public FoodItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

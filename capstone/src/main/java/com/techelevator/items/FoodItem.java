package com.techelevator.items;

import java.math.BigDecimal;

public class FoodItem {
    String name;
    BigDecimal price;
    String slot;
    String itemType;

    public FoodItem(String name, String price, String slot, String itemType) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.slot = slot;
        this.itemType = itemType;
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

    public String getItemType() {
        return itemType;
    }
}

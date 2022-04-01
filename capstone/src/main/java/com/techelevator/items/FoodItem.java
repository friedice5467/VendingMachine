package com.techelevator.items;

import com.techelevator.fileIO.Audit;
import com.techelevator.fileIO.Inventory;
import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

    public static void dispenseItem(List<FoodItem> productList, Map<FoodItem, Integer> productMapAmount, String selection) {
        int counter = 0;
        for (FoodItem foodItem : productList) {
            String slot = foodItem.getSlot();
            if (selection.equals(slot)) {
                counter++;
                if (productMapAmount.get(foodItem) == 0) {
                    System.out.println("This item is no longer available\n");
                    return;
                } else if (productMapAmount.get(foodItem) > 0) {
                    // Select this item
                    if (Menu.getCurrentMoney().compareTo(foodItem.getPrice()) >= 0) {
                        System.out.println(foodItem.getName() + " $" + foodItem.getPrice());
                        Menu.subtractMoney(foodItem.getPrice());
                        System.out.println("Money remaining: $" + Menu.getCurrentMoney());
                        System.out.println(foodItem.toString() + "\n");
                        Inventory.updateInventory(productMapAmount, foodItem);
                    } else {
                        System.out.println("Funds low, deposit more money.\n");
                    }
                }
                Audit.createAuditFile(foodItem);
            }
        }
        if (counter <= 0) System.out.println("Item does not exist\n");
    }
}

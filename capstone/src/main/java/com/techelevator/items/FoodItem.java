package com.techelevator.items;

import com.techelevator.fileIO.Audit;
import com.techelevator.fileIO.Inventory;
import com.techelevator.view.Menu;
import com.techelevator.view.Money;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FoodItem {
    String name;
    BigDecimal price;
    String slot;
    static int counter = 0;

    public FoodItem(String name, String price, String slot) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.slot = slot;
    }

    public static int getCounter() {
        return counter;
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
        counter = 0;
        for (FoodItem foodItem : productList) {
            String slot = foodItem.getSlot();
            if (selection.equals(slot)) {
                if (productMapAmount.get(foodItem) == 0) {
                    System.out.println();
                    System.out.println("This item is no longer available\n");
                    return;
                } else if (productMapAmount.get(foodItem) > 0) {
                    if (Money.getCurrentMoney().compareTo(foodItem.getPrice()) >= 0) {

                        System.out.println();
                        System.out.println(foodItem.getName() + " $" + foodItem.getPrice());
                        Money.subtractMoney(foodItem.getPrice());
                        System.out.println("Money remaining: $" + Money.getCurrentMoney());
                        System.out.println(foodItem.toString() + "\n");
                        Inventory.updateInventory(productMapAmount, foodItem);
                        counter++;
                    } else {
                        System.out.println();
                        System.out.println("Funds low, deposit more money.\n");
                    }
                }
                Audit.createAuditFile(foodItem);
            }
        }
        if (counter <= 0) System.out.println("\nItem does not exist\n");
    }
}

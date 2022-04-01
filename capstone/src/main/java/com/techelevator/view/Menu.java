package com.techelevator.view;

import com.techelevator.items.FoodItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static BigDecimal currentMoney = new BigDecimal("0.00");
    private static BigDecimal previousMoney = new BigDecimal("0.00");
    private static BigDecimal enteredMoney = new BigDecimal("0.00");


    private static final Scanner input = new Scanner(System.in);

    public static String getHomeScreenChoice() {
        System.out.println();
        System.out.println("D) Display CaTEring Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");
        System.out.println();

        return input.nextLine().trim().toLowerCase();
    }

    public static BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public static BigDecimal getPreviousMoney() {
        return previousMoney;
    }

    public static BigDecimal getEnteredMoney() {
        return enteredMoney;
    }

    public static void subtractMoney(BigDecimal price) {
        previousMoney = currentMoney;
        currentMoney = currentMoney.subtract(price);
    }

    private static void addMoney() {
        previousMoney = currentMoney;
        currentMoney = currentMoney.add(enteredMoney);
    }

    public static void displayItems(List<FoodItem> productList, Map<FoodItem, Integer> productMapAmount) {
        for (FoodItem foodItem : productList) {
            System.out.print(foodItem.getSlot() + ") " + foodItem.getName() + " $" + foodItem.getPrice());
            if (productMapAmount.get(foodItem) == 0) {
                System.out.println(" NO LONGER AVAILABLE");
            } else {
                System.out.println();
            }
        }
    }

    public static String getPurchaseChoice() {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println("$" + getCurrentMoney() + "\n");

        return input.nextLine().trim().toLowerCase();

    }

    public static void acceptMoney() {
        System.out.println("A) $1");
        System.out.println("B) $5");
        System.out.println("C) $10");
        System.out.println("D) $20");
        System.out.print("Enter selection >>> ");
        try {
            String moneySelection = input.nextLine();

            if (moneySelection.equalsIgnoreCase("a")) {
                enteredMoney = new BigDecimal("1.00");
            } else if (moneySelection.equalsIgnoreCase("b")) {
                enteredMoney = new BigDecimal("5.00");
            } else if (moneySelection.equalsIgnoreCase("c")) {
                enteredMoney = new BigDecimal("10.00");
            } else if (moneySelection.equalsIgnoreCase("d")) {
                enteredMoney = new BigDecimal("20.00");
            } else {
                System.out.println("Invalid bill denomination\n");
            }
            addMoney();
            System.out.println("$" + currentMoney + "\n");

        } catch (NumberFormatException e) {
            System.out.println("Invalid bill denomination\n");
        }
    }

    public static void selectItem(List<FoodItem> productList, Map<FoodItem, Integer> productMapAmount) {
        displayItems(productList, productMapAmount);
        System.out.print("Please make a selection: ");
        String selection = input.nextLine().toUpperCase();
        FoodItem.dispenseItem(productList, productMapAmount, selection);
    }

    public static void finishPurchases() {
        Map<String, Integer> changeMap = Change.looseChange(currentMoney);
        System.out.println("Dollars: " + changeMap.get("Dollars") + " ");
        System.out.println("Quarters: " + changeMap.get("Quarters") + " ");
        System.out.println("Dimes: " + changeMap.get("Dimes") + " ");
        System.out.println("Nickels: " + changeMap.get("Nickels") + " ");
        subtractMoney(currentMoney);
        System.out.println("Current money: $" + getCurrentMoney());
    }
}

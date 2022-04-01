package com.techelevator.view;

import java.math.BigDecimal;
import java.util.HashMap;

public class Money {
    private static BigDecimal currentMoney = new BigDecimal("0.00");
    private static BigDecimal previousMoney = new BigDecimal("0.00");
    private static BigDecimal enteredMoney = new BigDecimal("0.00");

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

    public static void addMoney() {
        previousMoney = currentMoney;
        currentMoney = currentMoney.add(enteredMoney);
    }

    public static String updateMoney(String moneySelection) {
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
//        System.out.println("$" + currentMoney + "\n");
        return "$" + currentMoney;
    }

    public static HashMap<String, Integer> looseChange(BigDecimal change) {

        BigDecimal hundred = new BigDecimal("100.0");
        int cent = change.multiply(hundred).intValue();

        int dollarCount = 0;
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;

        if (cent > 0) {
            dollarCount = cent / 100;
            quarterCount = (cent % 100) / 25;
            dimeCount = (cent % 25) / 10;
            nickelCount = ((cent % 25) % 10) / 5;

        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Dollars", dollarCount);
        map.put("Nickels", nickelCount);
        map.put("Dimes", dimeCount);
        map.put("Quarters", quarterCount);

        return map;
    }
}

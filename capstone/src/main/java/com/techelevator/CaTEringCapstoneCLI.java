package com.techelevator;

import com.techelevator.fileIO.SalesReport;
import com.techelevator.items.FoodItem;
import com.techelevator.fileIO.Audit;
import com.techelevator.fileIO.Inventory;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaTEringCapstoneCLI {

    private Menu menu;

    public CaTEringCapstoneCLI(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
        cli.run();
    }

    public Map<FoodItem, Integer> setInitialAmount(List<FoodItem> productList) {
        Map<FoodItem, Integer> productMapAmount = new HashMap<>();

        for (FoodItem foodItem : productList) {
            productMapAmount.put(foodItem, SalesReport.getStartingInventoryAmount());
        }
        return productMapAmount;
    }

    public void run() throws FileNotFoundException {
        List<FoodItem> productList = Inventory.grabInventory();
        Map<FoodItem, Integer> productMapAmount = setInitialAmount(productList);

        label:
        while (true) {
            String choice = Menu.getHomeScreenChoice();
            switch (choice) {
                case "d":
                    Menu.displayItems(productList, productMapAmount);
                    break;
                case "p":
                    while (true) {
                        String purchaseChoice = Menu.getPurchaseChoice();
                        if (purchaseChoice.equals("m")) {
                            Menu.acceptMoney();
                            Audit.createAuditFile(purchaseChoice);
                        }
                        if (purchaseChoice.equals("s")) {
                            Menu.selectItem(productList, productMapAmount);
                        }
                        if (purchaseChoice.equals("f")) {
                            Menu.finishPurchases();
                            Audit.createAuditFile(purchaseChoice);
                            break;
                        }
                    }
                    break;
                case "s":
                    SalesReport.createSalesReport(productMapAmount);
                    break;
                case "e":
                    break label;
            }
        }
    }
}

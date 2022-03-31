package com.techelevator;

import com.techelevator.items.FoodItem;
import com.techelevator.ui.InventoryGrabber;
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

	public Map<FoodItem, Integer> setInitialAmount(List<FoodItem> productList){
		Map<FoodItem, Integer> productMapAmount = new HashMap<>();

		for(FoodItem foodItem : productList){
			productMapAmount.put(foodItem, 7);
		}

		return productMapAmount;
	}

	public void run() throws FileNotFoundException {

		List<FoodItem> productList = InventoryGrabber.grabInventory();
		Map<FoodItem, Integer> productMapAmount = setInitialAmount(productList);

		while (true) {

			String choice = Menu.getHomeScreenChoice();

			if(choice.equals("d")){

				for(FoodItem foodItem : productList){
					System.out.print(foodItem.getSlot() + ") " + foodItem.getName() + " " + foodItem.getPrice());
					if (productMapAmount.get(foodItem) == 0) {
						System.out.println(" NO LONGER AVAILABLE");
					} else {
						System.out.println();
					}
				}


				break;
			} else if (choice.equals("p")){
				while(true) {
					String purchaseChoice = Menu.getPurchaseChoice();
					if (purchaseChoice.equals("m")) Menu.acceptMoney();
					if (purchaseChoice.equals("s")) Menu.selectItem(productList, productMapAmount);
					if (purchaseChoice.equals('f')) Menu.finishPurchases();
				}
			} else if(choice.equals("e")){
				// exit
				break;
			}

		}
	}



}

package com.techelevator;

import com.techelevator.items.FoodItem;
import com.techelevator.ui.UserInput;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
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

	public void run() throws FileNotFoundException {

		List<FoodItem> productList = UserInput.grabInventory();

		while (true) {

			String choice = Menu.getHomeScreenChoice();

			if(choice.equals("d")){

				for(FoodItem foodItem : productList){
					System.out.println(foodItem.getSlot() + ") " + foodItem.getName() + " " + foodItem.getPrice());
				}

				break;
			} else if (choice.equals("p")){
				// purchase an item
				break;
			} else if(choice.equals("e")){
				// exit
				break;
			}

		}
	}

}

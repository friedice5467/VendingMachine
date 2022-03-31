package com.techelevator;

import com.techelevator.view.Menu;

public class CaTEringCapstoneCLI {



	private Menu menu;

	public CaTEringCapstoneCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		CaTEringCapstoneCLI cli = new CaTEringCapstoneCLI(menu);
		cli.run();
	}

	public void run() {
		while (true) {

			String choice = Menu.getHomeScreenChoice();

			if(choice.equals("d")){
				// display the products
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

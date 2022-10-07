package com.techelevator;

import com.sun.tools.javac.Main;
import com.techelevator.view.MainMenu;
import com.techelevator.view.Menu;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineOG {
//	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
//	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
//	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
//	private Menu menu;

    // PROPERTIES
    public Map<String, Integer> itemQtyList = new HashMap<>();


    public static void main(String[] args) {
//		Menu menu = new Menu(System.in, System.out);
//		VendingMachineCLI cli = new VendingMachineCLI(menu);
//		cli.run();
        MainMenu mainMenu = new MainMenu();
        mainMenu.displayMenu();
//		mainMenu.exitProgram();
    }


		/*
		  ===== you nay use/modify the existing Menu class or write your own ======
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
		 */
}



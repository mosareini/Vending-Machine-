package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

// PROPERTIES
	public static Map<String, Integer> itemQtyList = new HashMap<>();
	public static Map <String, String> itemIDList = new HashMap<>();
	public static final int MAX_QTY = 5;

//	public Scanner scanner = new Scanner()


	public static void main(String[] args) {
		File dir = new File("./");
		System.out.println(dir.getAbsolutePath());
		File inventoryFile = new File("src/main/resources/vendingmachine.csv");

		try(Scanner userInput = new Scanner(inventoryFile)) {
			while(userInput.hasNextLine()) {
				String currentLine = userInput.nextLine();
				String[] currentArray = currentLine.split("|");

				if (currentArray[3] == "Chip") {
					Chips chip  = new Chips(currentArray[1], Double.parseDouble(currentArray[2]), 5);
					itemIDList.put(chip.getName(), currentArray[0]);
					itemQtyList.put(chip.getName(), MAX_QTY);
				} else if (currentArray[3] == "Candy") {
					Candy candies = new Candy(currentArray[1], Double.parseDouble(currentArray[2]), 5);
					itemIDList.put(candies.getName(), currentArray[0]);
					itemQtyList.put(candies.getName(), MAX_QTY);
				} else if (currentArray[3] == "Drink") {
					Beverages drinks = new Beverages(currentArray[1], Double.parseDouble(currentArray[2]), 5);
					itemIDList.put(drinks.getName(), currentArray[0]);
					itemQtyList.put(drinks.getName(), MAX_QTY);
				} else {
					Gum chewies = new Gum(currentArray[1], Double.parseDouble(currentArray[2]), 5);
					itemIDList.put(chewies.getName(), currentArray[0]);
					itemQtyList.put(chewies.getName(), MAX_QTY);
				}
				System.out.println();
			}

		}catch (FileNotFoundException e) {
			System.out.println("File not found");
		}





		MainMenu mainMenu = new MainMenu();
		mainMenu.displayMenu();
//		mainMenu.exitProgram();
	}
}



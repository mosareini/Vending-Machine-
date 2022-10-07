package com.techelevator;

import com.techelevator.view.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	// PROPERTIES
	public static Scanner userInput = new Scanner(System.in); //uses userInput scanner for all user inputs
	public static Map<String, Item> itemList = new HashMap<>(); //stores a map of (Code, Item)
	public static final int MAX_QTY = 5;
	public static double customerBalance = 0;

	public static void main(String[] args) {

		//--finds inventory file
		File inventoryFile = new File("vendingmachine.csv");

		//--reads inventory file and splits each line by pipe
		try (Scanner readFile = new Scanner(inventoryFile)) {
			while (readFile.hasNextLine()) {
				String currentLine = readFile.nextLine();
				String[] currentArray = currentLine.split("\\|");

				//--instantiates all items (fully stocked), adds item to itemList Map
				if (currentArray[3].equals("Chip")) {
					Chips chip = new Chips(currentArray[1], Double.parseDouble(currentArray[2]), MAX_QTY);
					itemList.put(currentArray[0], chip);
				} else if (currentArray[3].equals("Candy")) {
					Candy candies = new Candy(currentArray[1], Double.parseDouble(currentArray[2]), MAX_QTY);
					itemList.put(currentArray[0], candies);
				} else if (currentArray[3].equals("Drink")) {
					Beverages drinks = new Beverages(currentArray[1], Double.parseDouble(currentArray[2]), MAX_QTY);
					itemList.put(currentArray[0], drinks);
				} else if (currentArray[3].equals("Gum")) {
					Gum chewies = new Gum(currentArray[1], Double.parseDouble(currentArray[2]), MAX_QTY);
					itemList.put(currentArray[0], chewies);
				} else {
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		//--opens main menu--
		mainMenu();
	}

	public static void mainMenu() {

		while (true) {

			System.out.println("Please select an option:");
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");

			//--saves user input as mainMenuInput--
			String mainMenuInput = userInput.nextLine();

			//--if user selects 1: Display Vending Machine Items
			if (mainMenuInput.equals("1")) {
				displayItemList();
				System.out.println("\nPress 'R' to return to the main menu");

				// --loops error message until correct key is pressed--
				String returnToMain = userInput.nextLine();
				while (!returnToMain.equals("R")) {
					System.out.println("Invalid response. Try again.");
					returnToMain = userInput.nextLine();
				}
			//--if user enters 2: go to purchase menu
			} else if (mainMenuInput.equals("2")) {
				purchaseMenu();
				break;
			//--if user enters 3: exit program
			} else if (mainMenuInput.equals("3")) {
				System.out.println("Goodbye.");
				System.exit(0);
			//--if user enters anything else, go back to main menu
			} else {
				System.out.println("Invalid response. Please try again");
			}
		}
	}

	public static void purchaseMenu() {

		while (true) {

			//--displays purchase menu and customer's balance
			System.out.printf("Current Money Provided: $" + "%.2f", customerBalance);
			System.out.println("\n(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
			String purchaseChoice = userInput.nextLine();

			//--if user enters 1: feed money
			if (purchaseChoice.equals("1")){
				System.out.printf("Current Money Provided: $" + "%.2f", customerBalance);
				System.out.println("\nEnter the amount of money you would like to insert (whole dollars only):");
				String dollarAmount = userInput.nextLine();

				//--checks if inserted amount is a whole dollar amount
				double feedMoney = Double.parseDouble(dollarAmount);

				//--adds funds to customerBalance only if user entered whole dollar amount
				if (((feedMoney * 100) % 100 == 0) && feedMoney > 0){
					customerBalance += feedMoney;
					logFeedMoney(feedMoney, customerBalance);
				} else {
					System.out.println("Must be a whole dollar amount greater than zero. Please try again.");
				}
			}
			//--if user enters 2: show list of available products and allow customer to select a product
			else if (purchaseChoice.equals("2")){
				dispenseItem();
			//--if user enters 3:
			} else if (purchaseChoice.equals("3")){

				if (customerBalance > 0){
					int changeInCents = (int) (customerBalance * 100);
					int[] coins = calcChange(changeInCents);
					System.out.println("Your change is " + coins[0] + " quarters, " + coins[1] + " dimes, and " + coins[2] + " nickels");
					logChange(customerBalance);
					customerBalance = 0;
				}
				mainMenu();
			} else {
				System.out.println("Invalid response. Please try again.");
			}
		}
	}

	public static void dispenseItem(){

		while(true) {
			//--print list of available products
			for (Map.Entry<String, Item> item : itemList.entrySet()) {
				String key = item.getKey();
				Item value = item.getValue();

				if (item.getValue().getQuantity() >= 1) {
					System.out.printf("Enter " + key + " for " + value.getName() + " (Price: " + "%.2f" + ", Quantity: " + value.getQuantity() + ")" + "\n", value.getPrice());
				} else {
					System.out.println("Enter " + key + " for " + value.getName() + " (SOLD OUT)");
				}
			}

			//--compares user input to keys in map
			String itemChoice = userInput.nextLine().toUpperCase();

			if (!itemList.containsKey(itemChoice)){ //if code is not in map
				System.out.println("Invalid code. Please try again.");
			} else { //if code is in map
				Item choice = itemList.get(itemChoice);
				//--if code is in map, but item is sold out
				if (choice.getQuantity() == 0) {
					System.out.println("Item is sold out. Please try again.");
				//--if code is in map AND not sold out
				} else {
					//--checks if balance is greater than price
					if(customerBalance > choice.getPrice()){
						System.out.println("Dispensing...");
						System.out.printf("\nEnjoy your " + choice.getName() + " for $%.2f", choice.getPrice());
						System.out.println("\n" + choice.yumYumStatement());
						customerBalance -= choice.getPrice();
						choice.removeOne();
						System.out.printf("Current Balance: $%.2f\n", customerBalance);
						logPurchase(choice, itemChoice);
						purchaseMenu();
					} else {
						System.out.println("Insufficient funds.");
						mainMenu();
					}
				}
			}
		}
	}

	public static void displayItemList(){
		for (Map.Entry<String, Item> item : itemList.entrySet()) {
			Item value = item.getValue();
			System.out.printf("\n" + value.getName() + " (Price: $%.2f" + ", Quantity: " + value.getQuantity() + ")", value.getPrice());
		}
	}

	public static void logFeedMoney(double deposited, double balance){

		//--finds log file
		File logFile = new File("src/main/resources/Log.txt");

		//--writes to log file
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {

			//--gets and formats time
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
			writer.printf(dateFormat.format(currentDate) + " FEED MONEY: $%.2f $%.2f" + "\n", deposited, balance);

		} catch (FileNotFoundException e) {
			System.out.println("Cannot log transaction. Log file not found.");
		}
	}

	public static void logPurchase(Item purchasedItem, String code){

		//--finds log file
		File logFile = new File("src/main/resources/Log.txt");

		//--writes to log file
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {

			//--gets and formats time
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
			writer.printf(dateFormat.format(currentDate) + " " + purchasedItem.getName() + " " + code + " $%.2f $%.2f\n", purchasedItem.getPrice(), customerBalance);

		} catch (FileNotFoundException e) {
			System.out.println("Cannot log transaction. Log file not found.");
		}
	}

	public static int[] calcChange(int changeInCents){

		int[] coins = new int[3];

		int numberOfQuarters = changeInCents / 25;
		int remainder = changeInCents % 25;
		coins[0] = numberOfQuarters;

		int numberOfDimes = remainder / 10;
		remainder = remainder % 10;
		coins[1] = numberOfDimes;

		int numberOfNickels = remainder / 5;
		coins[2] = numberOfNickels;

		return coins;

	}


	public static void logChange(double change){

		//--finds log file
		File logFile = new File("src/main/resources/Log.txt");

		//--writes to log file
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {

			//--gets and formats time
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
			writer.printf(dateFormat.format(currentDate) + " GIVE CHANGE: $%.2f $0.00" + "\n", change);

		} catch (FileNotFoundException e) {
			System.out.println("Cannot log transaction. Log file not found.");
		}
	}
}




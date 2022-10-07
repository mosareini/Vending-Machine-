package com.techelevator.view;

import java.util.Map;
import java.util.Scanner;

public class MainMenu  {

// PROPERTIES
    public Scanner reader;

// CONSTRUCTOR
    public MainMenu() {}

// METHODS
    public void displayMenu() {
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public void displayItemList(Map<String, Integer> itemQtyList) {
        for (Map.Entry <String, Integer> entry : itemQtyList.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " - Quantity: " + value);
            }
        }

    public void exitProgram() {
        System.exit(0);
    }
}


package com.techelevator.view;

public abstract class  Item {

// PROPERTIES
    protected String name;
    protected double price;
    protected int quantity;

//CONSTRUCTOR
     public Item(String name, double price, int quantity){
         this.name = name;
         this.price = price;
         this.quantity = quantity;
     }

// GETTERS/SETTERS
    abstract public String getName();
    abstract public double getPrice();
    abstract public int getQuantity();

// METHODS
    abstract public String yumYumStatement();
    abstract public void removeOne();
}

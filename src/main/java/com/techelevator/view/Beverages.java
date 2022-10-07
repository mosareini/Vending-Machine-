package com.techelevator.view;

public class Beverages extends Item {

// CONSTRUCTOR
    public Beverages(String name, double price, int quantity) {
        super(name, price, quantity);
    }

// GETTERS/SETTERS
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {return price;}

    @Override
    public int getQuantity() {return quantity;}

// METHODS
    @Override
    public String yumYumStatement() {
        return "Glug Glug, Yum";
    }

    @Override
    public void removeOne(){
        this.quantity--;
    }
}

package com.techelevator.view;

public class Beverages extends Item {

    // PROPERTIES
    public int currentQty;

    // CONSTRUCTOR
    public Beverages(String name, double price, int currentQty) {
        this.name =  name;
        this.price = price;
        this.currentQty = currentQty;
    }

    // GETTERS/SETTERS
    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public double getPrice() {
        return super.price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    void setPrice(double price) {
        this.price = price;
    }

    // METHODS
    public String yumYumStatement() {
        return "Glug Glug, Yum";
    }


}

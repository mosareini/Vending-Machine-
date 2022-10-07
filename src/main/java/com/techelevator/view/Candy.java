package com.techelevator.view;

public class Candy extends Item {

// PROPERTIES
    public int currentQty;

// CONSTRUCTOR
    public Candy(String name, double price, int currentQty) {
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
        return "Munch Munch, Yum";
    }

}



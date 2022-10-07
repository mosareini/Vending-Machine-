package com.techelevator.view;

public abstract class  Item {

// PROPERTIES

    public String name;
    public double price;

// GETTERS/SETTERS

    abstract public String getName();
    abstract public double getPrice();
    abstract public void setName(String name);
    abstract void setPrice(double price);

// METHODS

    public String  yumYumStatement;
}

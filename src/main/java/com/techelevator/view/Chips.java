package com.techelevator.view;

public class Chips extends Item {

// CONSTRUCTOR
    public Chips(String name, double price, int quantity) {
        super(name, price, quantity);
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
    public int getQuantity() {return super.quantity;}

    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }

// METHODS
    @Override
    public String yumYumStatement() {
        return "Crunch Crunch, Yum";
    }

    @Override
    public void removeOne(){
        this.quantity--;
    }
}

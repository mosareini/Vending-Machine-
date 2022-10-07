package com.techelevator.view;

public class Gum extends Item {

// CONSTRUCTOR
    public Gum(String name, double price, int quantity) {
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
        return "Chew Chew, Yum!";
    }

    @Override
    public void removeOne(){
        this.quantity--;
    }
}


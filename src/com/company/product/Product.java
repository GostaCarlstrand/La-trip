package com.company.product;

public class Product {
    protected String name;
    protected int price;
    protected double weight;

    public String getName() {return name;}
    public int getPrice() {return price;}

    @Override
    public String toString() {
        String name = getName();
        return name;
    }

}

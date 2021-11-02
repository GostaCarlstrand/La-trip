package com.company.product;

public class Product {
    protected String name;
    protected int price;

    public String getName() {return name;}
    public int getPrice() {return price;}

    @Override
    public String toString() {
        return getName();
    }

}

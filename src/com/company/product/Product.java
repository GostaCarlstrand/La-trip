package com.company.product;

import java.util.Random;

public class Product {
    protected String name;
    protected int price;
    protected double weight;

    public String getName() {return name;}
    public int getPrice() {return price;}
    public double getWeight() {return weight;}

    public void setWeight() {
        Random random = new Random();
        int differenceNumber = random.nextInt(1,2);
        this.weight =+ differenceNumber;
    }

}

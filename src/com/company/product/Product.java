package com.company.product;

import java.util.ArrayList;
import java.util.Random;

public class Product {
    protected String name;
    protected int price;
    protected double weight;

    public String getName() {return name;}
    public int getPrice() {return price;}
    public double getWeight() {return weight;}



    @Override
    public String toString() {
        String name = getName();
        return name;
    }




}

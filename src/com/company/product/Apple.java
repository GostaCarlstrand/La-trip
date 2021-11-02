package com.company.product;

public class Apple extends Product{
    int weight;

    public Apple(){
        name = "Apple";
        price = 2;      //price per kg
    }

    public int calculatePriceApple(int weight) {
        int totalSum = this.price * weight;
        return totalSum;
    }

}

package com.company.product;

public class Pear extends Product{


    public Pear(){
        name = "Pear";
        price = 3;      //price per kg
    }

    public int calculatePricePear(int weight) {
        int totalSum = this.price * weight;
        return totalSum;
    }

}

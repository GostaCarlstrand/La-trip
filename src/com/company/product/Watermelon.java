package com.company.product;

public class Watermelon extends Product{
    public Watermelon(){
        name = "Watermelon";
        price = 7;      //price per kg
    }



    public int calculatePriceWatermelon(int weight) {
        int totalSum = this.price * weight;
        return totalSum;
    }

}

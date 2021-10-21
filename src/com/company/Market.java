package com.company;
import com.company.product.*;

import java.util.*;

public class Market extends Location {
        Purchase purchase;
        Menu menu;
        Watermelon watermelon = new Watermelon();
        Pear pear = new Pear();
        Apple apple = new Apple();
        Banana banana = new Banana();
        Kiwi kiwi = new Kiwi();
        Potato potato = new Potato();
        Bourbon bourbon = new Bourbon();
        Wine wine = new Wine();
        Beer beer = new Beer();
        Vodka vodka = new Vodka();
        Product [] franksProductInStock = {bourbon, wine, beer, vodka};
        Product [] alsProductInStock = {watermelon, pear, apple, banana, kiwi, potato};
        String alsBrandName = "Al's Fruit";
        String franksBrandName = "Franks Tobacco & Liquor";


    public Market(Menu menu) {
        name = "Market";
        address = "Apple Rd";
        description = "The market offers a variety of different products, just be prepared to bargain";
        taxiCost = 45;
        activities = new String[]{"Fruit", "Alcohol"};
        this.menu = menu;

    }


    public void marketActivities () {
        boolean running = true;
        int menuChoice = menu.chooseLocationActivity(activities);
        while (running) {
            switch (menuChoice) {
                case 0:
                    welcomeToAlsFruit();
                    running = false;
                    break;

                case 1:
                    welcomeToFranksLiquor();
                    running = false;
                    break;

                default:
                    System.out.println("There no such activity ");
                    running = false;
                    break;
            }

        }
    }
    private void welcomeToFranksLiquor(){
        menu.welcomeToVenueMessage(franksBrandName);
        purchase.displayProducts(franksProductInStock);
        purchase.addProductToCart(franksProductInStock, franksBrandName);
    }
    private void welcomeToAlsFruit(){
        menu.welcomeToVenueMessage(alsBrandName);
        purchase.displayProducts(alsProductInStock);
        purchase.addProductToCart(alsProductInStock, alsBrandName);
    }

    public void addPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
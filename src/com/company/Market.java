package com.company;
import com.company.product.*;

import java.util.*;

public class Market extends Location {
        Menu menu;
        Watermelon watermelon = new Watermelon();
        Pear pear = new Pear();
        Apple apple = new Apple();
        Product [] productInStock = {watermelon, pear, apple};
        ArrayList <String> shoppingCart = new ArrayList<>();
        ArrayList <Integer> shoppingCartPrice = new ArrayList<>();

    public Market(Menu menu) {
        name = "Market";
        address = "Apple Rd";
        description = "The market offers a variety of different products, just be prepared to bargain";
        taxiCost = 45;
        activities = new String[]{"Fruit", "Frank's shoes"};
        this.menu = menu;

    }



    public void marketActivities (int menuChoice) {
        boolean running = true;


        Scanner scanner = new Scanner(System.in);
        while (running) {
            switch (menuChoice) {
                case 0:                                     //1 index of the marketActivitiesList
                    welcometoAlsFruit();
                    displayFruits();
                    addProductToCart();
                    displayCart();



                    break;

                default:
                    System.out.println("There no such activity ");
                    break;

            }
            running = false;
        }

    }

    private void welcometoAlsFruit(){
        System.out.println("Hi, and welcome to Al's Fruit \n" +
                "what can I get you?: \n" +
                "1. Leave store \n" +
                "2. Remove any product \n" +
                "3. Remove all objects"
        );
    }


    private void displayFruits() {
        for (Product product : productInStock) {
            System.out.println(product.getName());
        }

    }

    private void displayCart() {
        System.out.println("You have added the following products to your cart: " + shoppingCart.toString());
        System.out.println("Your price: " + shoppingCartPrice.toString());
    }

    private void addProductToCart() {       //Test could be to add ''another'' product if it is already in list
        boolean running = true;
        while (running) {
            String menuChoice = menu.menuInput();
            for (int i = 0; i < productInStock.length; i++) {
                if (menuChoice.equalsIgnoreCase(productInStock[i].getName())) {
                    shoppingCart.add(productInStock[i].getName());
                    shoppingCartPrice.add(productInStock[i].getPrice());
                } else if (menuChoice.equalsIgnoreCase("1")) {
                    running = false;                                // Leave store
                    break;
                } else if (menuChoice.equalsIgnoreCase("2")) {       //Remove any of the objects
                    removeProductsFromCart();
                } else if (menuChoice.equalsIgnoreCase("3")) {       // Remove all objects in shopping cart
                    shoppingCart.clear();
                    shoppingCartPrice.clear();
                    System.out.println("Your cart is now empty");
                    break;
                    }

                }
            if ((shoppingCart.isEmpty() && shoppingCartPrice.isEmpty())) {
                displayFruits();
            } else {
                displayCart();
            }




            }

    }

    public void removeProductsFromCart () {     //Test to remove until list is empty
    boolean running = true;
       while (running) {
          System.out.println("This is your current cart: " + shoppingCart.toString());
          System.out.print("What product would you like to remove?: ");
          String menuChoice = menu.menuInput();
          for (int i = 0; i < productInStock.length; i++) {
              if (menuChoice.equalsIgnoreCase(productInStock[i].getName())) {
                  shoppingCart.remove(productInStock[i].getName());
                  shoppingCartPrice.remove(productInStock[i].getPrice());
              } else if (menuChoice.equalsIgnoreCase("1")){
                  running = false;
                  break;
              } else {
                  System.out.println("The cart does not contain that product");
              }

          }

    }









    }
}
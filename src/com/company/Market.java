package com.company;
import com.company.product.*;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.*;

public class Market extends Location {
        Menu menu;
        Receipt receipt;
        Watermelon watermelon = new Watermelon();
        Pear pear = new Pear();
        Apple apple = new Apple();
        Banana banana = new Banana();
        Kiwi kiwi = new Kiwi();
        Potato potato = new Potato();
        Product [] productInStock = {watermelon, pear, apple, banana, kiwi, potato};
        ArrayList <String> shoppingCart = new ArrayList<>();
        ArrayList <Integer> shoppingCartPrice = new ArrayList<>();
        ArrayList <Product> productCart = new ArrayList<Product>();
        String brandName = "Al's Fruit";



    public Market(Menu menu, Receipt receipt) {
        name = "Market";
        address = "Apple Rd";
        description = "The market offers a variety of different products, just be prepared to bargain";
        taxiCost = 45;
        activities = new String[]{"Fruit", "Frank's shoes"};
        this.menu = menu;
        this.receipt = receipt;

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
        System.out.println("Hi, and welcome to Al's Fruit + \n" +
                "what can I get you?: \n" +
                "1. Leave store \n" +
                "2. Remove any product \n" +
                "3. Remove all objects \n" +
                "4. Go to cashier"
        );
    }


    private void displayFruits() {
        for (Product product : productInStock) {
            System.out.println(product.getName());
        }

    }

    private String displayCart() {
        String displayCart = productCart.toString().replace("[", "").replace("]", "");
        return displayCart;
    }

    public int calculatePrice(ArrayList <Product> productCart) {
        int totalSum = 0;
        for (Product i : productCart) {
            totalSum = totalSum + (i).getPrice();
        }
        return totalSum;
    }


    private void addProductToCart() {       //Test could be to add ''another'' product if it is already in list
        boolean running = true;
        while (running) {
            String menuChoice = menu.menuInput();
            for (int i = 0; i < productInStock.length; i++) {
                if (menuChoice.equalsIgnoreCase(productInStock[i].getName())) {
                    productCart.add(productInStock[i]);
                } else if (menuChoice.equalsIgnoreCase("1")) {
                    running = false;                                // Leave store
                    break;
                } else if (menuChoice.equalsIgnoreCase("2")) {       //Remove any of the objects
                    if (!(productCart.isEmpty())) {
                        removeProductsFromCart();
                        break;
                    } else {
                        System.out.println("Your cart does not contain any products");
                        break;
                    }
                } else if (menuChoice.equalsIgnoreCase("3")) {       // Remove all objects in shopping cart
                    productCart.clear();
                    System.out.println("Your cart is now empty");
                    break;
                } else if (menuChoice.equalsIgnoreCase("4")) {
                    int totalSum = calculatePrice(productCart);
                    System.out.println("That will be: " + totalSum);
                    createReceipt();
                    writeReceipt();
                    break;
                }


            }
            if ((productCart.isEmpty())) {
                displayFruits();
            } else {
                System.out.println("Product in your cart: " + displayCart());
            }

        }
    }

    private void removeProductsFromCart () {
        boolean running = true;
        System.out.println("Here you can enter the products that you would like to remove,\n" +
                "Type return to continue shopping");
        while (running) {
            System.out.println(productCart.size());
            System.out.println("This is your current cart: " + displayCart());
            System.out.print("What product would you like to remove?: ");
            String menuChoice = menu.menuInput();
            for (int i = 0; i <= productCart.size(); i++) {
                if (menuChoice.equalsIgnoreCase(productCart.get(i).getName())) {
                    productCart.remove(productCart.get(i));
                    break;
                } else if (menuChoice.equalsIgnoreCase("return")) {
                    running = false;
                    break;
                }
            }
            if (productCart.isEmpty()) {
                running = false;
                break;
            }
        }
    }
    public void createReceipt() {
        try {
            File file = new File("receipt.txt");
            if (file.createNewFile()) {
                System.out.println("A receipt has been printed to you");
            }
        } catch (IOException e) {
            System.out.println("Could not create a file");
            e.printStackTrace();
        }
    }

    private String displayProductReceipt(ArrayList<Product> productCart) {
        String products = "";
        for (int i = 0; i < productCart.size(); i++) {
            products += "\n - " + productCart.get(i).getName();

        }
        return products;
    }

    private String displayPriceReceipt(ArrayList<Product> productCart) {
        String pricePerProduct = "";
        for (int i = 0; i < productCart.size(); i++) {
            pricePerProduct += "\n - " + productCart.get(i).getPrice();

        }
        return pricePerProduct;
    }



    public void writeReceipt() {
        try {
            FileWriter fileWriter = new FileWriter("receipt.txt");
            fileWriter.write(("-----------------Thanks for shopping at " + brandName + "-----------------"));
            fileWriter.write(displayProductReceipt(productCart));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            String sum = String.valueOf(calculatePrice(productCart));       //int
            String sumVAT = String.valueOf(calculatePrice(productCart)*0.12D); //double
            fileWriter.write("Total price will be: " + sum + " dollars \n");
            fileWriter.write("VAT 12%: " + sumVAT);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }





}
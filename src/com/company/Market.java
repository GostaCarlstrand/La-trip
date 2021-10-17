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
        Purchase purchase;
        Character character;
        Menu menu;
        Receipt receipt;
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
        ArrayList <String> shoppingCart = new ArrayList<>();
        ArrayList <Integer> shoppingCartPrice = new ArrayList<>();
        ArrayList <Product> productCart = new ArrayList<Product>();
        String alsBrandName = "Al's Fruit";
        String franksBrandName = "Franks Tobacco & Liquor";
        int totalSum;       //Used to store the product total value


    public Market(Menu menu, Receipt receipt, Character character, Purchase purchase) {
        name = "Market";
        address = "Apple Rd";
        description = "The market offers a variety of different products, just be prepared to bargain";
        taxiCost = 45;
        activities = new String[]{"Fruit", "Alcohol"};
        this.menu = menu;
        this.receipt = receipt;
        this.character = character;
        this.purchase = purchase;
    }


    public void marketActivities (int menuChoice) {
        boolean running = true;
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
        displayProducts(franksProductInStock);
        addProductToCart(franksProductInStock, franksBrandName);
    }
    private void welcomeToAlsFruit(){
        menu.welcomeToVenueMessage(alsBrandName);
        displayProducts(alsProductInStock);
        addProductToCart(alsProductInStock, alsBrandName);
    }
    private void displayProducts(Product [] productInStock) {
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
    public void checkOut(String brandName) {
        if (brandName == franksBrandName)
            {
                if (!character.checkAgeToPurchase(character.getAge())) {
                    System.out.println("Sorry, you are under age, come back in " + (21-character.getAge()) + " years");
                    productCart.clear();
                    addProductToCart(franksProductInStock, franksBrandName);    //Calling the method if character is under age
                }
            }

        totalSum = calculatePrice(productCart);
        if (!(character.checkCharacterHasMoney(character.getWalletBalance(), totalSum))){
            System.out.println("You only have " + character.getWalletBalance() + " dollars, this will cost you\n "+
                    totalSum + ", come back with more money!");
            productCart.clear();
            addProductToCart(franksProductInStock, franksBrandName);//Call the method to return and not execute the other code in the method
        }
        character.updateWalletBalance(totalSum);
        System.out.println("That will be: " + totalSum);
        createReceipt(brandName);
        writeReceipt(brandName);

        productCart.clear();            //Erase the elements in the ArrayList
    }
    private void addProductToCart(Product [] productInStock, String brandName) {
        boolean running = true;
        while (running) {
            System.out.print("What can I get you?: ");
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
                        System.out.println("Your cart is empty, you have no products to remove");
                        break;
                    }
                } else if (menuChoice.equalsIgnoreCase("3")) {       // Remove all objects in shopping cart
                    productCart.clear();
                    System.out.println("Your cart is now empty");
                    break;
                } else if (menuChoice.equalsIgnoreCase("4")) {
                    checkOut(brandName);
                    running = false;
                    break;
                }
            }
            if ((productCart.isEmpty())) {
                displayProducts(productInStock);
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
            System.out.println("This is your current cart: " + displayCart());
            System.out.print("What product would you like to remove?: ");
            String menuChoice = menu.menuInput();
            boolean isPartOfProductCart = false;
            if (menuChoice.equalsIgnoreCase("return")) {
                running = false;
                break;
            }
            for (Product p : productCart) {
                if (menuChoice.equalsIgnoreCase(p.getName())) {
                    productCart.remove(p);
                    isPartOfProductCart = true;
                    break;
                }
            }

            if (!isPartOfProductCart) {
                System.out.println("Your cart does not contain that product");
            }

            if (productCart.isEmpty()) {
                running = false;
                break;
            }
        }
    }
    public void createReceipt(String brandName) {
        try {
            File file = new File(brandName + " Receipt.txt");
            if (file.createNewFile()) {
                System.out.println("A receipt has been printed to you");
            }
        } catch (IOException e) {
            System.out.println("Could not create a file");
            e.printStackTrace();
        }
    }
    public void writeReceipt(String brandName) {
        try {
            FileWriter fileWriter = new FileWriter(brandName + "receipt.txt");
            fileWriter.write(("-----------------Thanks for shopping at " + brandName + "-----------------"));
            fileWriter.write(displayProductReceipt(productCart));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            String sum = String.valueOf(calculatePrice(productCart));       //int
            String sumVAT = String.valueOf(calculatePrice(productCart)*0.12f); //double
            fileWriter.write("Total price will be: " + sum + " dollars \n");
            fileWriter.write("VAT 12%: " + sumVAT);
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.write("Cash received: " + String.valueOf(character.getWalletBalance() + totalSum) + "\n");
            fileWriter.write("Cash back: " + (String.valueOf((character.getWalletBalance()))));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
    private String displayProductReceipt(ArrayList<Product> productCart) {
        String products = "";
        for (int i = 0; i < productCart.size(); i++) {
            products += "\n * " + productCart.get(i).getName() + "- " + PriceReceipt(productCart, i) + " $ ";
        }
        return products;
    }
    private int PriceReceipt(ArrayList<Product> productCart, int i) {
        return productCart.get(i).getPrice();
    }
}
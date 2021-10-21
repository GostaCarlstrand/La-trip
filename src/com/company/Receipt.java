package com.company;

import com.company.product.*;
import java.io.*;
import java.util.ArrayList;

public class Receipt {
    Character character;
    Purchase purchase;
    java.util.Date date = new java.util.Date();


    public Receipt(Character character) {
        this.character = character;

    }

    private String displayProductReceipt(ArrayList<Product> productCart) {
        String products = "";
        for (int i = 0; i < productCart.size(); i++) {
            products += "\n * " + productCart.get(i).getName() + "- " + displayPriceReceipt(productCart, i) + " $ ";
        }
        return products;
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
    public void writeReceipt(String brandName, ArrayList <Product> productCart) {
        try {
            FileWriter fileWriter = new FileWriter(brandName + " Receipt.txt");
            fileWriter.write(("-----------------Thanks for shopping at " + brandName + "-----------------"));
            fileWriter.write(displayProductReceipt(productCart));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            String sum = String.valueOf(purchase.calculatePrice(productCart));       //int
            String sumVAT = String.valueOf(purchase.calculatePrice(productCart)*0.12f); //double
            fileWriter.write("Total price will be: " + sum + " dollars \n");
            fileWriter.write("VAT 12%: " + sumVAT);
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.write("Cash received: " + String.valueOf(character.getWalletBalance() + purchase.getTotalSum()) + "\n");
            fileWriter.write("Cash back: " + (String.valueOf((character.getWalletBalance()))));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.write("\n--------------" + date + " -----------------------\n");
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
    private int displayPriceReceipt(ArrayList<Product> productCart, int i) {
        return productCart.get(i).getPrice();
    }

    public void addPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}

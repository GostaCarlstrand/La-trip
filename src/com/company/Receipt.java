package com.company;

import com.company.product.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Receipt {
    Character character;
    Market market;
    Product product;
    Purchase purchase;


    public Receipt(Market market, Product product, Character character, Purchase purchase) {
        this.market = market;
        this.product = product;
        this.character = character;
        this.purchase = purchase;

    }

    private String displayProductReceipt(ArrayList<Product> productCart) {
        String products = "";
        for (int i = 0; i < productCart.size(); i++) {
            products += "\n * " + productCart.get(i).getName() + "- " + PriceReceipt(productCart, i) + " $ ";
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
            FileWriter fileWriter = new FileWriter(brandName + "receipt.txt");
            fileWriter.write(("-----------------Thanks for shopping at " + brandName + "-----------------"));
            fileWriter.write(displayProductReceipt(productCart));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            String sum = String.valueOf(market.calculatePrice(productCart));       //int
            String sumVAT = String.valueOf(market.calculatePrice(productCart)*0.12f); //double
            fileWriter.write("Total price will be: " + sum + " dollars \n");
            fileWriter.write("VAT 12%: " + sumVAT);
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.write("Cash received: " + String.valueOf(character.getWalletBalance() + purchase.getTotalSum()) + "\n");
            fileWriter.write("Cash back: " + (String.valueOf((character.getWalletBalance()))));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
    private int PriceReceipt(ArrayList<Product> productCart, int i) {
        return productCart.get(i).getPrice();
    }


}

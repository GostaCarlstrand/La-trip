package com.company;

import com.company.product.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Receipt {
    Character character;
    Market market;
    Product product;
    File file = new File("receipt.txt");


    public Receipt(Market market, Product product, Character character) {
        this.market = market;
        this.product = product;
        this.character = character;

    }

    public void checkClass (String msg) {
        System.out.println(msg);

    }



    public String displayProductReceipt(ArrayList<Product> productCart) {
        String products = "";
        for (int i = 0; i < productCart.size(); i++) {
            products += productCart.get(i).getName();
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
            fileWriter.write("Cash received: " + String.valueOf(character.getWalletBalance() + totalSum) + "\n");
            fileWriter.write("Cash back: " + (String.valueOf((character.getWalletBalance()))));
            fileWriter.write("\n-------------------------------------------------------------------\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }


}

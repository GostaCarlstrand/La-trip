package com.company;

import com.company.product.Product;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Receipt {
    Market market;
    Product product;
    File file;


    public Receipt(Market market, Product product) {
        this.market = market;
        this.product = product;
        file = new File("receipt.txt");

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

    public String displayProductReceipt(ArrayList<Product> productCart) {
        String products = "";
        for (int i = 0; i < productCart.size(); i++) {
            products += productCart.get(i).getName();
        }
        return products;
    }

    public void writeReceipt() {
        try {
            FileWriter fileWriter = new FileWriter("receipt.txt");
            fileWriter.write(printLines());
            fileWriter.write(displayProductReceipt(market.productCart));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
    public String printLines () {
        String lines = ("---------------------" + market.name + market.description + "---------------------");
        return lines;
    }
}

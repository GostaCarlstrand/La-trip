package com.company;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

public class Market extends Location {
    public Market(String inName, String inAddress) {
        super();

        name = inName;
        address = inAddress;
        description = "The market offers a variety of different products, just be prepared to bargain";
        taxiCost = 45;
        activities = new String[]{"Fruit", "Frank's shoes"};

    }



    public void marketSwitch (int menuChoice) { //menuChoice is from locationActivities function in Location class
        boolean running = true;

        Scanner scanner = new Scanner(System.in);
        while (running) {
            switch (menuChoice) {
                case 0:                                     //1 index of the marketActivitiesList
                    welcometoAlsFruit();
                    break;

                default:
                    System.out.println("There no such activity ");
            }
        }

    }

    public void welcometoAlsFruit(){
        System.out.println("Hi, and welcome to Al's Fruit \n" +
                "what can I get you?: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
    }


    public void fruitPrice() {
        Hashtable<String, String> fruitPrice = new Hashtable<String, String>();
        fruitPrice.put("Apple", "10");
        fruitPrice.put("Pear", "20");
        System.out.println(fruitPrice);
    }



}



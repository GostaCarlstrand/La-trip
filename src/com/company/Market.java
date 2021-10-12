package com.company;

import java.util.*;

public class Market extends Location {
    public Market(String inName, String inAddress) {
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
                    fruitPrice();


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
    }


    public void fruitPrice() {
        ArrayList <String> shoppingCart;
        ArrayList <Integer> shoppingCartSum;
        Hashtable<String, Integer> fruitPrice = new Hashtable<String, Integer>();
        fruitPrice.put("Apple", 3);
        fruitPrice.put("Pear", 4);
        fruitPrice.put("Watermelon", 7);
        for (String i : fruitPrice.keySet())
            System.out.print(i + " : " + fruitPrice.get(i) + " dollars / kg\n");

        Scanner input = new Scanner(System.in);
        String menuChoice = input.nextLine().toUpperCase(Locale.ROOT);
        displayFruits();
        switch (menuChoice) {
            case ("APPLE"):



        }

    }

    public void displayFruits () {

    }

}



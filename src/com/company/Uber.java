package com.company;

import com.company.casino.*;
import com.company.casino.blackjack.Blackjack;
import com.company.product.*;


public class Uber {
    String currentUberLocation;
    Character character;
    Beach longBeach;
    Casino ceasar;
    Location airport;
    Market market;
    Product product;
    Menu menu;
    Receipt receipt;
    Purchase purchase;
    Blackjack blackjack;


    public void initGame () {

        product = new Product();
        character = new Character();
        longBeach = new Beach();
        airport = new Airport();
        menu = new Menu(character);
        blackjack = new Blackjack(character, menu);
        ceasar = new Casino(menu, blackjack);
        market = new Market(menu);
        receipt = new Receipt(character);
        purchase = new Purchase(market, character, receipt, menu);
        receipt.addPurchase(purchase);
        market.addPurchase(purchase);
        menu.initCharacter();



    }

    public void gameLoop() {
        String [] availableLocations = {ceasar.getName(),
                airport.getName(), market.getName(), longBeach.getName()};





        boolean gameRunning = true; //Variable used to determine if the main game is running

        while (gameRunning) {
            // A function where the input can be entered. Input must match on the locations in the uberLocation list
            currentUberLocation = menu.locationMenu(availableLocations);


            try {
            switch (currentUberLocation) {
                case "long beach":
                    Location.welcomeToLocation(longBeach.name, longBeach.description);
                    longBeach.longBeachActivities();

                    break;
                case "ceasar palace":
                    if (character.checkAge(character.getAge())) {
                        ceasar.casinoActivities();
                    } else {
                        System.out.println("You are to young to enter");

                    }

                    break;
                case "market":
                    //Location.welcomeToLocation(market.name, market.description);
                    //menu.displayLocationMenu(market.activities);
                    market.marketActivities();
                    break;
            }
                //gameRunning = false;
        } catch (NullPointerException e) {
                System.out.println("Enter a valid location");;
            }





    }

    }


}

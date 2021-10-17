package com.company;

import com.company.product.*;

import java.io.IOException;
import java.util.*;

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


    public void initGame () {
        menu = new Menu(market);
        product = new Product();
        character = new Character();
        longBeach = new Beach();
        ceasar = new Casino();
        airport = new Airport();
        receipt = new Receipt(market, product, character, purchase);
        purchase = new Purchase(market, character, receipt, menu);
        market = new Market(menu, receipt, character, purchase);
        receipt = new Receipt(market, product, character, purchase);
    }

    public void gameLoop() {



        String [] availableLocations = {ceasar.getName(),
                airport.getName(), market.getName(), longBeach.getName()};

        // A function where inputs needs to be made on the console. This will be saved in character variables
        //character.characterInput();



        boolean gameRunning = true; //Variable used to determine if the main game is running

        while (gameRunning) {
            // A function where the input can be entered. Input must match on the locations in the uberLocation list
            currentUberLocation = menu.locationMenu(availableLocations);

            try {
            switch (currentUberLocation) {
                case "long beach":
                    Location.welcomeToLocation(longBeach.name, longBeach.description);

                    break;
                case "short beach":
                    System.out.println("going short");
                    break;
                case "ceasar palace":


                    break;
                case "market":
                    Location.welcomeToLocation(market.name, market.description);
                    market.marketActivities(menu.chooseLocationActivity(market.activities));
                    break;
            }
                //gameRunning = false;
        } catch (NullPointerException e) {
                System.out.println("Enter a valid location");;
            }





    }

    }


}

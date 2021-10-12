package com.company;

import java.util.*;

public class Uber {
    String currentUberLocation;

    public void gameLoop() {
        Character character = new Character();              //Creating our character object
        Beach longBeach = new Beach();
        Casino ceasar = new Casino();
        Location airport = new Airport();
        Market market = new Market("Market", "Apple Rd");


        String [] avalibleLocations = {ceasar.getName(),
                airport.getName(), market.getName(), longBeach.getName()};


        // A function where inputs needs to be made on the console. This will be saved in character variables
        //character.characterInput();


        boolean gameRunning = true; //Variable used to determine if the main game is running

        while (gameRunning) {
            // A function where the input can be entered. Input must match on the locations in the uberLocation list
            currentUberLocation = Location.selectALocation(avalibleLocations);

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
                    market.marketSwitch(Location.selectLocationActivity(market.activities));



                    break;

            }

                //gameRunning = false;
        } catch (NullPointerException e) {
                e.printStackTrace();

            }




    }

    }


}

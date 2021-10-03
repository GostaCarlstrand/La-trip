package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Uber<dynamic> {
    String currentUberLocation;

    public void gameLoop() {
        Character character = new Character();              //Creating our character object
        Location mainLocation = new Location();
        Beach longBeach = new Beach("Long Beach", "California Avenue 70");
        Beach shortBeach = new Beach("Short Beach", "2Avenue");
        Casino ceasar = new Casino();
        Location airport = new Airport();
        PetStore petStore = new PetStore("Als Petstore", "Animal Rd 22");
        Market market = new Market("Market", "Apple Rd");

        longBeach.setRandomTemperature();
        String[] uberLocations = {shortBeach.getName(), longBeach.getName(), ceasar.getName(),
                airport.getName(), market.getName()};

        // A function where inputs needs to be made on the console. This will be saved in character variables
        //character.characterInput();


        boolean gameRunning = true; //Variable used to determine if the main game is running

        while (gameRunning) {
            // A function where the input can be entered. Input must match on the locations in the uberLocation list
            currentUberLocation = mainLocation.locationInput(uberLocations);

            try {
            switch (currentUberLocation.toLowerCase(Locale.ROOT)) {
                case "long beach":
                    longBeach.longBeach();
                    break;
                case "short beach":
                    System.out.println("going short");
                    break;
                case "ceasar palace":
                    System.out.println("going casino");
                    break;
                case "market":
                    market.marketActivity();
                    break;

            }

                //gameRunning = false;
        } catch (NullPointerException e) {
                e.printStackTrace();

            }




    }

    }


}

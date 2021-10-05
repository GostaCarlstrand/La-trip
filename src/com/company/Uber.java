package com.company;

import java.util.*;

public class Uber {
    String currentUberLocation;
    Location location2;

    public void gameLoop() {
        Character character = new Character();              //Creating our character object
        Location mainLocation = new Location();


        // A function where inputs needs to be made on the console. This will be saved in character variables
        character.characterInput();

        //market.fruitPrice();
        boolean gameRunning = true; //Variable used to determine if the main game is running

        while (gameRunning) {
            // A function where the input can be entered. Input must match on the locations in the uberLocation list
            //currentUberLocation = mainLocation.locationInput(uberLocations);
            //location2 = mainLocation.getLocation();
            System.out.println(mainLocation.getLocation());
            try {
            switch (currentUberLocation.toLowerCase(Locale.ROOT)) {
                case "long beach":

                    break;
                case "short beach":
                    System.out.println("going short");
                    break;
                case "ceasar palace":


                    break;
                case "market":



                    break;

            }

                //gameRunning = false;
        } catch (NullPointerException e) {
                e.printStackTrace();

            }




    }

    }


}

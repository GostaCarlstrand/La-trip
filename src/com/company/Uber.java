package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uber {
    String currentUberLocation;

    public void gameLoop() {
        Character character = new Character();              //Creating our character object
        Location startLocation = new Location("The starting point", "Hollywood Blv",
                "This is the main area", 0);
        Beach longBeach = new Beach(24, "Long Beach", "California Avenue",
                "Here you will find a white sand beach", 25); ///Creating a beach object
        Beach shortBeach = new Beach(26, "Short Beach", "Miami Rd",
                "This is a beach with lots of surfers", 20); ///Creating another beach object
        Casino ceasar = new Casino("Ceasar Palace", "Sunset Drive 70",
                "Here you can win back some money", 35);
        Location airport = new Location("Airport", "Airport Strip",
                "Here you can leave LA", 0);


        String[] uberLocations = {shortBeach.getName(), longBeach.getName(), ceasar.getName(), airport.getName()};

        // A function where inputs needs to be made on the console. This will be saved in character variables
        //character.characterInput();


        boolean gameRunning = true; //Variable used to determine if the main game is running
            while (gameRunning) {
                // A function where the input can be entered. Input must match on the locations in the uberLocation list
                currentUberLocation = startLocation.locationInput(uberLocations);
                startLocation.welcomeToLocation(currentUberLocation);

                gameRunning = false;

            }




    }
}

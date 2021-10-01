package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Uber {

    public void gameLoop() {
        Character character = new Character();              //Creating our character object
        Location startLocation = new Location("The starting point", "We are at the airport" ,
                "This is the main area", 0);
        Beach longBeach = new Beach(24, "Long Beach", "California Avenue",
                "A white sand beach", 25); ///Creating a beach object
        Beach shortBeach = new Beach(26, "Short Beach", "Miami Rd",
                "A beach with lots of surfers", 20); ///Creating another beach object
        Casino ceasar = new Casino("Ceasar Palace", "Sunset Drive 70",
                "Time to gain back some money", 35);

        String [] uberLocations = {shortBeach.getName(), longBeach.getName()};


        ceasar.playDice();

        // A function where inputs needs to be made on the console. This will be saved in character variables
        //character.characterInput();

        // A function where the input can be entered. Input must match on the locations in the uberLocation list
        //startLocation.locationInput(uberLocations, character.walletBalance);

        //character.updatedWalletBalance(longBeach.getTaxiCost());

        //startLocation.goingToMsg(startLocation.currentLocation);




        //System.out.println(character.name);
        //System.out.println(character.age);
        //System.out.println(character.walletBalance);
        //System.out.println(character.choiceOfHat);
    }
}

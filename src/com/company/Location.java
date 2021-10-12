package com.company;

import java.util.*;

public class Location {

    protected String name;                        //Name of the location
    protected String address;                     //An address to the location
    protected String description;                 //A description to the location
    protected int taxiCost;                       //What the taxi trip costs

    public String[] activities;


    public String getName() {
        return name;
    }                  // A public function to get the name of the location

    public String getAddress() {
        return address;
    }            // A public function to get the address of the location

    public int getTaxiCost() {
        return taxiCost;
    }            // A public function to get the address of the location

    public static String selectALocation(String[] uberLocation) {
        boolean running = true;             //As long as running is true the while loop will be executed
        try {                   //Try prevents the input to be of an invalid value
            while (running) {
                Scanner input = new Scanner(System.in);  //create a new scanner object
                int flag = 0;
                //Flag is created to used to determine if the menuChoice is included in the list

                System.out.println("Where in the city would you like to go?: ");
                for (int i = 0; i < uberLocation.length; i++) {
                    System.out.println((i + 1) + ". " + uberLocation[i]);
                }
                System.out.print("< ");
                String menuChoice = input.nextLine();

                //The flag will be set to 1 if there is a match. Also checks if the character still has money
                for (int i = 0; i < uberLocation.length; i++) {
                    if ((menuChoice.equalsIgnoreCase(uberLocation[i]))) {
                        flag += 1;
                        return menuChoice;
                    }
                }
                if (menuChoice.length() <= 0 || flag == 0) {
                    System.out.println("Either does the location not exist or you're out of money");

                }
                running = false;
            }
        } catch (Exception e) {
            System.out.println("ERROR: Enter a valid value");
        }

        return null;

    }

    public static void welcomeToLocation(String inName, String inDescription) {
        System.out.println("We have now arrived to " + inName);
        System.out.println(inDescription);

    }

    public static int selectLocationActivity(String[] activities) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        //Loops through the list and prints the values after each index
        for (int i = 0; i < activities.length; i++) {
            System.out.println((i + 1) + ". " + activities[i]);
        }

        String menuInput = scanner.nextLine();         //Saves the answer in the menuInput variable
        int menuChoice = 0;         //Number of index that is chosen, its zero because the function needs to return a value

        while (running) {
            for (int i = 0; i < activities.length; i++) {
                if (menuInput.equalsIgnoreCase(activities[i])) {    //check if the menu input is equal to any in the list
                    menuChoice = (i); //Will be used in the switch method
                }

            }
            running = false;
        }
        return menuChoice;
    }

}

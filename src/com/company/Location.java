package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Location {

    protected String name;                        //Name of the location
    protected String address;                     //An address to the location
    protected String description;                 //A description to the location
    protected int taxiCost;                       //What the taxi trip costs
    public String currentLocation;

    public String getName() {return name;}                  // A public function to get the name of the location
    public String getAddress() {return address;}            // A public function to get the address of the location
    public int getTaxiCost() {return taxiCost;}            // A public function to get the address of the location

     public String locationInput(String[] uberLocation) {
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
                         currentLocation = menuChoice;
                     }
                 }

                 if (currentLocation.equalsIgnoreCase("Airport")) {
                     System.out.println("Going to the airport");
                     break;
                 }
                 if (menuChoice.length() <= 0 || flag == 0) {
                     System.out.println("Either does the location not exist or you're out of money");
                     continue;
                 }
                 running = false;
             }
         } catch (Exception e) {
             System.out.println("ERROR: Enter a valid value");
         }
         return currentLocation;

     }

     public void welcomeToLocation(String inName, String inDescription) {
         System.out.println("We have now arrived to " + inName);
         System.out.println(inDescription);

     }
}

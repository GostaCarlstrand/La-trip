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


    public static void welcomeToLocation(String inName, String inDescription) {
        System.out.println("We have now arrived to " + inName);
        System.out.println(inDescription);

    }
}

package com.company;

import java.util.Scanner;

public class Menu {
    Market market;

    public Menu (Market market) {
        this.market = market;
    }

    public String menuInput() {
            Scanner input = new Scanner(System.in);  //create a new scanner object
            String menuInput = input.nextLine();
            return menuInput;
    }

    private void displayLocationMenu(String[] uberLocation) {
        System.out.println("What would you like to do?: ");
        for (int i = 0; i < uberLocation.length; i++) {
            System.out.println((i + 1) + ". " + uberLocation[i]);
        }
        System.out.print("< ");
    }

    public String locationMenu(String[] uberLocation) {
        displayLocationMenu(uberLocation);
        String menuChoice = menuInput();
        return menuChoice;
    }

    public int chooseLocationActivity(String[] activities) {
        displayLocationMenu(activities);
        String menuChoice = menuInput();
        int menuInteger = -1;
            for (int i = 0; i < activities.length; i++) {
                if (menuChoice.equalsIgnoreCase(activities[i])) {    //check if the menu input is equal to any in the list
                    menuInteger = (i); //Will be used in the switch method
                }
            }
        return menuInteger;
    }



}



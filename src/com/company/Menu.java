package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    Random random = new Random();
    Character character;

    public Menu (Character character) {
        this.character = character;
    }

    public void initCharacter() {                     // A function where player inputs their character values
        boolean running = true;
        while (running) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter name: ");
                character.name = input.nextLine();
                System.out.print("Enter age: ");
                character.setAge(input.nextInt());
                System.out.print("Enter amount of cash: ");
                character.initWalletBalance(input.nextInt());
                running = false;

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Enter a valid value");
                continue;

            }
        }
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

    public String generateRandomGreeting() {
        String [] greetings = {"Hello there ", "Hi, ", "Hi my friend, ", "Yo bud, ", "!Hola amigo¡ ", "Howdy partner, "};
        int randomIndexNumber = random.nextInt(greetings.length);
        return greetings[randomIndexNumber];
    }

    public void welcomeToVenueMessage (String brandName) {
        System.out.println(generateRandomGreeting() + "and welcome to " +  brandName + "\n" +
                "what can I get you?: \n" +
                "1. Leave store \n" +
                "2. Remove any product \n" +
                "3. Remove all objects \n" +
                "4. Go to cashier"
        );
    }




}



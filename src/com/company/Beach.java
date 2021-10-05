package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Beach extends Location{
    public int temperature;
    public Beach(String inName, String inAddress) {

        name = inName;
        address = inAddress;
        description = "A beautiful beach";
        taxiCost = 50;
        int temperature;
        String [] activities = {"Take a swim", "Go for a walk", "Leave"};

    }


    public void longBeach() {
        boolean longBeachRunning = true;
            while (longBeachRunning) {
                welcomeToLocation(name,description);
                longBeachActivities();
                longBeachRunning = false;


        }
    }

    public void longBeachActivities() {
        //Creates a list with things to do
        String [] activities = {"Take a swim", "Go for a walk", "Leave"};
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        //Loops through the list and prints the values after each index
        for (int i = 0; i < activities.length; i ++) {
            System.out.println((i+1) + ". " + activities[i]);
        }
        while (running) {
        System.out.print("What would you like to do?: ");
        String menuInput = scanner.nextLine();
        setRandomTemperature(); // A function that sets temperature to a random int between the value 18-26

        switch (menuInput.toLowerCase(Locale.ROOT).trim()) {
            case "go for a walk":
                System.out.println("Going for a walk in the nice weather");
                break;

            case "leave":
                System.out.println("Going back to main");
                running = false;
                break;

            case "take a swim":
                    if (temperature <= 20) {        //if temp is low, player is given an option to not swim
                        System.out.println("The water is only " + temperature + "degrees cold \n" +
                                "\"Are you sure? Yes/No" );
                        Scanner input = new Scanner(System.in);
                        String decision = input.nextLine();
                        if (decision.equalsIgnoreCase("yes")) {
                            System.out.println("Going for a swim in cold the ocean");
                        }else if(decision.equalsIgnoreCase("no")) {
                            break;
                        }
            }else if (temperature > 20) {
                        System.out.println("Going for a swim in the warm water");
                        break;
                    }
             }
        }


    }

    public int setRandomTemperature() {
        Random random = new Random();
        temperature = random.nextInt(18,26);
        return temperature;
    }

    public void newLongBeachActivities() {


    }

}

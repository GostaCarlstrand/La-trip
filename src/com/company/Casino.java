package com.company;

import java.util.Random;
import java.util.Scanner;


public class Casino extends Location {
    public Casino(){
    name = "Ceasar Palace";
    address = "Las Vegas Blvd";
    description = "Here you can win some dollars back";
    taxiCost = 45;

    }

    public void playDice () {
        boolean running = true;
        int guess;
        try {
            while (running) {
                Random randomNumber = new Random();
                System.out.println("Hi, choose a number between 1-6 and much you would like to bet, \n" +
            "IF YOU WIN: Your bet will be multiplied with the number you guessed \n" +
            "IF YOU LOOSE: You will loose amount*(number in percentage)");
                Scanner scanner = new Scanner(System.in);
                System.out.print(" >");
                guess = scanner.nextInt();

                if (guess == ((int)(randomNumber.nextDouble()*7))) {
                    System.out.println("Correct");
                    running=false;
                }






            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Character {
    String name;
    private int age;
    private int walletBalance;
    String[] hats = {"Top Hat", "Cap", "Fedora", "Strawhat"};
    public String choiceOfHat;

    public String characterInput() {                     // A function where player inputs their character values
        boolean running = true;
        while (running) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter name: ");
                name = input.nextLine();
                System.out.print("Enter age: ");
                age = input.nextInt();
                System.out.print("Enter amount of cash: ");
                walletBalance = input.nextInt();
                System.out.println("What hat do you want? : ");
                for (int i = 0; i < hats.length; i++) {
                    System.out.println((i + 1) + ". " + hats[i]);
                }
                System.out.println("< ");
                int choice = input.nextInt(); //variable used to declare what menu choice
                choiceOfHat = hats[choice - 1];
                running = false;

            } catch (InputMismatchException e) {
                System.out.println("ERROR: Enter a valid value");
                continue;

            }
        }
        return choiceOfHat;
    }

    public int getAge() {
        return age;
    }

    public int getWalletBalance() {
        return walletBalance;
    }
    public boolean checkCharacterHasMoney(int currentWalletBalance, int totalPrice) {
        if (currentWalletBalance >= totalPrice) {
            return true;
        }
        return false;
    }

    public int updateWalletBalance(int totalPrice) {
        walletBalance = walletBalance - totalPrice;
        return walletBalance;
    }

    public boolean checkAgeToPurchase(int age) {
        if (age < 21) {
            return false;
        } else {
            return true;
        }
    }
}



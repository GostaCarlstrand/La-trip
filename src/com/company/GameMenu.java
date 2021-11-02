package com.company;

import java.util.Scanner;

public class GameMenu {

    private static int intInput(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static String input(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String playAgain() {
        System.out.println("Do you want you play again? ");
        System.out.println("Type yes/no");
        return input();
    }

    public static int placeBet() {
        System.out.print("Place your bet: ");
        return intInput();
    }

    public static int repayBet(int bet, int walletBalance) {
        return walletBalance + 2*bet;
    }
}

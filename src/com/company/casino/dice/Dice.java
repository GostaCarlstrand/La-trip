package com.company.casino.dice;

import com.company.*;
import com.company.Character;

import java.util.Random;

public class Dice {
    Character character;
    Menu menu;
    private int guessedNumber;
    private int bet;
    int diceSize = 6;


    public Dice(Menu menu, Character character) {
        this.menu = menu;
        this.character = character;
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }
    public void setGuessedNumber(int guessedNumber) {
        this.guessedNumber = guessedNumber;
    }


    private void initDiceGame() {
        System.out.println("Welcome to roll some dice");
        System.out.println("You have: " + character.getWalletBalance() + " dollars");
        bet = GameMenu.placeBet();
        character.reduceWalletBalance(bet);
    }

    public boolean guessNumber(int inputNumberGuess) {
        if (inputNumberGuess > diceSize) {
            System.out.println("Guess can't be larger than the dice");
            return false;
        }
        setGuessedNumber(inputNumberGuess);
        return true;
    }

    private void diceGame() {
        while (true) {
            Random random = new Random();
            int randomDiceNumber = random.nextInt(1, 6);
            if (getGuessedNumber() != randomDiceNumber) {
                System.out.println("You lost, the correct number was " + randomDiceNumber);
            } else {
                System.out.println("You guessed the correct number");
                GameMenu.repayBet(character.getWalletBalance(), bet);
            }
            break;
        }
    }
    public boolean playAgain(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    public void gameLoop() {
        while (true) {
        initDiceGame();
        boolean guessIsValid = false;
        while(!guessIsValid){
            System.out.print("Which number on the dice?: ");
            guessIsValid =  guessNumber(menu.menuIntInput());
        }
        diceGame();
            if (!playAgain(GameMenu.playAgain())) {
                break;
            }
        }
    }
}

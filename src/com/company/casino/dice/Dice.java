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

    public void guessNumber() {
        System.out.print("Which number on the dice?: ");
        int inputNumberGuess = menu.menuIntInput();
        if (inputNumberGuess > diceSize) {
            System.out.println("Guess can't be larger than the dice");
            guessNumber();
        }
        setGuessedNumber(inputNumberGuess);
    }

    private void diceGame() {
        Random random = new Random();
        int randomDiceNumber = random.nextInt(diceSize+1);
        if (getGuessedNumber() != randomDiceNumber){
            System.out.println("You lost");
            if (GameMenu.playAgain().equalsIgnoreCase("yes")){
                gameLoop();
            }
        } else {
            System.out.println("You guessed the correct number");
            GameMenu.repayBet(character.getWalletBalance(), bet);
        }
    }

    public void gameLoop() {
        initDiceGame();
        guessNumber();
        diceGame();
    }
}

package com.company.casino;

import com.company.Location;
import com.company.*;
import com.company.casino.blackjack.*;
import com.company.casino.dice.*;

public class Casino extends Location {
    Menu menu;
    Blackjack blackjack;
    Dice diceGame;
    String [] acceptedPhrasesBlackjack = {"Blackjack", "black", "jack", "blckjack"};
    String [] acceptedPhrasesDiceGame = {"Dice", "play dice", "dice game", "dices"};

    public Casino(Menu menu, Blackjack blackjack, Dice diceGame){
    name = "Ceasar Palace";
    address = "Las Vegas Blvd";
    description = "Here you can win some dollars back";
    taxiCost = 45;
    activities = new String[]{"Blackjack", "Dice", "Leave"};
    this.menu = menu;
    this.blackjack = blackjack;
    this.diceGame = diceGame;
    }
    public void casinoActivities() {
        Location.welcomeToLocation(name, description);
        menu.displayLocationMenu(activities);
        boolean running = true;
        String menuChoice = menu.menuInput();
        while (running){
            if (menu.acceptedInputs(menuChoice, acceptedPhrasesBlackjack)) {
                blackjack.gameLoop();
                break;
            }else if (menu.acceptedInputs(menuChoice, acceptedPhrasesDiceGame)) {
                diceGame.gameLoop();
                break;
            }else if (menu.acceptedInputs(menuChoice, menu.acceptedExitPhrases)){
                break;
            }
        }
    }
}

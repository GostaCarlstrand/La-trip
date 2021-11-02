package com.company.casino;

import com.company.Location;
import com.company.*;
import com.company.casino.blackjack.*;


public class Casino extends Location {
    Menu menu;
    Blackjack blackjack;
    String [] acceptedPhrasesBlackjack = {"Blackjack", "black", "jack", "blckjack"};


    public Casino(Menu menu, Blackjack blackjack){
    name = "Ceasar Palace";
    address = "Las Vegas Blvd";
    description = "Here you can win some dollars back";
    taxiCost = 45;
    activities = new String[]{"Blackjack", "Dice", "Slots", "Leave"};

    this.menu = menu;
    this.blackjack = blackjack;
    }

    public void casinoActivities() {
        Location.welcomeToLocation(name, description);
        menu.displayLocationMenu(activities);
        boolean running = true;
        String menuChoice = menu.menuInput();
        while (running){
            if (menu.acceptedInputs(menuChoice, acceptedPhrasesBlackjack)) {
                blackjack.gameLoop();
                running = false;
                break;
            } else if (menu.acceptedInputs(menuChoice, menu.acceptedExitPhrases)){
                running = false;
                break;
            }
        }



        }




}

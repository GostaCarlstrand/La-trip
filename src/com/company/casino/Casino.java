package com.company.casino;

import com.company.Location;
import com.company.Menu;
import com.company.casino.blackjack.*;


public class Casino extends Location {
    Menu menu;
    Blackjack blackjack;


    public Casino(Menu menu, Blackjack blackjack){
    name = "Ceasar Palace";
    address = "Las Vegas Blvd";
    description = "Here you can win some dollars back";
    taxiCost = 45;
    activities = new String[]{"Blackjack", "Dice", "Slots"};
    this.menu = menu;
    this.blackjack = blackjack;
    }

    public void casinoActivities() {
        int menuChoice = menu.chooseLocationActivity(activities);
        switch (menuChoice) {
            case 0:
                blackjack.gameLoop();
        }
    }



}

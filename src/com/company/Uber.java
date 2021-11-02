package com.company;

import com.company.casino.*;
import com.company.casino.blackjack.Blackjack;
import com.company.casino.dice.Dice;
import com.company.product.*;

public class Uber {
    String currentUberLocation;
    Character character;
    Beach longBeach;
    Casino ceasar;
    Location location;
    Location airport;
    Market market;
    Product product;
    Menu menu;
    Receipt receipt;
    Purchase purchase;
    Blackjack blackjack;
    Dice dice;

    public void initGame () {

        product = new Product();
        character = new Character();
        longBeach = new Beach();
        location = new Location();
        airport = new Airport();
        menu = new Menu(character);
        dice = new Dice(menu, character);
        blackjack = new Blackjack(character, menu);
        ceasar = new Casino(menu, blackjack, dice);
        market = new Market(menu);
        receipt = new Receipt(character);
        purchase = new Purchase(market, character, receipt, menu);
        receipt.addPurchase(purchase);
        market.addPurchase(purchase);
        menu.initCharacter();
    }


    public void gameLoop() {
        String [] availableLocations = {ceasar.getName(),
                airport.getName(), market.getName(), longBeach.getName()};

        boolean gameRunning = true;
        while (gameRunning) {
            currentUberLocation = menu.locationMenu(availableLocations);
            if (menu.acceptedInputs(currentUberLocation, location.acceptedCasinoPhrases)){
                if (character.checkAge(character.getAge())) {
                    ceasar.casinoActivities();
                } else {
                    System.out.println("You are to young to enter");
                }
            }
            else if (menu.acceptedInputs(currentUberLocation, location.acceptedAirportPhrases)){
                System.out.println("Taking you home");
                break;
            }
            else if(menu.acceptedInputs(currentUberLocation, location.acceptedMarketPhrases)){
                market.marketActivities();
            }
            else if(menu.acceptedInputs(currentUberLocation, location.acceptedBeachPhrases)){
                longBeach.longBeachActivities();
            }
        }
    }
}

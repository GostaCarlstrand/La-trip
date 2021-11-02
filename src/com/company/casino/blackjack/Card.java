package com.company.casino.blackjack;

public class Card {
    String name;
    String cardSuit;
    int value;
    boolean isAce = false;

    public Card(String cardSuit, int value) {
        this.cardSuit = cardSuit;
        this.value = value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getCardSuit () {
        return cardSuit;
    }
    public String displayCard() {
        String cardName = getName() + " of " + getCardSuit();
        return cardName;
    }
}



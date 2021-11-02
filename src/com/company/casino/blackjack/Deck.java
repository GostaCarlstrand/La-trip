
package com.company.casino.blackjack;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    Card card;
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    Card[][] deckOfCards = new Card[4][13];
    ArrayList<Card> sortedDeckOfCards = new ArrayList<Card>();
    String[] names = {"Jack", "Queen", "King", "Ace"};

    public void initCards() {
        for (int i = 0; i <= 3; i++) {
            String suit = suits[i];
            for (int a = 0; a < 9; a++) {
                card = new Card(suit, (a + 2));      //assign suit and value (index + 2)
                card.setName(String.valueOf(a + 2));  ////assign name to be displayed (index + 2)
                deckOfCards[i][a] = card;         //place in deckOfCars [i] = suit , [a-1] = index
            }
            int count = 0;      //To reach index of name list
            for (int a = 9; a < 13; a++) {
                card = new Card(suit, (10));
                card.setName(names[count]);
                deckOfCards[i][a] = card;
                count += 1;
                if (a == 12) {
                    card.isAce = true;
                    card.setValue(11);
                }
            }
        }
    }
    public void sortArrayDeckOfCards(Card[][] deckOfCard) { //From multidimensional to single arraylist
        for (int i = 0; i < deckOfCard.length; i++) {
            for (int a = 0; a < deckOfCard[i].length; a++) {
                sortedDeckOfCards.add(deckOfCard[i][a]);
            }
        }
    }
    public void shuffleDeckOfCards() {
        Collections.shuffle(sortedDeckOfCards);
    }
}


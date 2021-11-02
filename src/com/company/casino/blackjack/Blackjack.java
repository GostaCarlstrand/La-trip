package com.company.casino.blackjack;
import com.company.Character;
import com.company.Menu;

public class Blackjack {
    Menu menu;
    Character character;
    BlackjackMenu blackjackmenu;
    Deck deck;
    Player player;
    Player dealer;
    int count = 3; //Used to increase the amount of cards that has been dealt
    int bet;
    boolean hasPlayerWonTheGame;
    boolean gameIsTie;

    public Blackjack(Character character, Menu menu) {
        this.character = character;
        this.menu = menu;
    }
    public void initGame() {
        bet = 0;
        count = 3;
        deck = new Deck();
        player = new Player();
        dealer = new Player();
        blackjackmenu = new BlackjackMenu();
        hasPlayerWonTheGame = false;
        gameIsTie = false;
        deck.initCards();           //Creating the objects cards
        deck.sortArrayDeckOfCards(deck.deckOfCards);//Creating a single array with all cards in order
        deck.shuffleDeckOfCards();

    }
    public void gameLoop() {
    boolean blackjackRunning = true;
        while (blackjackRunning) {
            initGame();
            deck.shuffleDeckOfCards();
            System.out.println("You have " + character.getWalletBalance());
            System.out.print("How much are you willing to bet?: ");
            bet = blackjackmenu.placeBet();
            if (!character.checkCharacterHasMoney(bet)) {
                System.out.println("You do not have money enough to place that bet");
                break;
            }
            character.reduceWalletBalance(bet);
            dealStartHand();
            gamePlaying();
            displayGameResult();
            if (!wantToPlayAgain()) {
                break;
            }
        }
    }
    public void returnBet() {
        System.out.println("This is how much you win: "+ (bet*2) + " dollars");
        character.increaseWalletBalance((bet*2)); //If game is a win, 2x bet is repaid
    }
    public void returnMoney(){
        character.increaseWalletBalance(bet); //If game is draw, bet is repaid
    }
    public void dealStartHand() {
        player.currentHand.add(deck.sortedDeckOfCards.get(0));
        dealer.currentHand.add(deck.sortedDeckOfCards.get(1));
        player.currentHand.add(deck.sortedDeckOfCards.get(2));
        player.currentHandValue = player.currentHand.get(0).value + player.currentHand.get(1).value;
        dealer.currentHandValue = dealer.currentHand.get(0).value;
    }
    public void dealAnotherCard(Player player) {
        player.currentHand.add(deck.sortedDeckOfCards.get(count));  //Take next card from deck
        player.currentHandValue += deck.sortedDeckOfCards.get(count).value;
        if (player.currentHandValue > 21 && deck.sortedDeckOfCards.get(count).isAce){
            player.currentHandValue -= 10;      //Reduces 10 to the value if next draw is Ace && total value is > 21
        }
        count += 1;
    }
    public void compareHands() {
        if (dealer.currentHandValue > 21) {     //Has dealer busted
            hasPlayerWonTheGame = true;
        } else if(player.currentHandValue > dealer.currentHandValue) {
            hasPlayerWonTheGame = true;
        } else if (dealer.currentHandValue == 20 && player.currentHandValue == 20) {
            gameIsTie = true;
        } else if (dealer.currentHandValue == 21 && player.currentHandValue == 21) {
            gameIsTie = true;
        }
    }
    public void displayGameResult() {
        if (gameIsTie) {
            System.out.println("There is a draw, you got your money back");
            returnMoney();
        } else if(!hasPlayerWonTheGame){
            System.out.println("Sorry, you lost this game");
        } else if (hasPlayerWonTheGame) {
            System.out.println("Congratulations, you have won");
            returnBet();
        }
    }
    public void playersTurn() {
        boolean playersTurn = true;
        while (playersTurn) {
            System.out.println("This is your hand: ");
            player.displayCurrentHand();
            System.out.println("You have " + player.currentHandValue);
            if (player.currentHandValue == 21 && (!dealer.currentHand.get(0).isAce)) {
                System.out.println("BLACKJACK, you have won " + bet*2 + " dollars");
                character.increaseWalletBalance(bet*2);
                wantToPlayAgain();
            }
            String menuChoice = blackjackmenu.menuInput();
            if (menuChoice.equalsIgnoreCase("Take")) {
                dealAnotherCard(player);
                System.out.println("Next card is: " + deck.sortedDeckOfCards.get(count-1).displayCard());

                if (player.currentHandValue > 21) {
                    System.out.println("Oops, you got, " + player.currentHandValue + " the game is over");
                    wantToPlayAgain();
                } else if (player.currentHandValue == 21) {
                    System.out.println("You got 21");
                    break;
                }
            }
            else if (menuChoice.equalsIgnoreCase("Stop")) {
                break;
            }
            continue;
        }
    }
    public void dealersTurn() {
        System.out.println("Dealer has ");
        dealer.displayCurrentHand();
        boolean dealerRunning = true;
        while (dealerRunning) {
            dealAnotherCard(dealer);
            System.out.println("Next card is: " + deck.sortedDeckOfCards.get(count-1).displayCard());
            if (dealer.currentHandValue >= 17) {
                System.out.println("Dealer stops at: " + dealer.currentHandValue);
                break;
            }
        }
    }
    public boolean wantToPlayAgain() {
        String menuChoice = blackjackmenu.leaveGame();
        if (menuChoice.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Ok, thanks for playing Blackjack with me");
            return false;
        }
    }
    public void gamePlaying() {
        playersTurn();
        dealersTurn();
        compareHands();
    }
}


package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Main {

    static int cardValue = 0;


    public static void showCards(Player P) {
        for (Card card : P.getCards()) {
            System.out.println(card.getDescription());

        }
    }

    public static void displayName(Player P) {
        System.out.println(P.getName());
    }

    public static void displayScore(Player P) {
        System.out.println(P.getTotalPoints());
    }

    //--Assuming that the one close to 21 wins 
    public static String againstDealer(Player player1, Player dealer) {
        int playerPoints = player1.getTotalPoints();
        int dealerPoints = dealer.getTotalPoints();
        int playerCardsInHand = player1.getCards().length;
        int dealerCardsInHand = dealer.getCards().length;

        String dealerWins = "The Dealer (" + dealerPoints + ") has won against " + player1.getName() + " (" + playerPoints + ")";
        String playerWins = player1.getName() + " (" + playerPoints + ") has won against the dealer (" + dealerPoints + ")";
        String tie = player1.getName() + " and the dealer have tied at " + playerPoints;

        // Automatic win for the player if they have 5 cards and <= 21
        if (playerCardsInHand == 5 && playerPoints <= 21) {
            return playerWins;
        }

        // Check for busts (over 21)
        if (playerPoints > 21 && dealerPoints > 21) {
            // Both bust: the one with the lower score wins
            if (playerPoints < dealerPoints) {
                return playerWins; // Dealer has a worse bust
            } else if (dealerPoints < playerPoints) {
                return dealerWins; // Player has a worse bust
            } else {
                return tie; // Both busted with the same score
            }
        } else if (playerPoints > 21) {
            // Player busts, dealer wins
            return dealerWins;
        } else if (dealerPoints > 21) {
            // Dealer busts, player wins
            return playerWins;
        }

        // If neither busts, check for exact 21
        if (playerPoints == 21 && dealerPoints == 21) {
            return tie;
        } else if (playerPoints == 21) {
            return playerWins;
        } else if (dealerPoints == 21) {
            return dealerWins;
        }

        // Neither busted or got 21, compare points
        if (playerPoints > dealerPoints) {
            return playerWins;
        } else if (dealerPoints > playerPoints) {
            return dealerWins;
        } else {
            return tie;
        }
    }

    //---


    public static void main(String[] args) {
        // here we will populate the deck of cards making sure that there won't be any duplicates
        HashSet<Card> Deck = new HashSet<>();
        // The Deck should contain 13 cards of each shape
        try { 
        	int possibleNumOfCars = Card.Values.length * Card.shapes.length;
	        while (Deck.size() < possibleNumOfCars) {
	            Card newCardNow = new Card();
	            Deck.add(newCardNow);
	        }
        }catch(NullPointerException e) {}
        
        Card[] AllCardsforGame = new Card[Deck.size()];
        Deck.toArray(AllCardsforGame);// We have successfully populated the AllCards
        HashSet<Card> taken = new HashSet<Card>();
//        System.out.println("Start Test of Deck");
//        System.out.println("Consist of "+ Deck.size()+ " number of cards");
//        for(Card c: Deck) {
//        	System.out.println(c.getDescription());
//        }
//        System.out.println("End Test of Deck");
//        System.out.println("============================================================================================");
//        System.out.println("Start Test of AllCardsforGame");
//        System.out.println("Consist of "+ AllCardsforGame.length+ " number of cards");
//        for(Card c: AllCardsforGame) {
//        	System.out.println(c.getDescription());
//        }
//        System.out.println("End Test of AllCardsforGame");
//        System.out.println("============================================================================================");
        System.out.println("Welcome to BlackJack 21  ");

        Player Dealer = new Player("Dealer");
        /*Card[] DealerCards = {
        		new Card("Jack", "Spades"),
        		new Card("Nine", "Hearts")
        };
        Dealer.allocateCards(DealerCards);
        
        *///DealCardstToPlayer(Dealer, AllCardsforGame, taken);

        Dealer.allocateCards(DealCardstToPlayer(Dealer, AllCardsforGame, taken));
        displayName(Dealer);
        showCards(Dealer);
        displayScore(Dealer);

        Player Billy = new Player("Billy");
        /*Card[] BillyCards = {
        		new Card("Two", "Spades"),
        		new Card("Two", "Diamonds"),
        		new Card("Two", "Hearts"),
        		new Card("Four", "Diamonds"),
        		new Card("Five", "Clubs")
        };
        Billy.allocateCards(BillyCards);
        */
        //DealCardstToPlayer(Billy,AllCardsforGame, taken);

        Billy.allocateCards(DealCardstToPlayer(Billy, AllCardsforGame, taken));
        displayName(Billy);
        showCards(Billy);
        displayScore(Billy);

        Player Lemmy = new Player("Lemmy");
       /* Card[] LemmyCards = {
        		new Card("Ace", "Spades"),
        		new Card("Seven", "Hearts"),
        		new Card("Ace", "Diamonds")
        };
        Lemmy.allocateCards(LemmyCards);
        *///DealCardstToPlayer(Lemmy,AllCardsforGame, taken);

        Lemmy.allocateCards(DealCardstToPlayer(Lemmy, AllCardsforGame, taken));
        displayName(Lemmy);
        showCards(Lemmy);
        displayScore(Lemmy);

        Player Andrew = new Player("Andrew");
        /*Card[] AndrewCards = {
        		new Card("King", "Diamonds"),
        		new Card("Four", "Spades"),
        		new Card("Four", "Clubs")
        };
        Andrew.allocateCards(AndrewCards);
      */ //DealCardstToPlayer(Andrew,AllCardsforGame, taken);
        Andrew.allocateCards(DealCardstToPlayer(Andrew, AllCardsforGame, taken));
        displayName(Andrew);
        showCards(Andrew);
        displayScore(Andrew);

        Player Carla = new Player("Carla");
        /*Card[] CarlaCards = {
        		new Card("Queen", "Clubs"),
        		new Card("Six", "Spades"),
        		new Card("Nine", "Diamonds")
        };
        Carla.allocateCards(CarlaCards);*/
        
        Carla.allocateCards(DealCardstToPlayer(Carla, AllCardsforGame, taken));
        //DealCardstToPlayer(Carla,AllCardsforGame, taken);
        displayName(Carla);
        showCards(Carla);
        displayScore(Carla);
        System.out.println(" ");
        System.out.println(againstDealer(Billy, Dealer));
        System.out.println(againstDealer(Lemmy, Dealer));
        System.out.println(againstDealer(Andrew, Dealer));
        System.out.println(againstDealer(Carla, Dealer));

    }

    private static Card[] DealCardstToPlayer(Player P, Card[] AllCard, HashSet<Card> taken) {
    	//System.out.println("Start Test of "+P.getName()+  "cards" );
        /*Deal Cards to player
        Maximum number of cards a player can have is 5*/
        int[] numberOfCards = {1, 2, 3, 4, 5};
        int max = numberOfCards.length;
        int min = 2; // According to the rules of BlackJack no player can have less than two cards
        Random choice = new Random();
        int numForPlayer = choice.nextInt((max-min)+1) +min;// number of cards for Player should have
       // System.out.println("Number of cards to be allocated to "+P.getName()+"  is " +  numForPlayer );
        
        List<Card> cardHolder = new ArrayList<>();
        

        Card allocateCard = AllCard[choice.nextInt(AllCard.length)];
        //System.out.println("Card to be allocated to "+P.getName()+"  is " +  allocateCard.getDescription() );
        int currentNumInHand = cardHolder.size();
        //Take cards from AllCards
        while (currentNumInHand < numForPlayer){
            if (!taken.contains(allocateCard)) {// this will ensure that each player has unique cards
            	cardHolder.add(allocateCard);
                taken.add(allocateCard);
                currentNumInHand = cardHolder.size();
            } else {
                allocateCard = AllCard[choice.nextInt(AllCard.length)];
            }
        }
        Card[] Playercards = new Card[cardHolder.size()];
        
        Playercards= cardHolder.toArray(Playercards);
        //=======Test
//        System.out.println("Consist of "+ Playercards.length+ " number of cards");
//        for(Card c: Playercards) {
//        	System.out.println(c.getDescription());
//        }
//        System.out.println("End Test of "+P.getName()+  "cards" );
//        System.out.println("============================================================================================");
        
    return Playercards;// This has a set of unique cards to the rest of the players

    }

}


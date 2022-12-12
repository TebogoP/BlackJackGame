package com.company;

public class Player {
    private String name;
    private Card[] cards;
    private int points=0;
    public void allocateCards(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public int getTotalPoints() {
    	if (points==0){
    		pointsCal();
    	}
        return points;
    }
    private void pointsCal() {
    	for (Card card : cards) {
            points += card.getValue();
        }

        if (points>21){
            int count =0;
            for (Card i: cards) {
                if (i.getsValue().equals("Ace")){
                    count++; //counting how many Ace's does the player have in their hand
                }
            }
            /*this will ensure that if the player
             has more than once Ace in had but isn't
             over 21 to allow a change in Ace value from 11 to 1
            */
            if (count>0){
                do {
                    points -= 10;
                    count--;
                }while(points>21 && count>0);
            }

        }
    	
    }

    public Player(String name) {
        setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

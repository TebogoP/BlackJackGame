package com.company;

import java.util.HashMap;
import java.util.Random;

public class Card {
    private String description;
    private String shape; //Clubs , Diamonds, Hearts, Spades
    private String sValue;

    static String []shapes = {"Clubs" , "Diamonds", "Hearts", "Spades"};
    static String []Values = {"Ace" , "Two", "Three", "Four", "Five" , "Six", "Seven", "Eight", "Nine" , "Ten", "Jack", "Queen","King"};
    //static int []cardValueHolder = {11 , 2, 3, 4, 5 , 6, 7, 8, 9 , 10};
    Random choice= new Random();

    HashMap<String, Integer> cardValueHolder = new HashMap<String,Integer>();
   
    
    /*cardValueHolder.put("Ace",11);
	cardValueHolder.put("Two",2);
	cardValueHolder.put("Three",3);
	cardValueHolder.put("Four",4);
	cardValueHolder.put("Five" ,5);
	cardValueHolder.put("Six",6);
	cardValueHolder.put("Seven",7);
	cardValueHolder.put("Eight",8);
	cardValueHolder.put("Nine" , 9);
	cardValueHolder.put("Ten",10); //"Jack" "Queen" "King" have the same value
*/


//Normal 2,3,4,5,6,7,8,9 cards

    //Special A, J, Q, K cards
    public Card() {
        int shapeChoice = choice.nextInt(shapes.length);
        setShape(shapes[shapeChoice]);

        int cardValue = choice.nextInt(Values.length);
        setValue(Values[cardValue].trim());

        setDescription(sValue + " of " +getShape());

    }
    public Card(String sValues, String shapes) {
    	setShape(shapes);
    	setValue(sValues);
    	setDescription(sValue + " of " +getShape());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    /*public int getValue() {
        if (sValue.equals("Jack") || sValue.equals("Queen") || sValue.equals("King")){
            return cardValueHolder.get("Ten");
        }
        return cardValueHolder.get(sValue);

    }*/
    
    public int getValue() {
    	int val=0;
    	switch(sValue) {
	    	case "Jack":
	    		val= 10;
	    		break;
	    	case "Queen":
	    		val= 10;
	    		break;
	    	case "King":
	    		val= 10;
	    		break;
	    		
	    	case "Ten":
	    		val= 10;
	    		break;
	    	case "Nine":
	    		val= 9;
	    		break;
	    	case "Eight":
	    		val= 8;
	    		break;
	    	case "Seven":
	    		val= 7;
	    		break;
	    	case "Six":
	    		val= 6;
	    		break;
	    	case "Five":
	    		val= 5;
	    		break;
	    	case "Four":
	    		val= 4;
	    		break;
	    	case "Three":
	    		val= 3;
	    		break;
	    	case "Two":
	    		val= 2;
	    		break;
	    	case "Ace":
	    		val= 11;
	    		break;
	    	default:
	    		val= 0;
	    		break;
    	}
    	return val;
    	
    }
    
    public String getsValue(){
        return sValue;
    }


    public void setValue(String value) {
        this.sValue = value;
    }
}

package com.pluralsight;

public class Card {

    private final String suit;
    private final String value;
    private boolean faceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
    }

    public String getSuit() {
        if (faceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        if (faceUp){
            return value;
        } else {
            return "#";
        }
    }
}

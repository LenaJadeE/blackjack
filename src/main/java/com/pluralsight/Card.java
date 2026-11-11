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
        if (faceUp) {
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        if (faceUp) {
            if (value.equals("A")) {
                return 11;
            }

            if (value.equals("K")) {
                return 10;
            }

            if (value.equals("Q")) {
                return 10;
            }

            if (value.equals("J")) {
                return 10;
            }
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void flip() {
        faceUp = !faceUp;
    }
}

package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void deal(Card card) {
        if (!card.isFaceUp()) {
            card.flip();
        }
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    public int getValue() {
        int value = 0;

        for (Card card : cards) {
            card.flip();
            value += card.getPointValue();
            card.flip();
        }

        return value;
    }

    public String describe() {
        String text = "";

        for (Card card : cards) {
            card.flip();
            text += card.getValue() + " of " + card.getSuit() + "   ";
            card.flip();
        }

        return text;
    }
}

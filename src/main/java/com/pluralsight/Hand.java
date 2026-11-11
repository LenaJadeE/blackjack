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
            value += card.getPointValue();
        }

        return value;
    }

    public String describe() {
        StringBuilder text = new StringBuilder();

        for (Card card : cards) {
            text.append(card.getValue()).append(" of ").append(card.getSuit()).append("   ");
        }

        return text.toString();
    }
}

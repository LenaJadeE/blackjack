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
        int aces = 0;

        for (Card card : cards) {
            value += card.getPointValue();

            if (card.getValue().equals("A")) {
                aces++;
            }
        }

        while (aces > 0) {
            if (value > 21) {
                value -= 10;
            }
            aces--;
        }

        return value;
    }

    public String describe() {
        StringBuilder text = new StringBuilder();

        for (Card card : cards) {
            text.append(card.getDisplay());text.append("   ");
        }

        return text.toString();
    }
}

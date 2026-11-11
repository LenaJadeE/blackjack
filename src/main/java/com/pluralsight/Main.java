package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many players? ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Name of player " + i + ": ");
            String name = scanner.nextLine();
            Player player = new Player(name);
            players.add(player);
        }

        Deck deck = new Deck();
        deck.shuffle();

        for (int round = 0; round < 2; round++) {
            for (Player player : players) {
                Card card = deck.deal();
                player.getHand().deal(card);
            }
        }

        System.out.println();
        System.out.println("Cards left in the deck: " + deck.getSize());
        System.out.println();

        for (Player player : players) {
            Hand hand = player.getHand();
            System.out.println(player.getName() + " (" + hand.getSize() + " cards): "
                    + hand.describe() + "= " + hand.getValue());
        }

        System.out.println();
        declareWinner(players);

        scanner.close();
    }

    private static void declareWinner(ArrayList<Player> players) {
        Player winner = null;
        int bestValue = 0;
        boolean tie = false;

        for (Player player : players) {
            int value = player.getHand().getValue();

            if (value <= 21) {
                if (value > bestValue) {
                    winner = player;
                    bestValue = value;
                    tie = false;
                } else if (value == bestValue) {
                    tie = true;
                }
            }
        }

        if (winner == null) {
            System.out.println(ColorCodes.RED + "Everyone went over 21. No winner." + ColorCodes.RESET);
        } else if (tie) {
            System.out.println(ColorCodes.YELLOW +"It's a tie at " + bestValue + "." + ColorCodes.RESET);
        } else {
            System.out.println(ColorCodes.GREEN +winner.getName() + " wins with " + bestValue + "!"+ ColorCodes.RESET);
        }
    }
}

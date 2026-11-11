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
    }
}

// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

import java.util.ArrayList;
import java.util.Scanner;

public class WarGame extends Game {

    Scanner input = new Scanner(System.in);
    private GroupOfCards deck;
    boolean gameEnd = false;

    public WarGame() {
        super("War");
        deck = new GroupOfCards(52);
        createDeck();
        input = new Scanner(System.in);
    }

    private void createDeck() {

        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace" };

        for (int i = 0; i < ranks.length; i++) {

            for (String suit : suits) {
                deck.addCard(new SubCard(suit, ranks[i], i + 2)); // starting from 2 to make it simpler
            }
        }
    }

    @Override
    // Main Game Functionality
    public void playGame() {

        deck.shuffle(); // shuffle the deck before starting game
        ArrayList<Player> players = getPlayers();

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        // Distribution of cards to players
        while (!deck.getCards().isEmpty()) {
            player1.drawCard(deck.drawCard());
            player2.drawCard(deck.drawCard());
        }

        // boolean to check if player has no cards in hand
        boolean player1Hand = player1.getPlayerHand().isEmpty();
        boolean player2Hand = player2.getPlayerHand().isEmpty();

        while (!player1Hand && !player2Hand && !gameEnd) {
            if (player1 instanceof HumanPlayer) {
                System.out.println(""); // for better output readability
                System.out.println("------------------------------"); // for better output readability
                System.out.println("Press Enter to start the round");
                System.out.println("------------------------------"); // for better output readability

                input.nextLine();
            }

            startRound(player1, player2);
        }
    }

    public void startRound(Player player1, Player player2) {

        Card player1Card = player1.playCard();
        System.out.println(player1.getName() + " played " + player1Card);

        Card player2Card = player2.playCard();
        System.out.println(""); // for better output readability
        System.out.println(player2.getName() + " played " + player2Card);

        // Round Logic using RankValue to determine winner

        if (player1Card.getRankValue() < player2Card.getRankValue()) {
            System.out.println(""); // for better output readability
            System.out.println(player2.getName() + " Wins this round");
            player2.drawCard(player1Card);
            player2.drawCard(player2Card);
        }

        else if (player1Card.getRankValue() > player2Card.getRankValue()) {
            System.out.println(""); // for better output readability
            System.out.println(player1.getName() + " Wins this round");
            player1.drawCard(player1Card);
            player1.drawCard(player2Card);
        }

        else {
            System.out.println(""); // for better output readability
            System.out.println("Tie. War starts!!");
            resolveWar(player1, player2, player1Card, player2Card);
        }

    }

    public void resolveWar(Player player1, Player player2, Card player1Card, Card player2Card) {

        ArrayList<Card> warCards = new ArrayList<>(); // all the war cards will be added here and given to winner

        // adding initial cards to warCards
        warCards.add(player1Card);
        warCards.add(player2Card);

        // boolean to check if player has no cards in hand
        boolean player1Hand = player1.getPlayerHand().isEmpty();
        boolean player2Hand = player2.getPlayerHand().isEmpty();

        // setting to three so only three cards are facing down
        for (int i = 0; i < 3; i++) {
            if (!player1Hand && !player2Hand) {
                warCards.add(player1.playCard());
                warCards.add(player2.playCard());
            }

            else {
                System.out.println(""); // for better output readability
                System.out.println("A player does not have enough cards");
                gameEnd = true; // end this war and game
            }
        }

        // now both players place 1 card up
        if (!player1Hand && !player2Hand) {
            Card warCard1 = player1.playCard();
            System.out.println(""); // for better output readability
            System.out.println(player1.getName() + " played " + warCard1);

            Card warCard2 = player2.playCard();
            System.out.println(""); // for better output readability
            System.out.println(player2.getName() + " played " + warCard2);

            if (warCard1.getRankValue() > warCard2.getRankValue()) {
                System.out.println(""); // for better output readability
                System.out.println(player1.getName() + " Won this War!");
                player1.getPlayerHand().addAll(warCards); // adding all the cards inside warCards Arraylist
            }

            else if (warCard1.getRankValue() < warCard2.getRankValue()) {
                System.out.println(""); // for better output readability
                System.out.println(player2.getName() + " Won this War!");
                player2.getPlayerHand().addAll(warCards);
            }

            else {
                System.out.println(""); // for better output readability
                System.out.println("Tie!!. War continues ");
            }

        }

        else {
            System.out.println(""); // for better output readability
            System.out.println("A Player ran out of cards");
            gameEnd = true; // end this war and game

        }

    }

    @Override
    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        if (player1.getPlayerHand().size() > player2.getPlayerHand().size()) {
            System.out.println(""); // for better output readability
            System.out.println(player1.getName() + " Won the Game");
            System.out.println(""); // for better output readability

            gameEnd = true;
        }

        else {
            System.out.println(""); // for better output readability
            System.out.println(player2.getName() + " Won the Game");
            System.out.println(""); // for better output readability

            gameEnd = true;
        }

    }

}

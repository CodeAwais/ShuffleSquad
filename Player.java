// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

import java.util.ArrayList;

public abstract class Player {

    private String name; // name of the player
    private ArrayList<Card> playerHand = new ArrayList<>(); // cards in the player's hand

    public Player(String name) { // constructor
        this.name = name;
    }

    // returning player name
    public String getName() {
        return name;
    }

    // setting player name
    public void setName(String name) {
        this.name = name;
    }

    // returning the cards in player's hand
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    // adding a card to the player's hand
    public void drawCard(Card card) {
        playerHand.add(card);
    }

    public Card playCard() {
        if (playerHand.size() > 0) {
            return playerHand.remove(0); // removing a card from the player's hand
        }

        System.out.println(this.getName() + " has no cards left to play - Game Ends");
        return null;

    }

    public abstract void play();

}

// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024
//

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<Card>();
    }

    public void shuffle() { // method to shuffle the cards
        Collections.shuffle(cards);
    }

    public void addCard(Card card) { // method to add a card to the group of cards
        cards.add(card);
    }

    public ArrayList<Card> getCards() { // return the group of cards
        return cards;
    }

    public int getSize() { // return the size of group
        return size;
    }

    public void setSize(int size) { // set the size of group
        this.size = size;
    }

    public Card drawCard() {
        if (!cards.isEmpty()) { // make sure there are cards in the deck
            return cards.remove(0);
        }

        else {
            System.out.println("Deck is Empty");
            return null;
        }

    }

}

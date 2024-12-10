// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

public class SubCard extends Card {
    private String suit;
    private String rank;

    public SubCard(String suit, String rank, int value) {
        super(suit, rank, value);
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
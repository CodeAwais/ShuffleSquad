// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

public abstract class Card {

    private String suits; // This will be Diamonds, Hearts, Clubs and Spades
    private String ranks; // This will be Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
    private int rankValue; // This will be the value of the rank

    public Card(String suits, String ranks, int rankValue) {
        this.suits = suits;
        this.ranks = ranks;
        setRankValue();
    }

    public void setRankValue() {
        if (ranks.equals("2")) {
            rankValue = 2;
        } else if (ranks.equals("3")) {
            rankValue = 3;
        } else if (ranks.equals("4")) {
            rankValue = 4;
        } else if (ranks.equals("5")) {
            rankValue = 5;
        } else if (ranks.equals("6")) {
            rankValue = 6;
        } else if (ranks.equals("7")) {
            rankValue = 7;
        } else if (ranks.equals("8")) {
            rankValue = 8;
        } else if (ranks.equals("9")) {
            rankValue = 9;
        } else if (ranks.equals("10")) {
            rankValue = 10;
        } else if (ranks.equals("Jack")) {
            rankValue = 11;
        } else if (ranks.equals("Queen")) {
            rankValue = 12;
        } else if (ranks.equals("King")) {
            rankValue = 13;
        } else if (ranks.equals("Ace")) {
            rankValue = 14;
        } else {
            rankValue = 0;
        }

    }

    public String getSuits() {
        return suits;
    }

    public String getRanks() {
        return ranks;
    }

    public int getRankValue() {
        return rankValue;
    }

    @Override
    public abstract String toString();

}

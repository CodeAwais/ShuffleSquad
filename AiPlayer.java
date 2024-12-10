// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

public class AiPlayer extends Player {

    public AiPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + "'s Turn");

        Card card = playCard();

        if (card != null) {
            System.out.println(getName() + " played: " + card);
        }

    }

}

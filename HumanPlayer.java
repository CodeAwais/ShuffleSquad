// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Press Enter to Play!");
        Scanner input = new Scanner(System.in);
        input.nextLine();

        input.close();

        Card card = playCard();

        if (card != null) {
            System.out.println(getName() + " played: " + card);
        }

    }

}

// @Modifier - Awais
// @Modifier - Prahalad
// @Modifier - Suhayl
// Date - 08/12/2024

import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // WarGame instance
        WarGame warGame = new WarGame();

        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        Player player1 = new HumanPlayer(player1Name);

        String player2Name = "Ai Player";
        Player player2 = new AiPlayer(player2Name);

        warGame.addPlayer(player1);
        warGame.addPlayer(player2);

        warGame.playGame();

        warGame.declareWinner();

        scanner.close();
    }
}

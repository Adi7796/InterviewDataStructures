package Design.LLD.TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game ticTacToeGame = new Game();
        ticTacToeGame.initialiseGame();
        System.out.println(ticTacToeGame.playGame());
    }
}

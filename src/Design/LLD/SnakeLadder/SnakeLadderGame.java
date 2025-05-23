package Design.LLD.SnakeLadder;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderGame {
    private final Board board;
    private final List<Player> playerList;
    private final Dice dice;
    private int currentPlayerIndex;

    public SnakeLadderGame(Board board, List<String> playerNames, Dice dice)
    {
        this.board = board;
        this.dice = dice;
        this.playerList = new ArrayList<>();
        for(String playerName : playerNames)
        {
            playerList.add(new Player(playerName));
        }
        currentPlayerIndex = 0;
    }

    public void play()
    {
        while(!isGameOver())
        {
            Player currentPlayer = playerList.get(currentPlayerIndex);
            int diceRoll = dice.roll();

            int nextPosition = currentPlayer.getPosition() + diceRoll;

            if(nextPosition <= board.getBoardSize())
            {
                currentPlayer.setPosition(board.getNextPosition(nextPosition));
                System.out.println(currentPlayer.getPlayerName() + " rolled a " + diceRoll +
                        " and moved to position " + currentPlayer.getPosition());
            }

            if(currentPlayer.getPosition() == board.getBoardSize()){
                System.out.println(currentPlayer.getPlayerName() + " wins!! ");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % (playerList.size());
        }
    }

    private boolean isGameOver()
    {
        for(Player p : playerList)
        {
            if(p.getPosition() == board.getBoardSize())
                return true;
        }
        return false;
    }

}

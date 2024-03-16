package Design.LLD.TicTacToe;

import Design.LLD.TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deque<Player> players;
    Board gameBoard;

    public void initialiseGame(){
        players = new LinkedList<>();
        gameBoard = new Board(3);

        Player player1 = new Player("Player1", new PlayingPieceX());
        Player player2 = new Player("Player2", new PlayingPieceO());

        players.add(player1);
        players.add(player2);
        //gameBoard.printBoard();
    }

    public String playGame()
    {
        boolean noWinner = true;
        while(noWinner)
        {
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();

            List<Pair> freeCells = gameBoard.getFreeCells();
            if(freeCells.isEmpty())
            {
                noWinner = false;
                continue;
            }
            System.out.println("Player " + playerTurn.getPlayerName() + " turn, pick the cell (format - row, col) : ");
            Scanner sc = new Scanner(System.in);
            String inputLine = sc.nextLine();
            String[] input = inputLine.split(",");

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(row, col, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position chosen, please try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isWinner(row, col, playerTurn.getPlayingPiece().getPieceType());
            if(winner){
                gameBoard.printBoard();
                return playerTurn.getPlayerName() + " Wins !!!";
            }
        }

       return "The game has been tied";
    }

    private boolean isWinner(int row, int col, PieceType pieceType)
    {
        boolean isRowMatching = true;
        boolean isColMatching = true;
        boolean isDiagonalMatching = true;
        boolean isAntiDiagonalMatching = true;

        // check for col
        for(int i=0; i< gameBoard.board.length;i++)
        {
            if(gameBoard.board[i][col] == null || gameBoard.board[i][col].getPieceType() != pieceType)
                isColMatching = false;
        }

        // check for row
        for(int j=0; j< gameBoard.board[0].length;j++)
        {
            if(gameBoard.board[row][j] == null || gameBoard.board[row][j].getPieceType() != pieceType)
                isRowMatching = false;
        }

        //check for diagonal
        for(int i=0, j=0; i<gameBoard.board.length && j<gameBoard.board[0].length; i++, j++)
        {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != pieceType)
                isDiagonalMatching = false;
        }

        for(int i=0, j=gameBoard.board[0].length-1; i<gameBoard.board.length && j>=0; i++, j--)
        {
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != pieceType)
                isAntiDiagonalMatching = false;
        }

        return isColMatching || isRowMatching || isDiagonalMatching || isAntiDiagonalMatching;
    }


}

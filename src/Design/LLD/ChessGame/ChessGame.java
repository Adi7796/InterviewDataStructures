package Design.LLD.ChessGame;

import Design.LLD.ChessGame.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private final Board board;
    private final Player whitePlayer, blackPlayer;
    private Player currentPlayer;

    public ChessGame()
    {
        this.board = new Board();
        this.whitePlayer = new Player(Color.WHITE);
        this.blackPlayer = new Player(Color.BLACK);
        this.currentPlayer = whitePlayer;
    }

    public void start()
    {
        while(!isGameOver())
        {
            Player player = currentPlayer;
            System.out.println(player.getColor() + "'s turn");
            // get move from the player
            Move move = getPlayerMove(player);
            try{
                board.movePiece(move);
            } catch (InvalidMoveException ex)
            {
                System.out.println(ex.getMessage());
                System.out.println("Try again!!");
                continue;
            }

            switchTurn();
        }
        displayResult();
    }

    private boolean isGameOver()
    {
        return board.isCheckmate(whitePlayer.getColor()) || board.isCheckmate(blackPlayer.getColor()) ||
                board.isStalemate(whitePlayer.getColor()) || board.isStalemate(blackPlayer.getColor());
    }

    private void switchTurn()
    {
        currentPlayer = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
    }

    private Move getPlayerMove(Player player)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter source row : ");
        int sourceRow = scanner.nextInt();
        System.out.println("Enter source col : ");
        int sourceCol = scanner.nextInt();
        System.out.println("Enter end row : ");
        int endRow = scanner.nextInt();
        System.out.println("Enter end col : ");
        int endCol = scanner.nextInt();

        Piece piece = board.getPiece(sourceRow, sourceRow);
        if(piece == null || piece.getColor() != player.getColor()){
            throw new IllegalArgumentException("Invalid piece selection");
        }

        return new Move(board.getCell(sourceRow, sourceCol), board.getCell(endRow, endCol));
    }

    private void displayResult()
    {

    }
}

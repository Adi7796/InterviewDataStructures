package Design.LLD.ChessGame.pieces;

import Design.LLD.ChessGame.Board;
import Design.LLD.ChessGame.Cell;
import Design.LLD.ChessGame.Color;

public class Pawn extends Piece{

    public Pawn(Color color){
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Cell from, Cell to) {
        int rowDiff = from.getRow() - to.getRow();
        int colDiff = Math.abs(from.getCol() - to.getCol());

        if(color == Color.WHITE)
        {
            return ( rowDiff == 1 && colDiff == 0) ||
                    (from.getRow() == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && board.getPiece(to.getRow(), to.getCol()) != null);
        }
        else{
            return (rowDiff == -1 && colDiff == 0) ||
                    (from.getRow() == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && board.getPiece(to.getRow(), to.getCol()) != null);
        }
    }
}

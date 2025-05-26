package Design.LLD.ChessGame.pieces;

import Design.LLD.ChessGame.Board;
import Design.LLD.ChessGame.Cell;
import Design.LLD.ChessGame.Color;

public class Knight extends Piece{

    public Knight(Color color){
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(from.getRow() - to.getRow());
        int colDiff = Math.abs(from.getCol() - to.getCol());

        return ((rowDiff == 1 && colDiff == 2) || (rowDiff == 2 && colDiff == 1));
    }
}

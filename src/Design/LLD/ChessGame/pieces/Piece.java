package Design.LLD.ChessGame.pieces;

import Design.LLD.ChessGame.Board;
import Design.LLD.ChessGame.Cell;
import Design.LLD.ChessGame.Color;

public abstract class Piece {

    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean isValidMove(Board board, Cell from , Cell to);

    public Color getColor() {
        return color;
    }
}

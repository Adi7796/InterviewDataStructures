package Design.LLD.TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece)
    {
        if(board[row][col] == null) {
            board[row][col] = playingPiece;
            return true;
        }
        return false;
    }
    public List<Pair> getFreeCells(){
        List<Pair> freeCellsList = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j] == null){
                    freeCellsList.add(new Pair(i, j));
                }
            }
        }
        return freeCellsList;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            System.out.print(" | ");
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "  ");
                } else {
                    System.out.print("   ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}

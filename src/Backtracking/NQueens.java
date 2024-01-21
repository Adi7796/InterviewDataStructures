package Backtracking;

public class NQueens {

    static int N = 4;
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0}};

        if(!solveNQueens(board, 0))
            System.out.println("Solution does not exist");
        else
            printSolution(board);

    }

    public static boolean solveNQueens(int[][] board, int row) {
        if(row == N-1) return true;

        for(int col =0; col < N; col ++)
        {
            if(isSafe(board, row, col))
                board[row][col] = 1;
            if(solveNQueens(board, row +1))
                return true;
            board[row][col] = 0;
        }
        return false;
    }

    public static void printSolution(int[][] board)
    {
        for(int i=0; i< board.length; i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                System.out.println(board[i][j]);
            }
        }
    }

    public static boolean isSafe(int[][] board, int row, int col)
    {
        return true;
    }
}

package Companies.Google;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board= {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean solveSudoku(char[][] board)
    {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(i, j, c, board)) {
                            board[i][j] = c;
                            if(solveSudoku(board) == true)
                                return true;
                            else
                                board[i][j] ='.';   // to backtrack
                        }
                    }
                    // if we reach 9 and still haven't returned true
                    // that means that we have exhausted our numbers and have not found a valid solution
                    // hence we return false from here
                    return false;
                }
            }
        }
        // if we never get inside the check -- board[i][j] == '.'    we return true;
        return true;
    }

    public static boolean isValid(int row, int col, char c, char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i] == c)
                return false;
            if(board[i][col] == c)
                return false;

            int smallBoxRow = (3 * (row/3)) + i/3;
            int smallBoxCol = (3 * (col/3)) + i%3;
            if(board[smallBoxRow][smallBoxCol] == c)
                return false;
        }
        return  true;
    }
}

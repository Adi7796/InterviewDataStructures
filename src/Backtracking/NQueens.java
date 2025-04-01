package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]

 */
public class NQueens {

    static int N = 4;
    public static void main(String[] args) {
        printSolution(solveNQueens(6));
        printSolution(solveNQueens(4));
    }

    private static void printSolution(List<List<String>> ans)
    {
        System.out.println("Printing solution : ");
        for(List<String> list: ans)
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println("'" + list.get(i) + "'");
            }
            System.out.println();
        }
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board)
        {
            Arrays.fill(row, '.');
        }

        findCombinations(0, board, ans, n);
        return ans;
    }

    public static void findCombinations(int col, char[][] board, List<List<String>> ans, int n)
    {
        if(col == n)
        {
            ans.add(constructBoard(board, ans, n));
            return;
        }

        for(int row = 0; row < n; row ++)
        {
            if(isSafe(row, col, board, n))
            {
                board[row][col] = 'Q';
                findCombinations(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    private static List<String> constructBoard(char[][] board, List<List<String>> ans, int n)
    {
        List<String> subList = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++)
            {
                sb.append(board[i][j]);
            }
            subList.add(sb.toString());
        }
        return subList;
    }

    private static boolean isSafe(int row, int col, char[][] board, int n)
    {
        int dupRow = row;
        int dupCol = col;

        // checking upper diagonal
        while(row >= 0 && col >= 0)
        {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;
        // checking same row
        while(col >= 0)
        {
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;
        // checking lower diagonal
        while(row < n && col >= 0)
        {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}


/*
Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O(N! * N).

Space Complexity: O( N2 )
*/

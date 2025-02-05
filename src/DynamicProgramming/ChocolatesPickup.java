package DynamicProgramming;

import java.util.Arrays;

/*
You are given an n rows and m cols matrix grid representing a field of chocolates where
grid[i][j] represents the number of chocolates that you can collect from the (i, j) cell.

You have two robots that can collect chocolates for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of chocolates collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the chocolates.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 */
public class ChocolatesPickup {
    public static void main(String[] args) {
        int n = 4, m = 3;
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(solve(n, m, grid));
    }

    public static int solve(int n, int m, int grid[][]) {

        // Code here
        int[][][]dp = new int[n][m][m];
        for (int row1[][] : dp)
        {
            for (int row2[] : row1)
            {
                Arrays.fill(row2, -1);
            }
        }

        return findChocolates(0, 0, m-1, n, m, grid, dp);
    }

    public static int findChocolates(int r, int c1, int c2, int n, int m, int[][] grid, int[][][]dp)
    {
        if(r < 0 || r >= n || c1 < 0 || c1 >= m || c2 < 0 || c2 >= m){
            return Integer.MIN_VALUE;
        }

        if(r==n-1)
        {
            if(c1 == c2)
            {
                return grid[r][c1];
            }
            else
            {
                return grid[r][c1] + grid[r][c2];
            }
        }

        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];

        int maxi = Integer.MIN_VALUE;
        for(int dc1 = -1; dc1 <= 1 ; dc1++)
        {
            for(int dc2 = -1; dc2 <= 1; dc2++)
            {
                int value = 0;
                if(c1 == c2)
                {
                    value = grid[r][c1];
                }
                else
                {
                    value = grid[r][c1] + grid[r][c2];
                }

                value += findChocolates(r+1, c1 + dc1, c2 + dc2, n, m, grid, dp);
                maxi = Math.max(maxi, value);
            }
        }
        return dp[r][c1][c2] = maxi;
    }
}
/*
Time Complexity: O(N*M*M) * 9

Reason: At max, there will be N*M*M calls of recursion
to solve a new problem and in every call, two nested loops together run for 9 times.
 */
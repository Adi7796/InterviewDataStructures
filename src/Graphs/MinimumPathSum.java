package Graphs;

import java.util.Arrays;

/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(minPathSums(grid));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i == 0 && j>=1) dp[0][j] = grid[0][j] + dp[0][j-1];
                else if(j == 0 && i >= 1) dp[i][0] = grid[i][0] + dp[i-1][0];
                else if(i>=1 && j>=1)
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static int minPathSums(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        //return recurse(grid, 0, 0, m, n);
        //return memoization(grid, 0, 0, m, n, dp);
        return tabulation(grid, m, n);
    }

    private int recurse(int[][] grid, int r, int c, int m, int n)
    {
        if(r >= m || c >= n) return Integer.MAX_VALUE;
        if(r == m-1 && c == n-1) return grid[r][c];

        int bottom = recurse(grid, r+1, c, m, n);
        int right = recurse(grid, r, c+1, m, n);

        return grid[r][c] + Math.min(bottom, right);
    }

    private int memoization(int[][] grid, int r, int c, int m, int n, int[][] dp)
    {
        if(r >= m || c >= n) return Integer.MAX_VALUE;
        if(r == m-1 && c == n-1) return grid[r][c];

        if(dp[r][c] != -1) return dp[r][c];
        int bottom = memoization(grid, r+1, c, m, n, dp);
        int right = memoization(grid, r, c+1, m, n, dp);

        return dp[r][c] = grid[r][c] + Math.min(bottom, right);
    }

    private static int tabulation(int[][] grid, int m, int n)
    {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int i = m-2; i>=0; i--)
        {
            dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1];
        }

        for(int i = n-2; i>=0; i--)
        {
            dp[m-1][i] = grid[m-1][i] + dp[m-1][i+1];
        }

        for(int i = m-2; i>=0; i--)
        {
            for(int j = n-2; j >= 0; j--)
            {
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }
}

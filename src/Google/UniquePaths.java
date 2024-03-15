package Google;

/*
You are given an m x n integer array grid.
There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid.
A path that the robot takes cannot include any square that is an obstacle.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
public class UniquePaths {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}};

        int[][] obstacleGrid = {{0, 1},
                                {1, 0}};

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[m-1][n-1] = 0;
        int i=0;
        while(i<m && obstacleGrid[i][0] != 1){
            dp[i][0] = 1;
            i++;
        }

        int j=0;
        while(j<n && obstacleGrid[0][j] != 1){
            dp[0][j] = 1;
            j++;
        }

        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                if(obstacleGrid[i][j] != 1)
                {
                    if((dp[i-1][j] == Integer.MAX_VALUE && dp[i][j-1] != Integer.MAX_VALUE)
                    || (dp[i-1][j] != Integer.MAX_VALUE && dp[i][j-1] == Integer.MAX_VALUE))
                    {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                    }
                    else if(dp[i-1][j] == Integer.MAX_VALUE && dp[i][j-1] == Integer.MAX_VALUE)
                    {
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
    }
}

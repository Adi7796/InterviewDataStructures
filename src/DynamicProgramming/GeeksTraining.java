package DynamicProgramming;

import java.util.Arrays;

/*
Geek is going for a training program for n days.
He can perform any of these activities: Running, Fighting, and Learning Practice.
Each activity has some point on each day. As Geek wants to improve all his skills,
he can't do the same activity on two consecutive days.
Given a 2D matrix mat[][], where mat[i][0], mat[i][1], and mat[i][2] represent the merit points for Running, Fighting,
and Learning on the i-th day, determine the maximum total merit points Geek can achieve .

Example:

Input: mat[][]= [[1, 2, 5],
               [3, 1, 1],
               [3, 3, 3]]
Output: 11
Explanation: Geek will learn a new move and earn 5 point then on second day he will do running and earn 3 point
and on third day he will do fighting and earn 3 points so, maximum merit point will be 11.
 */
public class GeeksTraining {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}};
        System.out.println( maximumPoints(grid));
    }
    public static int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;

        int[][] dp = new int[n][4];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        //return recurse(arr, n-1, 3);
        return memoisation(arr, n-1, 3, dp);
    }


    private static int recurse(int[][] arr, int r, int last)
    {
        if(r == 0){
            int maxi = 0;

            for(int i = 0; i < 3; i++)
            {
                if(i != last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                int point = arr[r][i] + recurse(arr, r-1, i);
                maxi = Math.max(point, maxi);
            }
        }

        return maxi;
    }

    private static int memoisation(int[][] arr, int r, int last, int[][] dp)
    {
        if(r == 0){
            int maxi = 0;

            for(int i = 0; i < 3; i++)
            {
                if(i != last){
                    maxi = Math.max(maxi, arr[0][i]);
                }
            }
            return dp[r][last] = maxi;
        }

        if(dp[r][last] != -1) return dp[r][last];
        int maxi = 0;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                int point = arr[r][i] + memoisation(arr, r-1, i, dp);
                maxi = Math.max(point, maxi);
            }
        }

        return dp[r][last] = maxi;
    }
}

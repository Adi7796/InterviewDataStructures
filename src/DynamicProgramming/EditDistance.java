package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println("Minimum number of operations to change str1 to str2 : "
                + findMinCostRecursion(str1, str2, str1.length(), str2.length()));

        System.out.println("Minimum number of operations using DP : "
                + findMinCostDp(str1, str2));
    }


    //Time Complexity: O(3^m), when none of the characters of two strings match as shown in the image below.
    //Auxiliary Space: O(1)
    public static int findMinCostRecursion(String str1, String str2, int m, int n)
    {
        if(m==0)
            return n;
        else if(n==0)
            return m;

        else if(str1.charAt(m-1) == str2.charAt(n-1))
            return findMinCostRecursion(str1, str2, m-1, n-1);

        return 1 +
                Math.min(
                        Math.min(
                                findMinCostRecursion(str1, str2, m-1, n),  // delete
                                findMinCostRecursion(str1, str2, m, n-1) // insert
                        ), findMinCostRecursion(str1, str2, m-1, n-1) // replace
                );
    }

    public static int findMinCostDp(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0)
                    dp[i][j] = j;
                else if(j==0)
                    dp[i][j] = i;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i-1][j] // remove
                                    , dp[i][j-1]), // insert
                            dp[i-1][j-1]  // replace
                    );
            }
        }

        return dp[m][n];
    }

    // leetcode implementation
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }

        return memoization(word1, word2, n-1, m-1, dp);
    }

    private int memoization(String w1, String w2, int i, int j, int[][] dp)
    {
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j))
            return dp[i][j] = 0 + memoization(w1, w2, i-1, j-1, dp);

        else return dp[i][j] = 1 + Math.min(Math.min(memoization(w1, w2, i, j-1, dp),  // insert
                        memoization(w1, w2, i-1, j, dp)), // delete
                memoization(w1, w2, i-1, j-1, dp)); // replace
    }
}

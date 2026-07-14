package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str2 = "AGGTAB";
        String str1 = "GXTXAYB";

        System.out.println("Max length of the common subsequence : "+ findMaxLength(str1, str2));
    }

    public static int findMaxLength(String str1, String str2){

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;

                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                else if(str1.charAt(i-1) != str2.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    private static int recurse(String s1, String s2, int i, int j, int m, int n)
    {
        if(i >=m || j >= n) return 0;
        if(s1.charAt(i) == s2.charAt(j)) return 1 + recurse(s1, s2, i+1, j+1, m, n);

        return Math.max(recurse(s1, s2, i+1, j, m, n)
                , recurse(s1, s2, i, j+1, m, n));
    }

    private static int memoization(String s1, String s2, int i, int j, int m, int n, int[][] dp)
    {
        if(i >=m || j >= n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return 1 + memoization(s1, s2, i+1, j+1, m, n, dp);

        return dp[i][j] = Math.max(memoization(s1, s2, i+1, j, m, n, dp)
                , memoization(s1, s2, i, j+1, m, n, dp));
    }

    // leet code implementation
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the LCS lengths
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }
}

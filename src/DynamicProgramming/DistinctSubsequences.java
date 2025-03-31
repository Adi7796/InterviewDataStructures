package DynamicProgramming;

/*
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        // int[][] dp = new int[n+1][m+1];

        // for(int[] row : dp)
        // {
        //     Arrays.fill(row, -1);
        // }
        // return findDistinct(n-1, m-1, s, t, dp);
        return findDistinctTabulation(s, t, n, m);
    }

    private int findDistinct(int i, int j, String s, String t, int[][] dp)
    {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        // if characters match we can either move back in both the strings: i-1, j-1 and compare
        // or choose to not pick the jth index in string t and compare the remaining i-1 string s with j the index in t
        if(s.charAt(i) == t.charAt(j))
        {
            return dp[i][j] = findDistinct(i-1, j-1, s, t, dp) + findDistinct(i-1, j, s, t, dp);
        }

        // if the chars dont match - we have only one option of moving back in string s and compare the t string upto j
        return dp[i][j] = findDistinct(i-1, j,s, t, dp);
    }

    private static int findDistinctTabulation(String s, String t, int n, int m)
    {
        int[][] dp = new int[n+1][m+1];

        // Initialize the first column with 1 because there's one empty subsequence in any string.
        for(int i = 0; i<=n; i++)
            dp[i][0] = 1;

        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for(int j = 1; j<=m; j++)
            dp[0][j] = 0;

        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=m; j++)
            {
                // If the characters match, we can either include this character in the subsequence
                // or exclude it. So, we add the counts from both possibilities.
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    // If the characters don't match, we can only exclude this character.
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][m];
    }
}

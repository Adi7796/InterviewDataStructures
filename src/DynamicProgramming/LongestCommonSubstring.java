package DynamicProgramming;

//Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        String str2 = "GeeksQuiz";

        System.out.println("Length of longest substring : "+ findLongestLength(str1, str2));
    }

    public static int findLongestLength(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j ==0)
                    dp[i][j] = 0;
                else {
                    if(str1.charAt(i-1) == str2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }

    //Time Complexity: O(m*n)
    //Auxiliary Space: O(m*n), since m*n extra space has been taken.
}

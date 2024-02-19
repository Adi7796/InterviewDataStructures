package Google;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "abacbc";

        int n= str.length();

        int[][] dp = new int[n+1][n+1];

        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(str.charAt(i-1) == str.charAt(j-1) && i != j){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else if(str.charAt(i-1) == str.charAt(j-1) && i == j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                else if(str.charAt(i-1) != str.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int i=0; i<=n; i++)
        {
            for(int j=0; j<=n; j++)
            {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Length of longest repeating subsequence : " + dp[n][n]);
    }
}

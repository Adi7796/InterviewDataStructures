package DynamicProgramming;


//Case1: Every single character is a palindrome of length 1
//L(i, i) = 1 (for all indexes i in given sequence)
//Case2: If first and last characters are not same
//If (X[i] != X[j])  L(i, j) = max{L(i + 1, j), L(i, j – 1)}
//Case3: If there are only 2 characters and both are same
//Else if (j == i + 1) L(i, j) = 2
//Case4: If there are more than two characters, and first and last characters are same
//Else L(i, j) =  L(i + 1, j – 1) + 2
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        String str1 = "BBABCBCAB";

        System.out.println("Max length of palindromic subsequence using recursion : " + findMaxLengthRecursion(str1, 0, str1.length()-1));
        System.out.println("Max length of palindromic subsequence using DP : " + findMaxLengthDp(str1));
    }

    //Time complexity: O(2n), where ‘n’ is the length of the input sequence.
    //Auxiliary Space: O(n2) as we are using a 2D array to store the solutions of the subproblems.
    public static int findMaxLengthRecursion(String str, int start, int end)
    {
        if(start == end)
            return 1;
        else if(start + 1 == end && str.charAt(start)== str.charAt(end))
            return 2;
        else if(str.charAt(start) == str.charAt(end))
            return findMaxLengthRecursion(str, start + 1, end -1) + 2;

        return Math.max(findMaxLengthRecursion(str, start + 1, end),
                findMaxLengthRecursion(str, start, end -1));
    }

    //The idea used here is to reverse the given input string and check the length of the longest common subsequence.
    // That would be the answer for the longest palindromic subsequence.
    public static int findMaxLengthDp(String str)
    {
        String reverseStr = new StringBuilder(str).reverse().toString();
        int m = str.length();
        int n = reverseStr.length();
        int[][] dp = new int[m+1][m+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(str.charAt(i-1) == reverseStr.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] +1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}

//Time Complexity: O(n2)
//Auxiliary Space: O(n2)

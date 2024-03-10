package Google;

/*
Given a string str, a partitioning of the string is a palindrome partitioning
if every sub-string of the partition is a palindrome.
Determine the fewest cuts needed for palindrome partitioning of the given string.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        String str2 = "aaabba";
        //String str = "abac";

        System.out.println("Min partitions for " + str + " : " + findPartitions(str));
        System.out.println("Min partitions for " + str2 + " : " + findPartitions(str2));
    }

    public static int findPartitions(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];

        for (int gap = 0; gap < len; gap++) {
            for (int row = 0, col = gap; col < len; row++, col++) {
                if (gap == 0)
                    dp[row][col] = 0;
                else {
                    if (isPalindrome(row, col, str)) {
                        dp[row][col] = 0;
                    } else {
                        dp[row][col] = Integer.MAX_VALUE;
                        for (int k = row; k < col; k++) {
                            dp[row][col] = Math.min(dp[row][col],
                                    1 + dp[row][k] + dp[k + 1][col]);
                        }
                    }
                }

            }
        }

        return dp[0][len - 1];
    }

    public static boolean isPalindrome(int start, int end, String str) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
}
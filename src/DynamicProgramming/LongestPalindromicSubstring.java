package DynamicProgramming;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "abdbca";
        String str2 = "forgeeksskeegfor";

        System.out.println("Max length for "+ str + " : "+ findMaxLength(str));
        System.out.println("Max length for " + str2 + " : " + findMaxLength(str2));
    }

    public static int findMaxLength(String str)
    {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int n = str.length();
        int maxLength = 0;
        int count = 0;
        for(int gap =0; gap < n; gap ++)
        {
            for(int i=0,j=gap ; j< n; i++, j++)
            {
                if(gap ==0){   // if we are at the same character
                    dp[i][j] = true;
                    maxLength = 1;
                }
                else if(gap == 1)
                {
                    if(str.charAt(i) == str.charAt(j)){   // for length = 2 and the gap between start and end pointer is 1
                        dp[i][j] = true;
                        maxLength = 2;
                    }

                    else dp[i][j] = false;
                }
                else if(gap > 1)  // for length > 2
                {
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        maxLength = gap + 1;
                    }
                    else
                        dp[i][j] = false;
                }

                if(dp[i][j] == true)
                    count ++;    // to keep count of the number of substring palindromes
            }
        }
        return maxLength;
    }
}

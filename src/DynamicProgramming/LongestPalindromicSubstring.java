package DynamicProgramming;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "abdbca";
        String str2 = "forgeeksskeegfor";

        String strAns = findMaxLength(str);
        String strAns2 = findMaxLength(str2);
        System.out.println("Max length for "+ strAns + " : "+ strAns.length());
        System.out.println("Max length for " + strAns2 + " : " + strAns2.length());
    }

    public static String findMaxLength(String str)
    {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int n = str.length();
        int maxLength = 0;
        int count = 0;
        StringBuffer strbuff = new StringBuffer("");
        for(int gap =0; gap < n; gap ++)
        {
            for(int i=0,j=gap ; j< n; i++, j++)
            {
                if(gap ==0){   // if we are at the same character
                    dp[i][j] = true;
                    maxLength = 1;
                    strbuff = new StringBuffer(str.substring(i,j+1));
                }
                else if(gap == 1)
                {
                    if(str.charAt(i) == str.charAt(j)){   // for length = 2 and the gap between start and end pointer is 1
                        dp[i][j] = true;
                        maxLength = 2;
                        strbuff = new StringBuffer(str.substring(i,j+1));
                    }

                    else dp[i][j] = false;
                }
                else if(gap > 1)  // for length > 2
                {
                    if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        maxLength = gap + 1;
                        strbuff = new StringBuffer(str.substring(i,j+1));
                    }
                    else
                        dp[i][j] = false;
                }

                if(dp[i][j] == true)
                    count ++;    // to keep count of the number of substring palindromes
            }
        }
        return strbuff.toString();
    }
}

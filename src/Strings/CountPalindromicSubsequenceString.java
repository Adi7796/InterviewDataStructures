package Strings;

public class CountPalindromicSubsequenceString {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println("Count using Recursion : "+ countPalindromicSubsequencesRecursion(str, 0, str.length()-1));
        System.out.println("Count using DP : "+ countPalindromicSubsequencesDP(str));
    }

    /*
    Includes 3 main conditions
    1) (i==j) base condition - when both characters are same and length is 1

    2) str(i) == str(j) --> Has 2 possibilities
    a) when we include both i&j --> 1 + count(i+1, j-1)
    b) when we exclude both i & j --> count (i, j-1) + count(i+1, j) - count(i+1, j-1) [ we subtract because we have added this
    count 2 times while adding count (i, j-1) + count(i+1, j), hence we subtract the count once
    Hence adding a&b we get the final equation

    3)str(i) != str(j)
    this means we exclude both i&j. Hence, we arrive at the 2,a) equation as stated above
     */
    public static int countPalindromicSubsequencesRecursion(String str, int i, int j)
    {
        if(i==j)
            return 1;

        else if(i>j)
            return 0;

        else if(str.charAt(i) == str.charAt(j)) {
            return 1 + countPalindromicSubsequencesRecursion(str, i, j - 1)
                    + countPalindromicSubsequencesRecursion(str, i + 1, j);
        }
        else{
            return countPalindromicSubsequencesRecursion(str, i+1, j)
            + countPalindromicSubsequencesRecursion(str, i, j-1)
            - countPalindromicSubsequencesRecursion(str, i+1, j-1);
        }
    }

    public static int countPalindromicSubsequencesDP(String str)
    {
        int N = str.length();
        int[][] mat = new int[N][N];

        for(int gap=0; gap<N; gap++)
        {
            for(int i=0, j=gap; j< N; i++, j++) {
                if(gap == 0)
                    mat[i][j] = 1;
                else if(gap == 1)
                    // suppose for aa where gap is 1 and chars are same, possible palindromes are - a, a, aa : 3
                    // suppose for ab where gap is 1 and chars are not same, possible palindromes are - a, b : 2
                    mat[i][j] = str.charAt(i) == str.charAt(j) ? 3:2;
                else{
                    if(str.charAt(i) == str.charAt(j))
                        // similar to recursion logic
                        mat[i][j] = 1 + mat[i][j-1] + mat[i+1][j];
                    else
                        // similar to recursion logic
                        mat[i][j] = mat[i][j-1] + mat[i+1][j] - mat[i+1][j-1];
                }
            }
        }

        return mat[0][N-1];
    }

    // Time Complexity : O(n2)
    // Space Complexity : O(n2)
}

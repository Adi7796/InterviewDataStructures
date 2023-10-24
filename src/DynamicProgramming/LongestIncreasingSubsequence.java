package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //int[] arr = {3, 10, 2, 1, 20};
        int[] arr = {50, 3, 10, 7, 40, 80};

        System.out.println("Longest increasing subsequence : "+ findLongest(arr));
    }

    public static int findLongest(int[] arr)
    {
        int[] dp = new int[arr.length];

        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max_result= 0;
        for(int i=1; i<arr.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(arr[i] > arr[j] && dp [i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
                max_result = Math.max(max_result, dp[i]);
            }
        }
        return max_result;
    }
}

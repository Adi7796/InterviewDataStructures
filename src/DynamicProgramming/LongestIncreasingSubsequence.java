package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //int[] arr = {3, 10, 2, 1, 20};
        int[] arr = {50, 3, 10, 7, 40, 80};

        System.out.println("Longest increasing subsequence : "+ tabulation(arr));
    }

    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i<n; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        //return recurse(arr,0,-1);
        //return memoization(arr, 0, -1, dp);
        return tabulation(arr);
    }

    private static int recurse(int[] arr, int currInd, int prevInd)
    {
        if(currInd == arr.length) return 0;

        int take = Integer.MIN_VALUE;
        if(prevInd == -1 || arr[currInd] > arr[prevInd]){
            take = 1 + recurse(arr, currInd + 1, currInd);
        }
        int notTake = recurse(arr, currInd + 1, prevInd);

        return Math.max(take, notTake);
    }

    private static int memoization(int[] arr, int currInd, int prevInd, int[][] dp)
    {
        if(currInd == arr.length) return 0;

        if(dp[currInd][prevInd+1] != -1) return dp[currInd][prevInd+1];
        int take = Integer.MIN_VALUE;
        if(prevInd == -1 || arr[currInd] > arr[prevInd]){
            take = 1 + memoization(arr, currInd + 1, currInd, dp);
        }
        int notTake = memoization(arr, currInd + 1, prevInd, dp);

        return dp[currInd][prevInd+1]= Math.max(take, notTake);
    }

    public static int tabulation(int[] arr)
    {
        int[] dp = new int[arr.length];

        Arrays.fill(dp, 1);
        dp[0] = 1;
        int max_result= 1;
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

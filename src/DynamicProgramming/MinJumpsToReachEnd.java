package DynamicProgramming;

import java.util.Arrays;

// Given an array arr[] where each element represents the max number of steps that can be made forward from that index.
// The task is to find the minimum number of jumps to reach the end of the array starting from index 0.
public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println("Minimum number of jumps required : " + mimJumps(arr));
    }

    public static int mimJumps(int[] arr)
    {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(i<= j + arr[j] && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[arr.length -1];
    }
}

//Time Complexity: O(n2)
//Auxiliary Space: O(n), since n extra space has been taken.
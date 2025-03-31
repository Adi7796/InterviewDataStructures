package DynamicProgramming;

import java.util.Arrays;

/*
Given an array of positive integers arr[] and a value target,
determine if there is a subset of the given array with sum equal to given target.

Examples:
Input: arr[] = [3, 34, 4, 12, 5, 2], target = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], target = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
 */
public class SubsetSumEqualToTarget {

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;

        System.out.println(isSubsetSum(nums, target));
    }
    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return isValidSubset(arr, target, n-1, dp);
    }

    static boolean isValidSubset(int[] arr, int target, int index, int[][] dp)
    {
        if(target == 0) return true;
        if(index == 0) return arr[0] == target;

        if(dp[index][target] != -1)
        {
            return dp[index][target] == 0 ? false : true;
        }

        boolean notTaken =  isValidSubset(arr, target, index -1, dp);
        boolean taken = false;

        if(target >= arr[index])
        {
            taken = isValidSubset(arr, target - arr[index], index - 1, dp);
        }


        dp[index][target] = taken || notTaken ? 1 : 0;
        return taken || notTaken;
    }
}

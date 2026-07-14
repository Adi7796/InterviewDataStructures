package DynamicProgramming;

import java.util.Arrays;

/*
Given an array arr of non-negative integers and an integer target,
the task is to count all subsets of the array whose sum is equal to the given target.

Examples:

Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.
Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the array that sum up to the target 3.
Input: arr[] = [35, 2, 8, 22], target = 0
Output: 1
Explanation: The empty subset is the only subset with a sum of 0.
 */
public class CountSubsetsEqualToTarget {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 10, 6, 8};
        int target = 10;

        System.out.println(perfectSum(nums, target));
    }
    public static int perfectSum(int[] nums, int target) {
        // code here
        int[][] dp = new int[nums.length][target + 1];
        for(int i = 0; i<nums.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        return recurse(nums, target, 0, nums.length, dp);
    }


    private static int recurse(int[] nums, int target, int ind, int len, int[][] dp)
    {
        if(ind == len){
            return target == 0 ? 1:0; // Meaning: "I've processed all elements. If I've achieved the target, this is one valid subset."
        }

        if(dp[ind][target] != -1) return dp[ind][target];
        int notPick = recurse(nums, target, ind + 1, len, dp);
        int pick = 0;
        if(nums[ind] <= target){
            pick = recurse(nums, target - nums[ind], ind + 1, len, dp);
        }

        return dp[ind][target] = pick + notPick;
    }
}

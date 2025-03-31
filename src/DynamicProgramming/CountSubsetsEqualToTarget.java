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
        int[][] dp = new int[nums.length][target+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return countSubsets(nums.length-1, nums, target, dp);
    }

    private static int countSubsets(int index, int[] nums, int target, int[][] dp)
    {
        // if the index becomes 0, that's our base case
        if (index == 0) {
            // if target becomes 0 and the 0th index in 0
            // we can both take and not take this 0 as removing the 0 from the target
            // and not removing the 0 from the target will not alter the target
            // hence we have 2 options
            if (target == 0 && nums[0] == 0) return 2;

            // if the target is 0 and nums[0] = 5, we can not take the last index - hence 1 option
            // or if the target is equal to nums[0] say 5, we need to take this index - hence 1 option
            if(target == 0 || target == nums[0]) return 1;

            // in all other cases we will not pick this index
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];
        int notTake = countSubsets(index-1, nums, target, dp);
        int take = 0;
        if(nums[index] <= target)
        {
            take = countSubsets(index-1, nums, target - nums[index], dp);
        }

        return dp[index][target] = take + notTake;
    }
}

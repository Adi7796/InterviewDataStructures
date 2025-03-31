package DynamicProgramming;

/*
Given an integer array nums, return true if you can partition
the array into two subsets such that the sum of the elements in both subsets
is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums)
    {
        int totalSum = 0;
        for(int i : nums)
            totalSum += i;
        // int[][] dp = new int[nums.length][(totalSum/2) + 1];
        // for(int[] row : dp)
        // {
        //     Arrays.fill(row, -1);
        // }
        //if(totalSum % 2 == 0) return partition(nums.length-1, nums, totalSum/2, dp);
        if(totalSum % 2 == 0) return tabulation(nums, totalSum/2);
        return false;
    }

    private static boolean partition(int index, int[] nums, int sum, int[][] dp)
    {
        if(sum == 0) return true;
        if(index == 0)
        {
            if(sum == nums[0]) return true;
            return false;
        }

        if(dp[index][sum] != -1) {
            return dp[index][sum] == 1 ? true : false;
        }
        boolean take = false;
        boolean notTake = partition(index -1 , nums, sum, dp);
        if(nums[index] <= sum)
        {
            take = partition(index-1, nums, sum - nums[index], dp);
        }
        dp[index][sum] = take || notTake == true ? 1 : 0;
        return take || notTake;
    }

    private static boolean tabulation(int[] nums, int sum)
    {
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum+1];
        for(int index = 0; index < n; index++)
            dp[index][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int index = 1; index < n; index ++)
        {
            for(int k = 1; k<= sum; k++)
            {
                boolean take = false;
                boolean notTake = dp[index-1][k];
                if(nums[index] <= k)
                {
                    take = dp[index-1][k - nums[index]];
                }

                dp[index][k] = take || notTake;
            }
        }

        return dp[n-1][sum];
    }
}

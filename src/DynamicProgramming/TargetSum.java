package DynamicProgramming;

/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-'
before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and
concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
 */
public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }
    public static int findTargetSumWays(int[] nums, int d) {
        int totSum = 0;
        for(int i : nums)
            totSum += i;

        /*
        Since we need to find s1-s2 = d such that s1 >= s2
        s1 + s2 = totSum ===> s1 = totSum - s2
        substituting for s1 => totSum - s2 -s2 = d
        Hence, s2 = (totSum - d)/2
        */

        if(totSum - d < 0 || (totSum - d) % 2 != 0) return 0;
        int target = (totSum - d) / 2;
        // int[][] dp = new int[arr.length][target+1];
        // for(int[] row : dp)
        // {
        //     Arrays.fill(row, -1);
        // }
        // return countSubsets(arr.length-1, arr, target, dp);
        return countSubsetsTabulation(nums, target);
    }

    private static int countSubsets(int index, int[] nums, int target, int[][] dp)
    {
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

    private static int countSubsetsTabulation(int[] nums, int target)
    {
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        // if index == 0, nums[0] == 0 and sum == 0, we can take and not take
        // hence 2 ways
        if(nums[0] == 0) dp[0][0] = 2;

            // else if index == 0 and sum == 0 but nums[0] != 0 say 5
            // there is only one way - not take as we cannot make a sum of 5 with 0
        else dp[0][0] = 1;

        // if nums[0] <= target say nums[0] = 5 and target = 5
        // only 1 way - take the number
        // nums[0] should not be 0 as if its 0, we can again take and not take = 2
        if(nums[0] != 0 && nums[0] <= target) dp[0][nums[0]] = 1;

        for(int index = 1; index < n; index++)
        {
            for(int k = 0; k<=target; k++)
            {
                int take = 0;
                int notTake = dp[index -1][k];

                if(nums[index] <= k)
                {
                    take = dp[index-1][k-nums[index]];
                }

                dp[index][k] = take + notTake;
            }
        }

        return dp[n-1][target];
    }
}

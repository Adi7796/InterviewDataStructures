package DynamicProgramming;

/*
Given an array nums and an integer k.Return the number of non-empty subsequences of nums
such that the sum of all elements in the subsequence is equal to k.

Examples:
Input : nums = [4, 9, 2, 5, 1] , k = 10
Output : 2
Explanation : The possible subsets with sum k are [9, 1] , [4, 5, 1].

Input : nums = [4, 2, 10, 5, 1, 3] , k = 5
Output : 3
Explanation : The possible subsets with sum k are [4, 1] , [2, 3] , [5].
 */
public class CountSubsequenceEqualToSumK {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(countSubsets(nums.length-1, nums, target));
    }

    private static int countSubsets(int index, int[] nums, int target)
    {
        if(target == 0) return 1;
        if(index == 0)
        {
            return nums[0] == target ? 1 : 0;
        }

        int notTake = countSubsets(index-1, nums, target);
        int take = 0;
        if(nums[index] <= target)
        {
            take = countSubsets(index-1, nums, target - nums[index]);
        }

        return take + notTake;
    }
}

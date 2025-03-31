package DynamicProgramming;

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

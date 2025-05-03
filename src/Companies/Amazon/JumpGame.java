package Companies.Amazon;

/*
You are given an integer array nums.
You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
which makes it impossible to reach the last index.
 */
public class JumpGame {
    public static void main(String[] args) {
        //int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        JumpGame obj = new JumpGame();
        System.out.println(obj.canJump(nums));
        System.out.println(obj.canJumpFromPositionRecursion(0, nums));
    }

    enum Index{
        GOOD,
        BAD,
        UNKNOWN
    }

    Index[] memo;
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for(int i =0;i<nums.length; i++)
        {
            memo[i] = Index.UNKNOWN;
        }

        memo[memo.length-1] = Index.GOOD;
        return recurse(nums, 0);
    }

    public boolean recurse(int[] nums, int index)
    {
        if(memo[index] != Index.UNKNOWN)
        {
            return memo[index] == Index.GOOD ? true : false;
        }
        int maxJumpPosition = Math.min(nums.length-1, index + nums[index]);
        for(int nextPosition = index + 1; nextPosition <= maxJumpPosition; nextPosition++)
        {
            if(recurse(nums,nextPosition))
            {
                memo[index] = Index.GOOD;
                return true;
            }
        }
        memo[index] = Index.BAD;
        return false;
    }
    /* Time complexity : O(n^2).  */
    public boolean canJumpFromPositionRecursion(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (
                int nextPosition = position + 1;
                nextPosition <= furthestJump;
                nextPosition++
        ) {
            if (canJumpFromPositionRecursion(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    /*
    Time complexity : O(2^n). There are 2^n
  (upper bound) ways of jumping from the first position to the last, where n is the length of array nums.
  For a complete proof, please refer to Appendix A.
  Space complexity : O(n). Recursion requires additional memory for the stack frames.
     */
}

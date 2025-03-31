package SlidingWindow;

/*
Given a binary array nums and an integer goal,
return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 */
public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        System.out.println(numSubarraysWithSum(nums, goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return findCount(nums, goal) - findCount(nums, goal-1);
    }

    // find count of subarrays for sum <= goal as that's easier to find
    // then subtract the count of sum <= goal-1 from sum <= goal
    // as that gives the count of sum == goal
    private static int findCount(int[] nums, int goal)
    {
        if(goal < 0) return 0;

        int r = 0, l = 0, sum = 0, count = 0;
        int n = nums.length;

        while(r < n)
        {
            // add the current element
            // to current running sum
            sum += nums[r];

            // if this is not a valid window
            // keep on shortening the window by decrementing sum and incrementing l
            while(sum > goal)
            {
                sum = sum - nums[l];
                l++;
            }

            // once sum <= goal, increment the count
            // count is the total number of subarrays which are valid
            // that would be equal to the length of the current subarray
            // Eq : 0 1 1 0, goal <= 2, total subarrays with r =3 and l = 0
            // would be 4 -> 0, (0,1), (0,1,1), (0,1,1,0)
            if(sum <= goal)
            {
                count = count + (r - l + 1);
            }

            // increment the right
            r++;
        }
        return count;
    }
}

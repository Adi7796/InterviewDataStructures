package SlidingWindow;

/*
Given an array of integers nums and an integer k.
A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 */
public class CountOfNiceSubarrays {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        CountOfNiceSubarrays obj = new CountOfNiceSubarrays();
        System.out.println(obj.numberOfSubarrays(nums, k));
    }
    public int numberOfSubarrays(int[] nums, int k) {
        // similar to count Binary Subarrays With Sum K
        // we can convert this array to a binary subarray and then apply the same logic
        // for oddnumbers -> convert array value to 1
        // for even numbers -> convert array value to 0

        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1;
        }

        return findCount(nums, k) - findCount(nums, k-1);
    }

    // find count of subarrays for sum <= goal as that's easier to find
    // then subtract the count of sum <= goal-1 from sum <= goal
    // as that gives the count of sum == goal
    private int findCount(int[] nums, int goal)
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

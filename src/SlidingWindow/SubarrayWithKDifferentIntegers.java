package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly
2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly
3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
public class SubarrayWithKDifferentIntegers {

    public static void main(String[] args) {
        SubarrayWithKDifferentIntegers obj = new SubarrayWithKDifferentIntegers();
        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println(obj.subarraysWithKDistinct(nums, k));
    }
    public int subarraysWithKDistinct(int[] nums, int k)
    {
        return findCount(nums, k) - findCount(nums, k-1);
    }

    private int findCount(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, count = 0;
        int n = nums.length;
        while(r < n)
        {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k)
            {
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}

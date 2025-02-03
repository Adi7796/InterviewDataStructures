package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k,
return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;
        for(int i = 0; i<arr.length; i++)
        {
            prefixSum += arr[i];
            int remaining = prefixSum - k;
            count += map.getOrDefault(remaining, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

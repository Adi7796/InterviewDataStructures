package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given an array arr[] containing positive elements,
the task is to find the length of the longest subarray of an input array
containing at most two distinct integers.

Examples:

Input: arr[]= [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct
integers (2 and 1). Hence, the length of the longest subarray is 3.
Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct
integers is [1, 2, 2, 2, 2], which has a length of 5.
The subarray starts at the second element 1 and ends at the last element.
It contains at most two distinct integers (1 and 2).
 */
public class LengthOfLongestSubarrayWith2DistinctIntegers {

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 2, 2, 2, 2};
        System.out.println(totalElements(arr));
    }
    public static int totalElements(Integer[] arr) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int r = 0, l = 0;
        int n = arr.length;
        int maxLen = Integer.MIN_VALUE;

        while(r < n)
        {
            if(!map.containsKey(arr[r]))
            {
                map.put(arr[r], 1);
            }
            else
            {
                map.put(arr[r], map.get(arr[r]) + 1);
            }

            if(map.size() > 2)
            {
                map.put(arr[l], map.get(arr[l])-1);

                if(map.get(arr[l]) == 0)
                {
                    map.remove(arr[l]);
                }

                l++;
            }

            if(map.size() <= 2)
            {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}

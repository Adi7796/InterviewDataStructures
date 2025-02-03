package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

 */
public class MajorityElement2 {
/*
To figure out a O(1) space requirement, we would need to get this simple intuition first.
For an array of length n:

There can be at most one majority element which is more than ⌊n/2⌋ times.
There can be at most two majority elements which are more than ⌊n/3⌋ times.
There can be at most three majority elements which are more than ⌊n/4⌋ times.
and so on.
 */

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        majorityElement(nums);
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        int count1 = 0; int element1 = 0;
        int count2 = 0; int element2 = 0;

        for(int i = 0; i<nums.length; i++)
        {
            if(count1 == 0 && element2 != nums[i])
            {
                element1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0 && element1 != nums[i])
            {
                element2 = nums[i];
                count2 = 1;
            }

            else if(nums[i] == element1) count1++;
            else if(nums[i] == element2) count2++;

            else{
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int i : nums)
        {
            if(i == element1) count1++;
            else if(i == element2) count2++;
        }
        if(count1 > Math.floor(n/3)) ans.add(element1);
        if(count2 > Math.floor(n/3)) ans.add(element2);

        return ans;
    }
}

/*
Time complexity : O(N)
 */

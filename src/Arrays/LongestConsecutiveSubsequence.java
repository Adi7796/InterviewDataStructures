package Arrays;

import java.util.HashSet;

/*
Given an unsorted array of integers nums,
return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

 */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
        {
            set.add(i);
        }

        int length=0;
        for(int i : set)
        {
            if(!set.contains(i-1))
            {
                int number = i;
                int count = 1;
                while(set.contains(number+1)){
                    number++;
                    count++;
                }

                length = Math.max(length,count);
            }
        }
        return length;
    }
}

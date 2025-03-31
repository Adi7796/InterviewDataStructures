package StackAndQueue;

import java.util.Stack;

/*
Given a circular integer array nums (i.e., the next element of
nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to
its traversing-order next in the array, which means you could search
circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 */
public class NextGreaterElement_II {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();

        // doubling the array virtually to imitate a circular array
        for(int i = (2*n)-1; i >= 0; i--)
        {
            while(!st.isEmpty() && nums[i%n] >= st.peek())
            {
                st.pop();
            }

            // we update only when i is within bounds of n
            if(i < n)
            {
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }
        return nge;
    }
}

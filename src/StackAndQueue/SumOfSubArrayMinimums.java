package StackAndQueue;

import java.util.Stack;

/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444
 */
public class SumOfSubArrayMinimums {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubarrayMins(arr));
    }
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        final int MOD = (int) 1e9 + 7;
        int[] nse = nextSmaller(arr);
        int[] pse = prevSmaller(arr);

        long total = 0;
        for(int i=0; i<n; i++)
        {
            long left = Math.abs(i - pse[i]);
            long right = Math.abs(nse[i] -i);

            total = (total + (left * right * arr[i])) % MOD;
        }

        return (int)total;
    }

    private static int[] nextSmaller(int[] arr)
    {
        int n = arr.length;
        int [] nse = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        nse[n-1] = n;

        for(int i = n-2; i>=0; i--)
        {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) st.pop();
            if(st.isEmpty()) nse[i] = n;
            else nse[i] = st.peek();
            st.push(i);
        }

        return nse;
    }

    private static int[] prevSmaller(int[] arr) {
        // code here
        int n = arr.length;
        int [] pse = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(0);
        pse[0] = -1;

        for(int i = 1; i<n; i++)
        {
            while(!st.isEmpty() && arr[i]<= arr[st.peek()]) st.pop();
            if(st.isEmpty()) pse[i] = -1;
            else pse[i] = st.peek();
            st.push(i);
        }

        return pse;
    }

}

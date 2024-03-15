package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.
Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        for(int i=0;i<k;i++)
        {
            pq.offer(arr[i]);
        }
        System.out.print(pq.peek() + " ");
        pq.remove(arr[0]);

        for(int i=k;i<n;i++)
        {
            pq.offer(arr[i]);
            System.out.print(pq.peek() + " ");

            pq.remove(arr[i-k+1]);
        }
    }
}

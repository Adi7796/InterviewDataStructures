package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElementsInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int K = 3;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0;i<K;i++)
        {
            minHeap.add(arr[i]);
        }

        for(int i=K; i<arr.length;i++)
        {
            minHeap.add(arr[i]);
            if(minHeap.size()>K) {
                minHeap.poll();
            }
        }

        System.out.println(K + " Largest elements in the array : ");
        while(!minHeap.isEmpty())
        {
            System.out.print(minHeap.poll() + " ");
        }
    }
}

/*
Time Complexity: O(N * log(K))
Auxiliary Space: O(K)
 */

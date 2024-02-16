package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestSmallestElement {
    public static void main(String[] args) {

        KthLargestSmallestElement obj = new KthLargestSmallestElement();
        int[] arr = {20, 10, 60, 30, 50, 40};
        int K = 3;
        obj.KthLargestElement(arr, K);
        obj.KthSmallestElement(arr, K);
    }

    public void KthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }

        for(int i=k; i< arr.length; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println("Kth largest element : " + pq.peek());
    }

    public void KthSmallestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<k; i++){
            pq.add(arr[i]);
        }

        for(int i=k; i<arr.length; i++){
            if(arr[i] < pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println("Kth Smallest element : " + pq.peek());
    }
}

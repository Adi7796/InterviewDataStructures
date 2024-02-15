package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamOfArray {

    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> minHeap = new PriorityQueue<>();
    public static void main(String[] args) {
        MedianOfStreamOfArray obj = new MedianOfStreamOfArray();
        obj.insertNum(3);
        obj.insertNum(1);
        obj.findMedium();
        obj.insertNum(5);
        obj.findMedium();
        obj.insertNum(4);
        obj.findMedium();
    }

    public void insertNum(double num){
        // we always want the max-heap to have more values than the min heap
        // hence we insert first into the max-heap

        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        // if the max-heap is greater in size, we reshuffle and insert into min heap
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        // if min heap is greater in size, we reshuffle and insert back to max heap
        else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
            }
        }

        public void findMedium(){
        double median = 0;
        // if the size is same median is the (largest element from left side + smallest element from right side)/2
        if(maxHeap.size() == minHeap.size()){
            median = (maxHeap.peek() + minHeap.peek())/2;
        }
        // otherwise the largest element in the max heap would be the median since the max heap has
        // one more element tha the one in min heap
        else{
            median = maxHeap.peek();
        }
            System.out.println("Median : " + median);
        }
}

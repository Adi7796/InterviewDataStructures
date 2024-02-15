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
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
            }
        }

        public void findMedium(){
        double median = 0;
        if(maxHeap.size() == minHeap.size()){
            double maxHeapValue = maxHeap.peek()/2;
            double minHeapValue = minHeap.peek()/2;
            median = maxHeapValue + minHeapValue;
        }
        else{
            median = maxHeap.peek();
        }
            System.out.println("Median : " + median);
        }
}

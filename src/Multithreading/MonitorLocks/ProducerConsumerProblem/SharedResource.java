package Multithreading.MonitorLocks.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    SharedResource(int capacity){
        sharedBuffer = new LinkedList<>();
        bufferSize = capacity;
    }

    public synchronized void produceItem(int item) throws InterruptedException {
        while(sharedBuffer.size()==bufferSize){
            System.out.println("Buffer is full, waiting for consumer to consume the item");
            wait();
        }
        sharedBuffer.add(item);
        System.out.println("Produced item : " + item);
        notify();
    }

    public synchronized void consumeItem() throws InterruptedException {
        while(sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, Waiting for producer to produce the item");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed item : " + item);
        notify();
    }
}

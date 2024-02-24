package Multithreading.MonitorLocks.ConsumerProducerExample;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main method start");
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(new ProducerTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumerTask(sharedResource));

        producerThread.start();
        consumerThread.start();

        System.out.println("Main method ends");
    }
}

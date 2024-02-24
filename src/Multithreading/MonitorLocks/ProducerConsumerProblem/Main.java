package Multithreading.MonitorLocks.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread = new Thread(() -> {
          for(int i=1;i<=6;i++){
              try {
                  sharedResource.produceItem(i);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i=1;i<=6;i++){
                try {
                    sharedResource.consumeItem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

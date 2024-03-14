package Multithreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {

        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResourceReadWrite resource1 = new SharedResourceReadWrite();
        Thread th1 = new Thread(() -> {
            resource1.produce(lock);
        });

        Thread th2 = new Thread(() -> {
            resource1.produce(lock);
        });

        SharedResourceReadWrite resource2 = new SharedResourceReadWrite();
        Thread th3 = new Thread(() -> {
            resource2.consume(lock);
        });

        th1.start();
        th2.start();
        th3.start();
    }
}

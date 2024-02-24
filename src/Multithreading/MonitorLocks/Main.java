package Multithreading.MonitorLocks;

public class Main {
    public static void main(String[] args) {

        TaskClass obj = new TaskClass();
        TaskClass obj2 = new TaskClass();
        Thread thread1 = new Thread(() -> obj.task1());
        Thread thread2 = new Thread(() -> obj.task2());
        // since obj2 calls task2, obj2 acquires a separate lock than obj1
        Thread thread4 = new Thread(() -> obj2.task2());
        Thread thread3 = new Thread(() -> obj.task3());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

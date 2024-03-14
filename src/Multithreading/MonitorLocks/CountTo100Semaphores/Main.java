package Multithreading.MonitorLocks.CountTo100Semaphores;

public class Main {

    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();

        Thread odd = new Thread(new TaskOdd(sharedPrinter, 10), "Odd Thread");
        Thread even = new Thread(new TaskEven(sharedPrinter, 10), "Even Thread");
        even.start();
        odd.start();
    }
}

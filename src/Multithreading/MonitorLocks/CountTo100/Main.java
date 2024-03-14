package Multithreading.MonitorLocks.CountTo100;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread odd = new Thread(new TaskEvenOdd(10, printer, false), "Odd Thread");
        Thread even = new Thread(new TaskEvenOdd(10, printer, true), "Even Thread");

        odd.start();
        even.start();
    }
}

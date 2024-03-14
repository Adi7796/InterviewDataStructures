package Multithreading.MonitorLocks.CountTo100;

public class Printer {
    private volatile boolean isOdd;

    public synchronized void printOddNumber(int number){
        while(isOdd)
        {
            try{
                System.out.println("Waiting for Even Thread to print .. ");
                wait();
            } catch( Exception e){

            }

        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        isOdd = true;
        notify();
    }

    public synchronized void printEvenNumber(int number){
        while(!isOdd)
        {
            try{
                System.out.println("Waiting for Odd thread to print .. ");
                wait();
            } catch( Exception e){

            }

        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        isOdd = false;
        notify();
    }
}

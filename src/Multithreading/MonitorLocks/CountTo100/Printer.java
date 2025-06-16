package Multithreading.MonitorLocks.CountTo100;

public class Printer {
    private volatile boolean isOddChance = true;
    private volatile boolean isEvenChance = false;

    public synchronized void printOddNumber(int number){
        while(isEvenChance)
        {
            try{
                System.out.println("Waiting for Even Thread to print .. ");
                wait();
            } catch( Exception e){

            }

        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        isEvenChance = true;
        isOddChance = false;
        notify();
    }

    public synchronized void printEvenNumber(int number){
        while(isOddChance)
        {
            try{
                System.out.println("Waiting for Odd thread to print .. ");
                wait();
            } catch( Exception e){

            }

        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        isEvenChance = false;
        isOddChance = true;
        notify();
    }
}

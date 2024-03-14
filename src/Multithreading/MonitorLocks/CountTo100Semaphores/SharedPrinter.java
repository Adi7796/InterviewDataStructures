package Multithreading.MonitorLocks.CountTo100Semaphores;

import java.util.concurrent.Semaphore;

public class SharedPrinter {

    Semaphore semEven = new Semaphore(0);
    Semaphore semOdd = new Semaphore(1);

    public void printEven(int number){
        try{
            semEven.acquire();
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        semOdd.release();
    }

    public void printOdd(int number){
        try{
            semOdd.acquire();
        }catch (Exception e){

        }
        System.out.println(Thread.currentThread().getName() + " : " + number);
        semEven.release();
    }
}

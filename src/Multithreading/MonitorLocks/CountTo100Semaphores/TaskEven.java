package Multithreading.MonitorLocks.CountTo100Semaphores;

public class TaskEven implements Runnable{

    private SharedPrinter sharedPrinter;
    private int max;

    public TaskEven(SharedPrinter sharedPrinter, int max) {
        this.sharedPrinter = sharedPrinter;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i=2;i<=max;i=i+2){
            sharedPrinter.printEven(i);
        }
    }
}

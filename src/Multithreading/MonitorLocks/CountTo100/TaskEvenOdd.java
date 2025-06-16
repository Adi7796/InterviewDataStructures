package Multithreading.MonitorLocks.CountTo100;

public class TaskEvenOdd implements Runnable{
    private int maxCount;
    private Printer printer;
    private boolean isEvenNumber;

    public TaskEvenOdd(int maxCount, Printer printer, boolean isEvenNumber) {
        this.maxCount = maxCount;
        this.printer = printer;
        this.isEvenNumber = isEvenNumber;
    }
    @Override
    public void run() {
        int startingNumber = isEvenNumber ? 2:1;
        int currentNumber = startingNumber;
        while(currentNumber <= maxCount)
        {
            if(isEvenNumber){
                printer.printEvenNumber(currentNumber);
            }else{
                printer.printOddNumber(currentNumber);
            }
            currentNumber = currentNumber + 2;
        }
    }
}

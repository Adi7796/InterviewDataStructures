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
        int number = isEvenNumber ? 2:1;

        while(number <= maxCount)
        {
            if(isEvenNumber){
                printer.printEvenNumber(number);
            }else{
                printer.printOddNumber(number);
            }
            number = number + 2;
        }
    }
}

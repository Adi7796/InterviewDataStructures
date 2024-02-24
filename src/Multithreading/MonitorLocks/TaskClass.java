package Multithreading.MonitorLocks;

public class TaskClass {

    public synchronized void task1(){
        try{
            System.out.println("Inside task 1");
            System.out.println("Waiting for task 1 to be completed ... ");
            // Thread 1 will acquire the monitor lock
            Thread.sleep(10000);
            System.out.println("Task 1 is completed");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void task2()
    {
        System.out.println("Outside synchonized block - task 2");
        synchronized (this){
            // since thread 1 has the monitor lock, this statement cannot be executed till thread 1 releases
            // the monitor lock, if the task was called on the same object
            // if the task was called on a different object, the lock wont effect this object
            // as the lock is acquired by each object separately
            System.out.println("Inside synchonized block - task 2");
        }
    }

    public void task3(){
        System.out.println("Inside task 3");
    }
}

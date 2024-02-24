package Multithreading.Intro;

public class RunnableClass implements Runnable{

    @Override
    public void run() {
        System.out.println("This statement is being executed by a new Thread implementing runnable- " + Thread.currentThread().getName());
    }
}

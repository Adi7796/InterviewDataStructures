package Multithreading.Intro;

public class ThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println("This statement is being executed by a new Thread extending Thread class- " + Thread.currentThread().getName());
    }
}

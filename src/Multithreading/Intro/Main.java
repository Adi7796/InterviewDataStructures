package Multithreading.Intro;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inside main method Thread name : " + Thread.currentThread().getName());
        RunnableClass runnableObject = new RunnableClass();
        Thread thread = new Thread(runnableObject);
        thread.start();
        System.out.println("Finished executing main method " + Thread.currentThread().getName());

        ThreadClass threadClass = new ThreadClass();
        threadClass.start();
    }
}

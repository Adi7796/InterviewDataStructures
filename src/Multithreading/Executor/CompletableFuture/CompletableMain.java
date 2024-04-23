package Multithreading.Executor.CompletableFuture;


import java.util.concurrent.*;

/*
 - Introduced in java 8
 - Helps in async programming
 - considered as advanced version of future
 - additional capability like chaining
 - supplyAsync initiates an async operation
 - if we want more control on Threads, we can pass Executor in the method
 - otherwise uses - Fork-Join Pool executor by default. Dynamically adjusts pool size

 */
public class CompletableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = null;
        try {
            poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                return "task complete";
            }, poolExecutor);

            System.out.println(completableFuture.get());
        } catch (Exception e) {

        }

        /*
            - thenApply & thenApplyAsync : enables chaining
                - applies a function to the result of prev async computation
                - returns a new completable future obj
                - thenApply is a synchronous execution - same thread which completed the last task
                completes the next task as well inside the thenApply
         */

        CompletableFuture<String> completableFutureChaining = CompletableFuture.supplyAsync(() ->
        {
            System.out.println("Thread name of supplyAsnyc : " + Thread.currentThread().getName());
            return "My name is ";
        }, poolExecutor).thenApply((String s) -> {
            System.out.println("Thread name of thenApply : " + Thread.currentThread().getName());
           return s + "Aditya";
        });

        System.out.println(completableFutureChaining.get());

        /*
         if we dont want the same thread to execute the next task as well
         and we want the next task to be asynchronous, we use thenApplyAsync

         thenApplyAsync - creates a new thread
        */

        CompletableFuture<String> completableFutureChainingAsync = CompletableFuture.supplyAsync(() ->
        {
            try {
                // Here the first thread will sleep for 5 secs
                System.out.println("Thread name of supplyAsync: " + Thread.currentThread().getName());
                Thread.sleep(5000);
                return "My name is ";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, poolExecutor).thenApplyAsync((String s) -> {
            // here it creates a default thread using fork join pool
            System.out.println("Thread name of thenApplyAsync: " + Thread.currentThread().getName());
            return "Aditya";
        });

        System.out.println(completableFutureChainingAsync.get());

        /*
        thenCompose , thenComposeAsync
        - chain together dependent async operations
        - when next async operations depends on the result of the prev async operation
        we can tie them together
        - For async tasks, we use these methods to bring order to async tasks
         */
    }

}

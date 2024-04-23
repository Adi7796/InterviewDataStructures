package Multithreading.Executor.Future;

import java.util.concurrent.*;

public class FutureClass1 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(() ->
        {
            try {
                // thread sleeping for 7 secs
                Thread.sleep(7000);
                System.out.println("This task is being executed by pool executor");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // since the thread is sleeping, the task is not done
        System.out.println("is Done : " + futureObj.isDone());
        try{
            // main - thread comes here and waits for 2 secs
            // this method will wait for 2 secs and then get the status of the thread/task
            // since the thread was sleeping for 7 secs and the main thread just waited for 2 secs
            // a timeout exception will be thrown
            futureObj.get(2, TimeUnit.SECONDS);
        } catch(TimeoutException | InterruptedException | ExecutionException e){
            System.out.println("Timeout exception");
        }

        try{
            // the future obj will wait till the task completes
            // then the future obj gets updated with the task status
            futureObj.get();
        } catch(InterruptedException | ExecutionException e){
        }

        System.out.println("isDone : " + futureObj.isDone());
        System.out.println("is Cancelled : " + futureObj.isCancelled());
    }
}

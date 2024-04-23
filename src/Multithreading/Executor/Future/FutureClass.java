package Multithreading.Executor.Future;

import java.util.concurrent.*;

/*
Future interface represents the results of an async task
 - allows to check the if the computation is complete
 - get the result of the executor task
 - take care of exception if any
 */
public class FutureClass {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS
                , new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureObj = poolExecutor.submit(() -> {
            System.out.println("This is the task being executed by the thread");
        });

        System.out.println(futureObj.isDone());
    }

}

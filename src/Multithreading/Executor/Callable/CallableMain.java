package Multithreading.Executor.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
Callable represents the task which needs to be executed like Runnable
- Difference :
    - Runnable does not have any return type
    - Callable has the capability to return a value
    - submit(Callable<T>)
 */
public class CallableMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> futureRunnableObj = poolExecutor.submit(() -> {
            System.out.println("Runnable task printing");
        });

        try{
            // runnable future obj returns a null value
            // as the runnable interface does not return anything
            Object obj = futureRunnableObj.get();
            System.out.println(obj == null);
        } catch(Exception e){

        }


        Future<Integer> futureCallableObj = poolExecutor.submit(() -> {
            System.out.println("Callable task printing");
            return 45;
        });

        System.out.println(futureCallableObj.get());


        /*
         2 ways to use callable :
            - Use Runnable interface
            - Pass the returnable object in the submit parameter
        */

        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureCallableObj1 = poolExecutor.submit(new MyRunnable(output), output);

        try{
            futureCallableObj1.get();
            // 1st way
            System.out.println("1st way : " + output.get(0));

            //2nd way
            List<Integer> result = futureCallableObj1.get();
            System.out.println("Second way : "+ result.get(0));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

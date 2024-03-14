package Multithreading.ReentrentLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
        boolean isAvailable = false;

        public void producer(ReentrantLock lock)
        {
            try {
                lock.lock();
                System.out.println("Lock acquired by " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
                isAvailable = true;
                Thread.sleep(4000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{
                lock.unlock();
                System.out.println("Lock released by " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
            }
        }
}

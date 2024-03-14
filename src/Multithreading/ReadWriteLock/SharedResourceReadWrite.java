package Multithreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResourceReadWrite {
    boolean isAvailable = false;

    public void produce(ReadWriteLock readWriteLock)
    {
        try {
            readWriteLock.readLock().lock();
            isAvailable = true;
            System.out.println("Read lock acquired by " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            readWriteLock.readLock().unlock();
            System.out.println("Read lock released by " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
        }
    }

    public void consume(ReadWriteLock readWriteLock)
    {
        try{
           readWriteLock.writeLock().lock();
           isAvailable = false;
            System.out.println("Write lock acquired by " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            readWriteLock.writeLock().unlock();
            System.out.println("Read lock released by " + Thread.currentThread().getName() + " : " + System.currentTimeMillis());
        }
    }
}

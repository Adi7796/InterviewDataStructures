package Multithreading.MonitorLocks.ConsumerProducerExample;

public class SharedResource {
    boolean isItemAvailable = false;

    public synchronized void addItem()
    {
        isItemAvailable = true;
        System.out.println("Item added by : " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        //Notifies all the waiting threads
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consume item method invoked by " + Thread.currentThread().getName());

        while(!isItemAvailable)
        {
            try{
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait();
                // Consumer Thread is waiting for the Producer Thread to add the item and make it available
                System.out.println("Item is available now");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Item consumed by : " + Thread.currentThread().getName());
        isItemAvailable = false;
    }
}

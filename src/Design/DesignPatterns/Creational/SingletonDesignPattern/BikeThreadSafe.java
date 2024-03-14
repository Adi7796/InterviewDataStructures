package Design.DesignPatterns.Creational.SingletonDesignPattern;

public class BikeThreadSafe {

    private static BikeThreadSafe bike;

    private BikeThreadSafe(){};

    /*
    for thread safety we use synchronized block
    alternatively we can also use synchronized keyword in the method --> used when the whole method needs to be thread safe
    block is more useful when we need thread safety only for a specific logic
     */
    public static BikeThreadSafe getBikeObject(){

        synchronized (BikeThreadSafe.class){
            if(bike == null)
                bike = new BikeThreadSafe();
        }
        return bike;
    }
}

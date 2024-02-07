package Design.SingletonDesignPattern;

public class Car {

    // this is called eager initialisation
    // private static Car carObject = new Car();
    private static Car carObject;
    private Car(){};

    public static Car getCarObject(){

        //this is called lazy initialisation
        if(carObject == null)
            carObject = new Car();

        return carObject;
    }
}

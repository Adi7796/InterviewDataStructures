package Design.DesignPatterns.Creational.SingletonDesignPattern;

public class Car {

    // this is called eager initialisation, this will load when the class is loaded as its static
    // private static Car carObject = new Car();
    private static Car carObject;
    private Car(){

        // uncomment this if we need the solution against breaking the singleton pattern using reflection api
//        if(carObject != null){
//            throw new RuntimeException("Trying to create a car object to break the singleton pattern");
//        }
    };

    public static Car getCarObject(){

        //this is called lazy initialisation
        /*
        object created only when the method is called
         */
        if(carObject == null)
            carObject = new Car();

        return carObject;
    }
}

package Design.SingletonDesignPattern;

public class Client {
    public static void main(String[] args) {

        Car carObject = Car.getCarObject();
        Car carObject2 = Car.getCarObject();
        System.out.println("Car1 hashcode : "+ carObject.hashCode());
        System.out.println("Car2 hashcode : "+ carObject2.hashCode());

        if(carObject.hashCode() == carObject2.hashCode())
            System.out.println(String.format("Only single object is created with hashcode %s", String.valueOf(carObject.hashCode())));
    }
}

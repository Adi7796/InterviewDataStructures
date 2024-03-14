package Design.DesignPatterns.Creational.SingletonDesignPattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {

        Car carObject = Car.getCarObject();
        Car carObject2 = Car.getCarObject();
        System.out.println("Car1 hashcode : "+ carObject.hashCode());
        System.out.println("Car2 hashcode : "+ carObject2.hashCode());

        if(carObject.hashCode() == carObject2.hashCode())
            System.out.println(String.format("Only single object is created with hashcode %s", String.valueOf(carObject.hashCode())));


        /* BREAKING SINGLETON PATTERN
        1) If somehow we can access the private constructor of the Car class, we can create as many objects of the Car class as we want
        for this we can use reflection API
        */

        Car car = Car.getCarObject();
        System.out.println("Car 1 Object breaking singleton : " + car.hashCode());

        Constructor<Car> constructor = Car.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Car car2 = constructor.newInstance();
        System.out.println("Car 2 Object breaking singleton : " + car2.hashCode());


        System.out.println();

        /*
        Solution for Reflection API ->
        if object exists ==> throw exception inside the constructor
         */

        /*
        2) Deserialization
        Solution --> implement readResolve Method  --> uncomment in the BreakingSingletonPattern class
         */

        BreakingSingletonPattern breakingSingletonPattern = BreakingSingletonPattern.getObject();
        try {
            System.out.println("Breaking Singleton using Deserialization");
            System.out.println(breakingSingletonPattern.hashCode());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("abc.ob"));
            objectOutputStream.writeObject(breakingSingletonPattern);

            System.out.println("Serialization done ..");

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("abc.ob"));
            BreakingSingletonPattern breakingSingletonPattern1 = (BreakingSingletonPattern) objectInputStream.readObject();

            System.out.println(breakingSingletonPattern1.hashCode());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /*
        3) break using Cloning
         */

        System.out.println();
        System.out.println("Breaking using Cloning");
        BreakingSingletonPatternCloning breakingSingletonPatternCloning = BreakingSingletonPatternCloning.getObject();
        System.out.println(breakingSingletonPatternCloning.hashCode());

        BreakingSingletonPatternCloning breakingSingletonPatternCloning1 = (BreakingSingletonPatternCloning) breakingSingletonPatternCloning.clone();
        System.out.println(breakingSingletonPatternCloning1.hashCode());
    }
}

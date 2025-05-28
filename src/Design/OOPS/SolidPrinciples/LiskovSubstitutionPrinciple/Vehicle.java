package Design.OOPS.SolidPrinciples.LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    public int getNoOfWheels() {
        return 2;
    }

    public Boolean hasEngine(){
        return true;
    }

    public static class Car extends Vehicle{
        @Override
        public int getNoOfWheels() {
            return 4;
        }
    }

    public static class MotorCycle extends Vehicle{

    }

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new MotorCycle());

        for(Vehicle vehicle : vehicleList){
            System.out.println(vehicle.hasEngine().toString());
        }

        // this would work, but what if we add another class called Cycle which doesn't have an engine
        // now if we do a --> System.out.println(vehicle.hasEngine().toString());
        // we will get a NPE as vehicle.hasEngine() is null
        // hence we could not substitute a child class
        // to counter this problem see Vehicle2 class
    }

    public static class Cycle extends Vehicle{
        @Override
        public Boolean hasEngine(){
            return null;
        }
    }
}

package Design.OOPS.SolidPrinciples.LiskovSubstitutionPrinciple;

import java.util.ArrayList;
import java.util.List;

/*
put only the generic methods inside the Vehicle class
 */
public class Vehicle2 {
    public int getNoOfWheels() {
        return 2;
    }

    public static class EngineVehicle extends Vehicle2{
        public Boolean hasEngine(){
            return true;
        }
    }

    public static class Car extends EngineVehicle{
        @Override
        public int getNoOfWheels() {
            return 4;
        }
    }

    public static class MotorCycle extends EngineVehicle {

    }

    public static class Cycle extends Vehicle2{

    }

    public static void main(String[] args) {
        List<Vehicle2> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new MotorCycle());
        vehicleList.add(new Cycle());

        for(Vehicle2 vehicle : vehicleList)
        {
            // here we wont get the option to print the engine as Vehicle is ot aware about the hasEngine method
            // as that method is present in the child classes
            System.out.println(vehicle.getNoOfWheels());
        }
    }
}



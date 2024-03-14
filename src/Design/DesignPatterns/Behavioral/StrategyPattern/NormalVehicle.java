package Design.DesignPatterns.Behavioral.StrategyPattern;

public class NormalVehicle extends Vehicle{
    NormalVehicle(){
        super(new NormalDriveStrategy());
    }
}

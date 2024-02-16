package Design.DesignPatterns.StrategyPattern;

public class RacingVehicle extends Vehicle{
    RacingVehicle(){
        super(new SportsDriveStrategy());
    }
}

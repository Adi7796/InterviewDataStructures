package Design.DesignPatterns.Behavioral.StrategyPattern;

public class RacingVehicle extends Vehicle{
    RacingVehicle(){
        super(new SportsDriveStrategy());
    }
}

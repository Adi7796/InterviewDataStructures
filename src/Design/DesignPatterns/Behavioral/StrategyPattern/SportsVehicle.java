package Design.DesignPatterns.Behavioral.StrategyPattern;

public class SportsVehicle extends Vehicle{
    SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}

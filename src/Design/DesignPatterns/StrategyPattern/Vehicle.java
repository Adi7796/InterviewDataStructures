package Design.DesignPatterns.StrategyPattern;

public class Vehicle {

    DriveStrategy driveStrategyObj;

    public Vehicle(DriveStrategy driveStrategyObj){
        this.driveStrategyObj = driveStrategyObj;
    }

    public void drive(){
        driveStrategyObj.drive();
    }
}

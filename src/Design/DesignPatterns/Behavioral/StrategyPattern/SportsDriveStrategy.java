package Design.DesignPatterns.Behavioral.StrategyPattern;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Vehicle uses Sports drive strategy");
    }
}

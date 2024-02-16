package Design.DesignPatterns.StrategyPattern;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Vehicle uses Sports drive strategy");
    }
}

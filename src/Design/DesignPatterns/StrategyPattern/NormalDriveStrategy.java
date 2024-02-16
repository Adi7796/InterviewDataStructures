package Design.DesignPatterns.StrategyPattern;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Vehicle uses Normal Drive Strategy");
    }
}

package Design.DesignPatterns.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle normalVehicle = new NormalVehicle();
        normalVehicle.drive();

        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();

        Vehicle racingVehicle = new RacingVehicle();
        racingVehicle.drive();
    }
}

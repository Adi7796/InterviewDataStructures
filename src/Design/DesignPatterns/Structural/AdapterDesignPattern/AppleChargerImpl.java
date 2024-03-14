package Design.DesignPatterns.Structural.AdapterDesignPattern;

public class AppleChargerImpl implements AppleCharger{

    @Override
    public void chargePhone() {
        System.out.println("Your phone is being charged by AppleCharger");
    }
}

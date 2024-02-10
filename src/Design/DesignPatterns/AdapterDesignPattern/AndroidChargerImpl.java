package Design.DesignPatterns.AdapterDesignPattern;

public class AndroidChargerImpl implements  AndroidCharger{

    @Override
    public void chargeAndroidPhone() {
        System.out.println("Your phone is being charged with Android charger");
    }
}

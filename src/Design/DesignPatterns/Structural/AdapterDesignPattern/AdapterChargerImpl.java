package Design.DesignPatterns.Structural.AdapterDesignPattern;

public class AdapterChargerImpl implements AppleCharger{

    private final AndroidCharger androidCharger;

    public AdapterChargerImpl(AndroidCharger androidCharger){
        this.androidCharger = androidCharger;
    }
    @Override
    public void chargePhone() {
        System.out.println("Phone is using an adapter to charge");
        androidCharger.chargeAndroidPhone();
    }
}

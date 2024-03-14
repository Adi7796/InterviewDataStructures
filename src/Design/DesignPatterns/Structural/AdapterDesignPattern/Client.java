package Design.DesignPatterns.Structural.AdapterDesignPattern;

public class Client {
    public static void main(String[] args) {
        Iphone iphone = new Iphone(new AppleChargerImpl());

        iphone.chargeIphone();

        // Now suppose we don't have an Apple Charger and need to charge
        // iphone using only the android charger
        // hence we need an adapter that can make an iphone charge
        // with an android charger

        AppleCharger newAdapterAppleCharger = new AdapterChargerImpl(new AndroidChargerImpl());
        Iphone iphone1 = new Iphone(newAdapterAppleCharger);
        iphone1.chargeIphone();
    }
}

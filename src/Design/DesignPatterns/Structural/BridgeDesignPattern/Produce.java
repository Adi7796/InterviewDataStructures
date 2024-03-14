package Design.DesignPatterns.Structural.BridgeDesignPattern;

public class Produce implements WorkShop{
    @Override
    public void work() {
        System.out.println("Produced");
    }
}

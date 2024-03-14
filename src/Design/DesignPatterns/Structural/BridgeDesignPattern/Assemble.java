package Design.DesignPatterns.Structural.BridgeDesignPattern;

public class Assemble implements WorkShop{

    @Override
    public void work() {
        System.out.println("And");
        System.out.println("Assembled");
    }
}

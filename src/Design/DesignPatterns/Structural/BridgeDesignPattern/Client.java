package Design.DesignPatterns.Structural.BridgeDesignPattern;

public class Client {
    public static void main(String[] args) {

        Vehicle bike = new Bike(new Produce(), new Assemble());
        Vehicle bus = new Bus(new Produce(), new Assemble());

        bike.manufacture();
        bus.manufacture();
    }
}

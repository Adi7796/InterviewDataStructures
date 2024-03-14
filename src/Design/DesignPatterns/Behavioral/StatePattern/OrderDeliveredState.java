package Design.DesignPatterns.Behavioral.StatePattern;

public class OrderDeliveredState implements FoodOrderState{
    @Override
    public void transitionToNextState(FoodOrder foodOrder) {
        System.out.println("Order already delivered");
    }

    @Override
    public void showStatus() {
        System.out.println("Order delivered successfully");
    }
}

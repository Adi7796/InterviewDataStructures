package Design.DesignPatterns.StatePattern;

public class OrderOutForDeliveryState implements FoodOrderState{
    @Override
    public void transitionToNextState(FoodOrder foodOrder) {
        foodOrder.setFoodOrderState(new OrderDeliveredState());
    }

    @Override
    public void showStatus() {
        System.out.println("Order out for delivery");
    }
}

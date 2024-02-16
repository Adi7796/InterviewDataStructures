package Design.DesignPatterns.StatePattern;

public class OrderPickedUpState implements FoodOrderState{
    @Override
    public void transitionToNextState(FoodOrder foodOrder) {
        foodOrder.setFoodOrderState(new OrderOutForDeliveryState());
    }

    @Override
    public void showStatus() {
        System.out.println("Order picked up by the delivery agent");
    }
}

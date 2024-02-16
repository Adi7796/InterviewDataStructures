package Design.DesignPatterns.StatePattern;

public class OrderPreparedState implements FoodOrderState{
    @Override
    public void transitionToNextState(FoodOrder foodOrder) {
        foodOrder.setFoodOrderState(new OrderPickedUpState());
    }

    @Override
    public void showStatus() {
        System.out.println("Order prepared, ready to be picked up");
    }
}

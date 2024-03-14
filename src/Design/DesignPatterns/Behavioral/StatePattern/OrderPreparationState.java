package Design.DesignPatterns.Behavioral.StatePattern;

public class OrderPreparationState implements FoodOrderState{
    @Override
    public void transitionToNextState(FoodOrder foodOrder) {
        foodOrder.setFoodOrderState(new OrderPreparedState());
    }

    @Override
    public void showStatus() {
        System.out.println("Order Preparation State");
    }
}

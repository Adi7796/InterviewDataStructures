package Design.DesignPatterns.Behavioral.StatePattern;

public class OrderInitiatedState implements FoodOrderState{
    @Override
    public void transitionToNextState(FoodOrder foodOrder) {
        foodOrder.setFoodOrderState(new OrderPreparationState());
    }

    @Override
    public void showStatus() {
        System.out.println("Order initiated successfully ");
    }
}

package Design.DesignPatterns.StatePattern;

public class Main {
    public static void main(String[] args) {
        FoodOrder foodOrder = new FoodOrder();

        foodOrder.showCurrentState();
        foodOrder.transitionToNextState();

        foodOrder.showCurrentState();
        foodOrder.transitionToNextState();

        foodOrder.showCurrentState();
        foodOrder.transitionToNextState();

        foodOrder.showCurrentState();
        foodOrder.transitionToNextState();

        foodOrder.showCurrentState();
        foodOrder.transitionToNextState();

        foodOrder.transitionToNextState();
        foodOrder.showCurrentState();

        foodOrder.transitionToNextState();
    }
}

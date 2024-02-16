package Design.DesignPatterns.StatePattern;

public interface FoodOrderState {
    void transitionToNextState(FoodOrder foodOrder);
    void showStatus();
}

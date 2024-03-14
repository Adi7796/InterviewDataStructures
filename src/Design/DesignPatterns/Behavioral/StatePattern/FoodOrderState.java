package Design.DesignPatterns.Behavioral.StatePattern;

public interface FoodOrderState {
    void transitionToNextState(FoodOrder foodOrder);
    void showStatus();
}

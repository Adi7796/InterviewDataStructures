package Design.DesignPatterns.StatePattern;

public class FoodOrder {
    FoodOrderState foodOrderState = new OrderInitiatedState();

    public void setFoodOrderState(FoodOrderState foodOrderState){
        this.foodOrderState = foodOrderState;
    }

    public void transitionToNextState(){
        foodOrderState.transitionToNextState(this);
    }

    public void showCurrentState(){
        foodOrderState.showStatus();
    }
}

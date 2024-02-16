package Design.DesignPatterns.DecoratorPattern;

public class ExtraMushroomToppings extends ToppingDecorator{
    BasePizza basePizza;

    ExtraMushroomToppings(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int getCost() {
        return basePizza.getCost() + 50;
    }
}

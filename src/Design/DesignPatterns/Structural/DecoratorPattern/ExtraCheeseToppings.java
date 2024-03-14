package Design.DesignPatterns.Structural.DecoratorPattern;

public class ExtraCheeseToppings extends ToppingDecorator{

    BasePizza basePizza;

    ExtraCheeseToppings(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int getCost() {
        return basePizza.getCost() + 20;
    }
}

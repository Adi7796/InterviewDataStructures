package Design.DesignPatterns.Structural.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new ExtraCheeseToppings(new FarmhousePizza());
        System.out.println(basePizza.getCost());

        BasePizza basePizza1 = new ExtraMushroomToppings(new ExtraCheeseToppings(new PepperoniPizza()));
        System.out.println(basePizza1.getCost());
    }
}

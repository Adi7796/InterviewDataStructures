package Design.OOPS.SolidPrinciples.InterfaceSegmentedPrinciple;

/*
Here the waiter will not wash dishes and cook food, but we still need to implement those methods
hence we need to create interfaces in such a way that the classes implementing them should not have to implement
methods that are not related to the implementing classes

Instead create 3 different Interfaces for - Waiter, Cook and DishWasher
 */
public class Waiter implements RestaurantEmployee{


    @Override
    public void washDishes() {
        // not my job
    }

    @Override
    public void serveCustomers() {
        System.out.println("Serving the customers");
    }

    @Override
    public void cookFood() {
        // not my job
    }
}

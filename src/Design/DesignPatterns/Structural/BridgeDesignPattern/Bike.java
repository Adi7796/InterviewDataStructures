package Design.DesignPatterns.Structural.BridgeDesignPattern;

public class Bike extends Vehicle{

    Bike(WorkShop productionWorkshop, WorkShop assembleWorkshop)
    {
        super(productionWorkshop, assembleWorkshop);
    }
    @Override
    void manufacture() {
        System.out.println("Bike");
        productionWorkshop.work();
        assembleWorkshop.work();
    }
}

package Design.DesignPatterns.Structural.BridgeDesignPattern;

public class Bus extends Vehicle{

    Bus(WorkShop productionWorkshop, WorkShop assembleWorkshop){
        super(productionWorkshop, assembleWorkshop);
    }
    @Override
    void manufacture() {
        System.out.println("Bus");
        productionWorkshop.work();
        assembleWorkshop.work();
    }
}

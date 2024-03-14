package Design.DesignPatterns.Structural.BridgeDesignPattern;

abstract public class Vehicle {

    protected WorkShop productionWorkshop;
    protected WorkShop assembleWorkshop;

    protected Vehicle(WorkShop productionWorkshop, WorkShop assembleWorkshop)
    {
        this.assembleWorkshop = assembleWorkshop;
        this.productionWorkshop = productionWorkshop;
    }
    abstract void manufacture();
}

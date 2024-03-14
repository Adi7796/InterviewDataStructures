package Design.DesignPatterns.Creational.AbstractDesignFactoryPattern;

public class AndroidDevAbstractFactoryImpl extends EmployeeAbstractFactory{
    @Override
    public Employee getEmployee() {
        return new AndroidDeveloper();
    }
}

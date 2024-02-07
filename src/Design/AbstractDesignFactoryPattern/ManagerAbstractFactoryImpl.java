package Design.AbstractDesignFactoryPattern;

public class ManagerAbstractFactoryImpl extends EmployeeAbstractFactory{
    @Override
    public Employee getEmployee() {
        return new Manager();
    }
}

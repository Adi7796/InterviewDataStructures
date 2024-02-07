package Design.AbstractDesignFactoryPattern;

public class AndroidDevAbstractFactoryImpl extends EmployeeAbstractFactory{
    @Override
    public Employee getEmployee() {
        return new AndroidDeveloper();
    }
}

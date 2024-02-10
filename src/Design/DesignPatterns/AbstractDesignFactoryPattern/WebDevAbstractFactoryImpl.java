package Design.DesignPatterns.AbstractDesignFactoryPattern;

public class WebDevAbstractFactoryImpl extends EmployeeAbstractFactory{

    @Override
    public Employee getEmployee(){
        return new WebDeveloper();
    }
}

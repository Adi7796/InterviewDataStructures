package Design.DesignPatterns.AbstractDesignFactoryPattern;

// inserting another layer after factory.
// So client -> factory -> abstract factory -> object creation
public abstract class EmployeeAbstractFactory {
    public abstract Employee getEmployee();
}

package Design.DesignPatterns.Creational.AbstractDesignFactoryPattern;

public class EmployeeFactory {

    public static Employee getEmployeeObject(EmployeeAbstractFactory factory){
         return factory.getEmployee();
    }
}

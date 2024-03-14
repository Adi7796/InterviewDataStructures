package Design.DesignPatterns.Creational.FactoryDesignPattern;

public class EmployeeClient {
    public static void main(String[] args) {

        Employee employee1 = EmployeeFactory.getEmployeeObject("AndroidDeveloper");

        System.out.println(employee1.getSalary());

        Employee employee2 = EmployeeFactory.getEmployeeObject("WebDeveloper");

        System.out.println(employee2.getSalary());
    }
}

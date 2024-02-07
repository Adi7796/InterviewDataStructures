package Design.AbstractDesignFactoryPattern;

public class EmployeeClient {
    public static void main(String[] args) {

        Employee employee1 = EmployeeFactory.getEmployeeObject(new AndroidDevAbstractFactoryImpl());

        System.out.print(employee1.getName());
        System.out.println(" and my salary is : " + employee1.getSalary());

        Employee employee2 = EmployeeFactory.getEmployeeObject(new WebDevAbstractFactoryImpl());
        System.out.print(employee2.getName());
        System.out.println(" and my salary is : " + employee2.getSalary());

        Employee employee3 = EmployeeFactory.getEmployeeObject(new ManagerAbstractFactoryImpl());
        System.out.print(employee3.getName());
        System.out.print(" and my salary is : " + employee3.getSalary());
    }
}

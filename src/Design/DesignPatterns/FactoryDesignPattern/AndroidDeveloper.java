package Design.DesignPatterns.FactoryDesignPattern;

public class AndroidDeveloper implements Employee {
    @Override
    public int getSalary() {
        System.out.println("This is the salary of an Android Developer : ");
        return 50000;
    }
}

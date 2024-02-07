package Design.FactoryDesignPattern;

public class WebDeveloper implements Employee{
    @Override
    public int getSalary() {
        System.out.println("This is the salary of a web developer : ");
        return 60000;
    }
}

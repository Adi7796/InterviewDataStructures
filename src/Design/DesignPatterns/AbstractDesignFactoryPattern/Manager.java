package Design.DesignPatterns.AbstractDesignFactoryPattern;

public class Manager implements Employee{
    @Override
    public int getSalary() {
        return 100000;
    }

    @Override
    public String getName() {
        return "I am a manager";
    }
}

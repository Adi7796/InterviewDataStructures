package Design.DesignPatterns.Creational.AbstractDesignFactoryPattern;

public class WebDeveloper implements Employee {
    @Override
    public int getSalary() {
        return 60000;
    }

    @Override
    public String getName() {
        return "I am a web developer";
    }
}

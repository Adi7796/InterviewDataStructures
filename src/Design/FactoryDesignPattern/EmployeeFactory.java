package Design.FactoryDesignPattern;

public class EmployeeFactory {

    public static Employee getEmployeeObject(String empType){

        if(empType.equalsIgnoreCase("AndroidDeveloper"))
            return new AndroidDeveloper();
        else if(empType.equalsIgnoreCase("WebDeveloper"))
            return new WebDeveloper();
        else return null;
    }
}

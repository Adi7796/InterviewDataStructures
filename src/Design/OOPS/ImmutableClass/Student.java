package Design.OOPS.ImmutableClass;

import java.util.HashMap;
import java.util.Map;

// Class should be final so that we cannot extend this class
public final class Student {

    // fields should be private and final so that fields cant
    // be accessed directly from outside class and the value cant be changed due to final
    private final String name;
    private final int regNo;
    private final Map<String, String> metaData;

    public Student(String name, int regNo, Map<String, String> metaData)
    {
        this.name = name;
        this.regNo = regNo;

        // Creating Map object with reference to HashMap
        // Declaring object of string type
        Map<String, String> tempMap = new HashMap<>();
        for(Map.Entry<String, String> entry : metaData.entrySet())
        {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.metaData = tempMap;
    }

    public String getName(){
        return this.name;
    }

    public int getRegNo(){
        return this.regNo;
    }


    // creating deep copy of the meta object
    // so that getter method returns a copy rather than the actual object of the map
    public Map<String, String> getMetaData(){
        Map<String, String> tempMap = new HashMap<>();
        for(Map.Entry<String, String> entry : this.metaData.entrySet())
        {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}

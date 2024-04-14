package Java_8_Features.Optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamDemo {

    Map<Integer, Employee> empMap = new HashMap<>();

    public Optional<Employee> getEmployee(Integer empId)
    {
        return Optional.ofNullable(empMap.get(empId));
    }
    public static void main(String[] args) {
        StreamDemo obj = new StreamDemo();
        Optional<Employee> employee = obj.getEmployee(123);

        if(employee.isPresent()){
            System.out.println(employee.get().getName());
        } else {
            System.out.println("No employee found with empid : " + 123);
        }
    }
}

/*
Optional Methods -
1) empty() - Optional < Person > person = Optional.empty();
Creates an empty Optional object

2) of() -
Person person = new Person();
Optional<Person> optional = Optional.of(person);

Creates a non-null Optional for person object
if object is null throws NPE

3) ofNullable()
Person person = new Person();
Optional<Person> optional = Optional.ofNullable(person);

Used when we are not sure if the object is null or not
 */
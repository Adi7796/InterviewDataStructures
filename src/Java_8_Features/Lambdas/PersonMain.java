package Java_8_Features.Lambdas;

import java.util.ArrayList;
import java.util.List;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person(27, "Aditya", "India");
        Person person1 = new Person(56, "Daren", "China");
        Person person2 = new Person(13, "Jane", "Russia");
        Person person3 = new Person(45, "Abhi", "India");
        Person person4 = new Person(33, "Tina", "USA");

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        System.out.println("name - ");
        PersonService personService = new PersonService();
        personList = personService.getPersonListInSortedName(personList);
        personList.forEach(System.out::println);

        System.out.println("Age - ");
        personList = personService.getPersonListInDescendingAge(personList);
        personList.forEach(System.out::println);
    }
}

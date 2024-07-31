package Java_8_Features.CollectionImprovements;

import Java_8_Features.Lambdas.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorImprovements {
    public static void main(String[] args) {

        Person person1 = new Person(21, "Zeeshan", "India");
        Person person2 = new Person(25, "Aditya", "India");
        Person person3 = new Person(31, "Mike", "USA");
        Person person4 = new Person(40, "Taylor", "Japan");
        Person person5 = new Person(21, "Nisha", "India");

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(person1);
        personArrayList.add(person2);
        personArrayList.add(person3);
        personArrayList.add(person4);
        personArrayList.add(person5);

        System.out.println("Increasing order of age, if age matches, increasing order of name:- ");
        Collections.sort(personArrayList, Comparator.comparing(Person::getAge).thenComparing(Person::getName));

        personArrayList.forEach(System.out::println);

        System.out.println("Decreasing order of age, if age matches, decreasing order of name:- ");
        Collections.sort(personArrayList, Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed());

        personArrayList.forEach(System.out::println);
    }
}

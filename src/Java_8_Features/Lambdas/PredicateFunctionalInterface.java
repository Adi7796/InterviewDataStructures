package Java_8_Features.Lambdas;

import java.util.function.Predicate;

// Predicate takes in a value as argument and produces a boolean value
public class PredicateFunctionalInterface {
    public static void main(String[] args) {
        Person person = new Person(27, "Aditya", "India");
        Person person1 = new Person(56, "Daren", "India");

        Predicate<Person> predicateGreaterThan25 = p -> p.getAge() > 25;
        Predicate<Person> predicateLessThan50 = p -> p.getAge() < 50;

        Predicate<Person> andPredicate = predicateGreaterThan25.and(predicateLessThan50);
        Predicate<Person> orPredicate = predicateGreaterThan25.or(predicateLessThan50);

        System.out.println(person + " Greater than 25 : " + predicateGreaterThan25.test(person));

        System.out.println(person1 + " Greater than 25 and less than 50 : " + andPredicate.test(person1));
        System.out.println(person1 + " Greater than 25 or less than 50 : " + orPredicate.test(person1));
    }
}

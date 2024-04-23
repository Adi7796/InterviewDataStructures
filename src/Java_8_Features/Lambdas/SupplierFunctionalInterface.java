package Java_8_Features.Lambdas;

import java.util.function.Predicate;
import java.util.function.Supplier;

// Supplier does not take any argument but produces a value when get is called
public class SupplierFunctionalInterface {
    public static void main(String[] args) {

        Supplier<Person> supplier = () -> new Person(25, "Jane", "India");

        Predicate<Person> predicate = p -> p.getAge() < 30;

        System.out.println(predicate.test(supplier.get()));
        System.out.println("Name : " + supplier.get().getName());
    }
}

package Java_8_Features.Lambdas;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Consumer takes in an input of type T and does not produce anything
public class ConsumerFunctionalInterface
{
    public static void main(String[] args) {
        Consumer<String> consumer1 = s -> System.out.println("Name is : " + s);
        Consumer<String> consumer2 = s -> System.out.println("His Name is : " + s);

        consumer1.andThen(consumer2).accept("Aditya");

        BiConsumer<String, Integer> biConsumer = (s,t) -> System.out.println("Name : " + s + " | Age : " + t);
        biConsumer.accept("Aditya", 27);
    }
}

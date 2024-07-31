package Java_8_Features.CollectionImprovements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorImprovements {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("banana");
        fruits.add("apple");
        fruits.add("mango");
        fruits.add("papaya");
        fruits.add("grapes");

        //Before java 8
        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //After java 8
        // no need to write the whole while loop
        System.out.println("JAVA 8 :- ");
        Iterator<String> iterator1 = fruits.iterator();
        iterator1.forEachRemaining((fruit) -> System.out.println(fruit));
    }
}

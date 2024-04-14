package Java_8_Features.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        stream.forEach(p-> System.out.println(p));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        Stream<String> stream1= list.stream();
        stream1.forEach(s -> System.out.println(s));

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);

        intList.stream()
                .filter(i -> i%3 == 0)
                .forEach(i -> System.out.println(i));

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(27, "Aditya"));
        personList.add(new Person(54, "Riya"));
        personList.add(new Person(23, "Rahul"));
        personList.add(new Person(67, "Karan"));
        personList.add(new Person(45, "Daren"));

        personList.stream()
                .filter(p -> p.getAge() > 18)
                .filter(p -> p.getAge() < 50)
                .forEach(System.out::println);

        // Flat Map

        /*
        used to convert :-
        Stream<String[]> --> flat map --> Stream<String>
        Stream<List<String>> --> flat map --> Stream<String>
        Stream<Set<String>> --> flat map --> Stream<String>

        The reason to use flat map is that intermediate methods such as filter() and distinct()
        do not work on streams of Collections.

        These methods only work on streams of primitives or objects.
        So, we need to flatten our stream before using these intermediate functions.
         */
        List<List<String>> tempList = new ArrayList<>();
        tempList.add(Arrays.asList("a","b","c"));
        tempList.add(Arrays.asList("d","e","f"));
        tempList.add(Arrays.asList("g","h","i"));
        tempList.add(Arrays.asList("j","k","l"));

        //Created a stream from the list.
        Stream<List<String>> st = tempList.stream();
        // Flattened the stream.
        Stream<String> strStream = st.flatMap(s-> s.stream());
        //Applied filter on flattened stream.
        strStream.filter(x -> "b".equals(x) || "c".equals(x))
                        .forEach(System.out::println);

        // Executed above code in a single line
        tempList.stream()
                .flatMap(s -> s.stream())
                .filter(x -> "a".equals(x))
                .forEach(System.out::println);
    }
}

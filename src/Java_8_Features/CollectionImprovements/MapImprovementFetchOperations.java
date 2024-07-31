package Java_8_Features.CollectionImprovements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MapImprovementFetchOperations {
    public static void main(String[] args) {
        Map<String, Integer> fruitsMap = new HashMap<>();
        fruitsMap.put("apple", 20);

        // FETCH OPERATIONS
        /*
        Now we need to add 20 bananas to map
         */
        if(fruitsMap.containsKey("banana"))
        {
            fruitsMap.put("banana", fruitsMap.get("banana") + 20);
        } else {
            fruitsMap.put("banana", 20);
        }

        System.out.println(fruitsMap);

        // Using the above code is cumbersome
        // we can use getOrDefault() to put orange inside our map in one line

        fruitsMap.put("orange", fruitsMap.getOrDefault("orange", 0) + 20);
        fruitsMap.put("banana", fruitsMap.getOrDefault("banana", 0) + 20);

        System.out.println(fruitsMap);

        //putIfAbsent() --> puts a value inside the map for a key which is not present
        // skips the update for key which is present in the map

        fruitsMap.putIfAbsent("apple", 50);
        fruitsMap.putIfAbsent("grapes", 70);

        System.out.println(fruitsMap);

        /*
        * compute()
        * computes a new mapping given the key and its existing value
        * this method returns the computed value
        * if the key is not present, exception is thrown */

        System.out.println("compute :- ");
        int price = fruitsMap.compute("banana", (k,v) -> v + 100);
        System.out.println(price);
        System.out.println(fruitsMap);

        /* computeIfAbsent()
        * returns 1) the original value if the key is already present in the map
        *         2) the computed value if the key is not present in the map
        * */

        System.out.println("computeIfAbsent :- ");
        System.out.println(fruitsMap.computeIfAbsent("grapes", v ->100));
        System.out.println(fruitsMap.computeIfAbsent("melon", v->200));
        System.out.println(fruitsMap);

        /* computeIfPresent()
         * returns 1) null value if the key is not present in the map
         *         2) the computed value if the key is present in the map
         * */

        System.out.println("computeIfPresent :- ");
        System.out.println(fruitsMap.computeIfPresent("orange", (k,v) -> v+500));
        System.out.println(fruitsMap.computeIfPresent("figs", (k,v) -> v + 200));
        System.out.println(fruitsMap);
    }
}

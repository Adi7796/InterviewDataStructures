package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("ogd");
        list.add("god");
        list.add("atc");

        System.out.println("Final list : "+ findAnagrams(list));
    }

    public static ArrayList<ArrayList<String>> findAnagrams(ArrayList<String> list)
    {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();

        for(String str : list)
        {
            HashMap<Character, Integer> tempMap = new HashMap<>();

            // Counting the frequency of the
            // characters present in a string
            for(int i=0; i<str.length(); i++)
            {
                char x = str.charAt(i);
                if(tempMap.containsKey(x))
                    tempMap.put(x, tempMap.get(x) + 1);
                else
                    tempMap.put(x, 1);
            }

            // If the same frequency of characters
            // are already present then add that
            // string into that arraylist otherwise
            // created a new arraylist and add that string
            if(map.containsKey(tempMap)){
                map.get(tempMap).add(str);
            }
            else{
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(tempMap, newList);
            }
        }

        ArrayList<ArrayList<String>> finalList = new ArrayList<>();
        for(HashMap<Character, Integer> map1 : map.keySet())
        {
            finalList.add(map.get(map1));
        }
        return finalList;
    }
}

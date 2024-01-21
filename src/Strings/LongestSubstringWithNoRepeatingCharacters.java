package Strings;

import java.util.HashMap;

public class LongestSubstringWithNoRepeatingCharacters {
    public static void main(String[] args) {
        String str = "babccbacd";
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, max_length = Integer.MIN_VALUE;

        while(end < str.length())
        {
            char currentChar = str.charAt(end);
            if(map.containsKey(currentChar)){
                start = Math.max(start, map.get(currentChar) + 1);
            }
            map.put(currentChar, end);
            max_length = Math.max(max_length, end - start + 1);
            end++;
        }

        System.out.println("Maximum length of the longest substring : "+ str.substring(start, end) + " with no repeating characters : "+ max_length);
    }
}

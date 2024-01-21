package Strings;

import java.util.ArrayList;
import java.util.HashMap;

public class AnagramSubstringSearch {
    public static void main(String[] args) {
        String str = "BACDEGABCDEA";
        String pattern = "ABCDE";

        HashMap<Character, Integer> patternMap = new HashMap<>();

        // initialise a hash map for the pattern string
        for(int i=0; i<pattern.length(); i++){
            char patternchar = pattern.charAt(i);
            if(patternMap.containsKey(patternchar))
                patternMap.put(patternchar, patternMap.get(patternchar) + 1);
            else
                patternMap.put(patternchar, 1);
        }

        int start = 0, matchedElement = 0;
        ArrayList<String> anagramList = new ArrayList<>();

        for(int i=0; i<str.length(); i++)
        {
            char currentChar = str.charAt(i);
            // if the current char is present in the pattern map, that means this char will contribute to our ans and we decrease the freq of this character
            // if the freq of this character reaches 0, that means we have reached the maximum number of times this character was to be matched
            // and hence we increment the matched element
            if(patternMap.containsKey(currentChar))
            {
               patternMap.put(currentChar,patternMap.get(currentChar) -1);
               if(patternMap.get(currentChar) == 0)
                   matchedElement++;
            }

            if(matchedElement == patternMap.size()) {
                System.out.println("Pattern found at index : " + start);
                anagramList.add(str.substring(start, i + 1));
            }

            if(i >= patternMap.size()-1)
            {
                // we cross the window size and hence need to change the start index
                // we decrement the matchedElement if it was increased due to the start index which lies outside the current window
                // we also increment the frequency of the start character as we can again consider this character going forward
                char front = str.charAt(start);
                if(patternMap.containsKey(front)){
                    if(patternMap.get(front) == 0)
                        matchedElement--;
                    patternMap.put(front, patternMap.get(front) + 1);
                }
                // we increment the start to point to the new start
                start ++;
            }

        }

        for(String s : anagramList)
            System.out.println(s);
    }
}

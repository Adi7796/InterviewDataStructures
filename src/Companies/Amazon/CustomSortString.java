package Companies.Amazon;

import java.util.HashMap;
import java.util.Map;

/*
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.



Example 1:

Input: order = "cba", s = "abcd"

Output: "cbad"

Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".

Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

Example 2:

Input: order = "bcafg", s = "abcd"

Output: "bcad"

Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible.

Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "bacd" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.
 */
public class CustomSortString {

    public static void main(String[] args) {

        String order = "cba";
        String s = "abcd";

        CustomSortString obj = new CustomSortString();
        System.out.println(obj.customSortString(order, s));
    }

    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length(); i++)
        {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=0; i<order.length(); i++)
        {
            char currLetter = order.charAt(i);
            if(map.get(currLetter) == null) continue;
            int freq = map.get(currLetter);
            while(freq > 0){
                sb.append(currLetter);
                map.put(currLetter, freq-1);
                freq--;
            }
        }

        for(char ch : map.keySet())
        {
            if(map.get(ch) > 0)
            {
                int freq = map.get(ch);
                while(freq > 0){
                    sb.append(ch);
                    freq--;
                }

            }

        }
        return sb.toString();
    }
}

package Companies.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 */
public class LetterCombinationsOfPhoneNumber {

    static List<String> combinations = new ArrayList<>();
    static Map<Character, String> numberToStringMap = new HashMap<>();

    public static void main(String[] args) {
        String digits = "23";

        numberToStringMap.put('2', "abc");
        numberToStringMap.put('3', "def");
        numberToStringMap.put('4', "ghi");
        numberToStringMap.put('5', "jkl");
        numberToStringMap.put('6', "mno");
        numberToStringMap.put('7', "pqrs");
        numberToStringMap.put('8', "tuv");
        numberToStringMap.put('9', "wxyz");

        if(digits.length() == 0)
            return;
        backtrack(digits,0, new StringBuilder());
        for(String st : combinations)
        {
            System.out.println(st);
        }
    }

    public static void backtrack(String digits, int index, StringBuilder currentString)
    {
        if(currentString.length() == digits.length())
        {
            combinations.add(currentString.toString());
            return;
        }

        String possibleLetters = numberToStringMap.get(digits.charAt(index));
        for(char letter : possibleLetters.toCharArray())
        {
            currentString.append(letter);
            backtrack(digits, index + 1, currentString);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }
}

/*
Time complexity: O(4^N⋅N), where N is the length of digits. Note that 4 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.

The worst-case is where the input consists of only 7s and 9s.
In that case, we have to explore 4 additional paths for every extra digit.
Then, for each combination, it costs up to N to build the combination.
This problem can be generalized to a scenario where numbers correspond with up to M digits, in which case the time complexity would be O(M
N⋅N). For the problem constraints, we're given, M=4, because of digits 7 and 9 having 4 letters each.
 */

package Companies.Google;

import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string],
where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces,
square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and
that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
        s = "3[b2[ca]]";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        String temp = "";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;

            // If Digit, convert it into a number and
            // push it into the integer stack.
            if (Character.isDigit(s.charAt(i))) {
                while (Character.isDigit(s.charAt(i))) {
                    cnt = cnt * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numStack.push(cnt);
            }

            // If closing bracket ']' is encountered
            else if (s.charAt(i) == ']') {
                temp = "";

                cnt = numStack.pop();

                // Pop elements till the opening bracket '[' is found
                // in the character stack.
                while (charStack.peek() != '[') {
                    temp = charStack.pop() + temp;
                }
                charStack.pop(); // Remove '['

                // Repeating the popped string 'temp' count number of times.
                StringBuilder repeated = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    repeated.append(temp);
                }

                // Push it into the character stack.
                for (int j = 0; j < repeated.length(); j++) {
                    charStack.push(repeated.charAt(j));
                }
            } else {
                charStack.push(s.charAt(i));
            }
        }

        // Pop all the elements, make a string, and return.
        while (!charStack.isEmpty()) {
            res.insert(0, charStack.pop());
        }

        return res.toString();
    }
}

/*
Using Two Stacks – O(n) Time and O(n) Space
 */

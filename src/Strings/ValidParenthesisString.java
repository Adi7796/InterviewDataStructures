package Strings;

/*
Given a string s containing only three types of characters: '(', ')' and '*',
return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single
left parenthesis '(' or an empty string "".

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 */
public class ValidParenthesisString {

    public static void main(String[] args) {
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)))"));
    }
    public static boolean checkValidString(String s) {
        // min and max are ranges of operations we can perform
        // we subtract 1 for ), add 1 for (
        // if we convert * to ( we add 1, if we convert to ) we subtract 1, if we just keep it as empty we add 0,
        // hence ranges vary from -1 to 1
        int min = 0, max = 0;

        for(int i = 0; i < s.length(); i++)
        {
            // straightforward add 1
            if(s.charAt(i) == '(')
            {
                min ++;
                max ++;
            }
            // straightforward subtract 1
            else if(s.charAt(i) == ')')
            {
                min --;
                max --;
            }
            // since * we can add and subtract from max and min
            else
            {
                min = min - 1;
                max = max + 1;
            }

            // at any point of time we dont want to go below 0
            if(min < 0) min = 0;
            // if max falls below 0, that means there is no valid range
            // suppose just the string - ")"
            // means we dont have any open brackets left
            if(max < 0) return false;
        }
        // if only min == 0, and range is something like - [0,3]
        // we can form a valid string, where 0 represents that all open and close brackets were balanced

        return min == 0;
    }
}

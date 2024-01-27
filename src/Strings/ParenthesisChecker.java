package Strings;

import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String pattern1 = "([{}])";
        String pattern2 = "{((]}";

        System.out.println("Parenthesis check for " + pattern1 + " : "+ checkParenthesis(pattern1));
        System.out.println("Parenthesis check for " + pattern2 + " : "+ checkParenthesis(pattern2));
    }

    public static boolean checkParenthesis(String str)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if(stack.isEmpty())
                return false;

            char poppedBracket;

            // if we encounter a closing bracket we pop elements from the stack
            // and check if the popped element matches the current closing bracket pair
            // if it doesnt match we return false, else true
            switch (ch){
                case '}':
                    poppedBracket = stack.pop();
                    if(poppedBracket == '(' || poppedBracket == '[')
                        return false;
                    break;
                case ')':
                    poppedBracket = stack.pop();
                    if(poppedBracket == '{' || poppedBracket == '[')
                        return false;
                    break;
                case ']':
                    poppedBracket = stack.pop();
                    if(poppedBracket == '(' || poppedBracket == '{')
                        return false;
                    break;
            }
        }
        if(stack.isEmpty())
            return true;

        return false;
    }
}

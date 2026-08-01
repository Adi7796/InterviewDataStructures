package StackAndQueue;

import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid(")(){}"));
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '(') st.push(ch);
            if(st.isEmpty()) return false; // in-case we have only closing brackets, no open brackets would have been pushed into the stack
            else if(ch == ']')
            {
                char top = st.peek();
                if(top == '[') st.pop();
                else return false; // if the top element is not a matching closed bracket we can directly return from here
            }
            else if(ch == '}')
            {
                char top = st.peek();
                if(top == '{') st.pop();
                else return false;
            }
            else if(ch == ')')
            {
                char top = st.peek();
                if(top == '(') st.pop();
                else return false;
            }
        }
        return st.size() == 0;
    }
}

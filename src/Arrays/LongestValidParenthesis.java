package Arrays;

import java.util.Stack;

public class LongestValidParenthesis {
    public static void main(String[] args) {
        String s = "()(())";

        int left = 0;
        int right = 0;
        int maxLength = 0;
        if(s.isEmpty() || s.length() == 1) {
            System.out.println("Max length : " + maxLength);
            return;
        }
        for(int i=0;i<s.length(); i++)
        {
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')') right ++;

            if(left == right) maxLength = Math.max(maxLength, 2*right);

            if(right > left) left = right = 0;
        }

        left = right = 0;
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i) == '(') left++;
            else if(s.charAt(i) == ')') right++;

            if(left == right) maxLength = Math.max(maxLength, 2*left);

            if(left > right) left = right = 0;
        }

        System.out.println("Max length : " + maxLength);
    }
}

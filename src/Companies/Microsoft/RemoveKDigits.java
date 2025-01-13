package Companies.Microsoft;

import java.util.Stack;

/*
Find the smallest possible integer after removing exactly k digits from a string num that represents a non-negative integer
Eg, n = 1432219
k = 3

Ans - 1219
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "0452219";
        int k = 2;

        System.out.println(findNumber(num, k));
    }

    public static String findNumber(String num, int k)
    {
        Stack<Character> stack = new Stack<>();
        for(char ch : num.toCharArray())
        {
            int currentNum = Integer.parseInt(String.valueOf(ch));
            while(k > 0 && !stack.isEmpty() && currentNum < Integer.parseInt(String.valueOf(stack.peek())))
            {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k>0)
        {
            k--;
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(String.valueOf(stack.pop()));
        }
        return sb.reverse().toString();
    }
}

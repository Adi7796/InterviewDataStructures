package Companies.Google;

import java.util.LinkedList;
import java.util.Queue;

/*
A number is called as a Jumping Number if all adjacent digits in it differ by 1.
The difference between ‘9’ and ‘0’ is not considered as 1.
All single digit numbers are considered as Jumping Numbers.
For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.
Given a positive number x, print all Jumping Numbers smaller than or equal to x.
The numbers can be printed in any order.
 */
public class JumpingNumbers {
    public static void main(String[] args) {
        int N = 500;

        for(int i=1;i<=9;i++)
        {
            BFS(N, i);
        }
    }

    public static void BFS(int N, int i)
    {
        Queue<Integer> queue= new LinkedList<>();

        // Do BFS starting from i
        queue.add(i);

        while(!queue.isEmpty())
        {
            int num = queue.poll();

            if(num<N){
                int last_digit = num % 10;

                System.out.print(num + " ");
                // If last digit is 0, append next digit only
                if(last_digit == 0){
                    queue.add((num*10) + (last_digit + 1));
                }
                // If last digit is 9, append previous digit only
                else if(last_digit == 9)
                {
                    queue.add((num*10) + (last_digit -1));
                }
                // If last digit is neither 0 nor 9, append both
                // previous and next digits
                else{
                    queue.add((num*10) + (last_digit -1));
                    queue.add((num*10) + (last_digit + 1));
                }
            }
        }
    }
}

/*
Time Complexity: O(k)

Here k is the total number of jumping numbers.

Auxiliary Space: O(len(N))

Here len(N) is the maximum length from all the jumping numbers,
the extra space is used due to recursive function call stack.
 */

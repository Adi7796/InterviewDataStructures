package Companies.Google;

import java.util.Stack;
/*
Given a square matrix M[][] of size N X N, such that M[i][j] = 1 means ith person knows jth person,
the task is to find the celebrity. A celebrity is a person who is known to all but does not know anyone.
Return the index of the celebrity, if there is no celebrity return -1.

Note: Follow 0 based indexing and M[i][i] will always be 0.
 */
// A celebrity is a person whom everyone knows, but he/she doesn't know anyone
public class CelebrityProblem {
    public static void main(String[] args) {
          int arr[][] = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };
          int celebrity = findCelebrity(arr, 4);
          if(celebrity == -1)
              System.out.println("No celebrity");
          else
              System.out.println("Celebrity : " + celebrity);
    }

    public static int findCelebrity(int[][] arr, int n)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }

        while(stack.size()>1)
        {
            int i = stack.pop();
            int j = stack.pop();

            // if i knows j --> i is not a celebrity
            // we discard i and put j back in the stack as j could be a potential celebrity
            if(knows(i, j, arr)){
                stack.push(j);
            }
            // else i doesn't know j --> i could be a potential celebrity
            // we discard j and put i back in the stack
            else{
                stack.push(i);
            }
        }

        int candidate = stack.pop();

        for(int i=0;i<n;i++)
        {
            if(i != candidate && (knows(candidate,i, arr) || !knows(i, candidate, arr)))
                return -1;
        }

        return candidate;
    }

    public static boolean knows(int a, int b, int[][] arr){
        if(arr[a][b] == 1)
            return true;
        return false;
    }
}

/*
Time Complexity: O(N), The total number of comparisons is 3(N-1).
Auxiliary Space: O(N), n extra space is needed to store the stack.
 */

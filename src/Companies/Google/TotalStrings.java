package Companies.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a positive integer 'N'.
Your task is to find the number of strings of length ‘N’ that can be formed using only the characters ‘a’, ‘b’ and ‘c’.
The strings formed should be such that the number of ‘b’ and ‘c’ in the string is at most 1 and 2, respectively.

Example:
Let’s say N = 2. The strings of length 2, which satisfy the given constraints are: “aa”, “ab”, “ac”, “ba”, “bc”, “ca”, “cb”, “cc”.
Hence, the output is 8.
 */
public class TotalStrings {

    static List<String> ansList = new ArrayList<>();
    public static void main(String[] args) {
        int N = 3;
        String pattern = "abc";
        int[] isVisited = new int[2];
        Arrays.fill(isVisited, 0);
        StringBuffer result = new StringBuffer("");

        TotalStrings totalStrings = new TotalStrings();
        totalStrings.computePermutations(pattern, result, isVisited, N);

        for(String ans : ansList){
            System.out.println(ans);
        }

       System.out.println(ansList.size());

        System.out.println(totalStrings.calculatePermutations(N));

    }

    /*
    Time Complexity: O(3^N).
    Auxiliary Space: O(N).
     */
    public void computePermutations(String pattern, StringBuffer result, int[] isVisited, int n){
        if(result.length() == n){
            ansList.add(result.toString());
            return;
        }
        for(int i=0;i<pattern.length(); i++)
        {
            char currChar = pattern.charAt(i);
            if(currChar == 'b') isVisited[0]++;
            else if(currChar == 'c') isVisited[1]++;

            if(currChar == 'b' && isVisited[0]>1){
                isVisited[0]--;
                continue;
            }
            else if(currChar == 'c' && isVisited[1]>2){
                isVisited[1]--;
                continue;
            }

            computePermutations(pattern, result.append(currChar), isVisited, n);
            if(currChar == 'b') isVisited[0]--;
            else if(currChar == 'c') isVisited[1]--;
            result.deleteCharAt(result.length()-1);
        }

    }

    public int calculatePermutations(int n){
        int onlyA = 1;   // as we have n! total permutations and A's are repeating N times -> n!/n! = 1

        int oneB_RestA = n; // as we can use only 1 B and rest n-1 A's  -> n!/(n-1)!
        int oneC_RestA = n; // similar as above

        int twoC_RestA = (n*(n-1))/2;  // as we have n-2 A's and 2 C's which are repeating ---> n!/ (n-2)!*2!

        int oneB_oneC_RestA = n*(n-1);  // as we have n-2 A's and 1B and 1C --> n!/(n-2)! * 1! * 1!

        int twoC_oneB_RestA = (n*(n-1)*(n-2))/2;   // as we have n-3 A's, 2C's which are repeating and 1B --> n!/(n-3)! * 2! * 1!

        int totalCount = onlyA + oneB_RestA + oneC_RestA + twoC_RestA + oneB_oneC_RestA + twoC_oneB_RestA;

        return totalCount;
    }

    //Time Complexity: O(1).
}

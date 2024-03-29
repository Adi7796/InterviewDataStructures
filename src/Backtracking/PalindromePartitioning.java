package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabb";
        List<String> path = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        palindromePartitioning(0, s, path, ans);

        System.out.println(ans);
    }

    public static void palindromePartitioning(int index, String s, List<String> path, List<List<String>> ans)
    {
        if(index == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=index; i < s.length(); ++i)
        {
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1 ));
                palindromePartitioning(i+1, s, path, ans);
                path.remove(path.size() -1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end)
    {
        while(start <= end)
        {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
/*
Time Complexity: O( (2^n) *k*(n/2) )

Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome.
O(k) is for inserting the palindromes in another data structure,
where k  is the average length of the palindrome list.

Space Complexity: O(k * x)
 */

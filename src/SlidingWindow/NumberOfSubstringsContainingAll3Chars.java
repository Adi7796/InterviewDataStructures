package SlidingWindow;

/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one
occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of
the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca",
"bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of
the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1
 */
public class NumberOfSubstringsContainingAll3Chars {

    public static void main(String[] args) {
        NumberOfSubstringsContainingAll3Chars obj = new NumberOfSubstringsContainingAll3Chars();
        System.out.println(obj.numberOfSubstrings("abcabc"));
    }
    public int numberOfSubstrings(String s) {

        // initialize a last seen array fpr a,b & c
        // this will store the last seen index values for these characters  - a,b,c
        int[] lastSeen = {-1, -1, -1};
        int count = 0;
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            // update the last seen index of the current character
            lastSeen[ch - 'a'] = i;

            // if all three values != -1
            // that means we have seen all the characters previously and we have our window of all three characters present
            // the min index would be the start point of this window which has all three characters
            // all the characters to the left of this min index can be added to the count so that we can account for
            // all the substrings
            // Eg : bbabc, min index here = 2 for a, and window is from index -> 2 to 4
            // all chars left of a can be added to form substrings with a,b,c which is current (index of a) + 1
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1)
            {
                int minIndex = Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
                count = count + (minIndex + 1);
            }
        }
        return count;
    }
}

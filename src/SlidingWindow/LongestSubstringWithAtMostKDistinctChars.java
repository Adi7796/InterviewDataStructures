package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s and an integer k,
return the length of the longest substring of s that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 */
public class LongestSubstringWithAtMostKDistinctChars {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int r = 0, l = 0, maxLen = 0;

        while( r < s.length())
        {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0) + 1);

            if(map.size() > k)
            {
                char leftCh = s.charAt(l);
                map.put(leftCh, map.get(leftCh) -1);

                if(map.get(leftCh) == 0) map.remove(leftCh);
                l ++;
            }

            if(map.size() <= k)
            {
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}

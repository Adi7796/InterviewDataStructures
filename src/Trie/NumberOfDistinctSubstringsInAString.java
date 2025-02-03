package Trie;

/*
Given a string s, return the number of distinct substrings of s.

A substring of a string is obtained by deleting any number of characters (possibly zero)
from the front of the string and any number (possibly zero) from the back of the string.

Example 1:

Input: s = "aabbaba"
Output: 21
Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bab","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"]
Example 2:

Input: s = "abcdefg"
Output: 28
 */
public class NumberOfDistinctSubstringsInAString {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        TrieNode()
        {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    public int countDistinct(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        for(int i = 0; i<s.length(); i++)
        {
            TrieNode curr = root;
            for(int j = i; j<s.length(); j++)
            {
                char ch = s.charAt(j);
                int ind = ch -'a';
                if(curr.children[ind] == null)
                {
                    curr.children[ind] = new TrieNode();
                    curr.isEnd = true;
                    count++;
                }
                curr = curr.children[ind];
            }
        }
        return count;
    }
}

/*
Time Complexity: O(N*N)where N is the length of the input string.
This is because for each starting position of the substring, we traverse the entire substring once.
However, due to the Trie structure, the actual number of comparisons is reduced as we progress.

Space Complexity : O(N*N) where N is the length of the input string.
In the worst-case scenario, where there are no common prefixes among substrings
the number of nodes could be as high as the total number of substrings which is bounded by O(N*N).
 */

package Companies.Google;

/*
Given an array of words, find all shortest unique prefixes to represent each word in the given array.
Assume that no word is prefix of another.

Input: arr[] = {"zebra", "dog", "duck", "dove"}
Output: dog, dov, du, z
Explanation: dog => dog
             dove => dov
             duck => du
             zebra => z

1) Construct a Trie of all words. Also maintain frequency of every node (Here frequency is number of times node is visited during insertion). Time complexity of this step is O(N) where N is total number of characters in all words.
2) Now, for every word, we find the character nearest to the root with frequency as 1. The prefix of the word is path from root to this character. To do this, we can traverse Trie starting from root. For every node being traversed, we check its frequency. If frequency is one, we print all characters from root to this node and don’t traverse down this node.
Time complexity if this step also is O(N) where N is total number of characters in all words.

 */
public class ShortestUniquePrefix {

    static class TrieNode{
        TrieNode[] children = new TrieNode[256];
        int freq;

        TrieNode(){
            for(int i=0;i<256; i++) children[i] = null;
            freq = 1;
        }
    }

    public static void insert(String str, TrieNode root)
    {
        TrieNode currentNode = root;
        for(int i = 0; i<str.length(); i++)
        {
            char cur = str.charAt(i);
            if(currentNode.children[cur - 'a'] != null)
                currentNode.children[cur -'a'].freq++;
            if(currentNode.children[cur - 'a'] == null)
            {
                TrieNode newNode = new TrieNode();
                currentNode.children[cur - 'a'] = newNode;
            }

            currentNode = currentNode.children[cur - 'a'];
        }
    }
    public static void findPrefix(String str, TrieNode root){
        TrieNode currNode = root;
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<str.length(); i++)
        {
            char cur = str.charAt(i);
            sb.append(cur);
            if(currNode.children[cur - 'a'].freq == 1){
                System.out.println(sb.toString());
                break;
            }
            currNode = currNode.children[cur - 'a'];
        }
    }

    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        int n = arr.length;
        TrieNode root = new TrieNode();

        for(String str: arr)
            insert(str, root);
        for(String str: arr)
            findPrefix(str, root);
    }

}

/*
Time Complexity: O(n*m) where n is the length of the array and m is the length of the longest word.
Auxiliary Space: O(n*m)
 */

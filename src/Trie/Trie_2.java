package Trie;

public class Trie_2 {

    TrieNode root;
    static class TrieNode{
        TrieNode[] children;
        int countWord;
        int countPrefix;

        public TrieNode(){
            children = new TrieNode[26];
            countWord = 0;
            countPrefix = 0;
        }
    }

    public Trie_2()
    {
        root = new TrieNode();
    }

    public static void main(String[] args) {

    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null)
            {
                curr.children[ch -'a'] = new TrieNode();
            }

            curr = curr.children[ch -'a'];
            curr.countPrefix++;
        }
        curr.countWord++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for(int i =0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch -'a'] == null) return 0;
            curr = curr.children[ch-'a'];
        }
        return curr.countWord;
    }

    public int countWordsStartingWith(String prefix)
    {
        TrieNode curr = root;
        for(int i = 0; i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);

            if(curr.children[ch -'a'] == null) return 0;
            curr = curr.children[ch -'a'];
        }
        return curr.countPrefix;
    }

    public void erase(String word)
    {
        TrieNode curr = root;
        for(int i =0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(curr.children[ch -'a'] == null) return;
            curr = curr.children[ch-'a'];
            curr.countPrefix--;
        }
        curr.countWord--;
    }
}

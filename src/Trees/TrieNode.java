package Trees;

public class TrieNode {
    
    private TrieNode[] children = new TrieNode[26];
    private boolean isEndOfWord;
    
    public TrieNode(){
        isEndOfWord = false;
        for(int i=0; i<26; i++) children[i] = null;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        TrieNode root = new TrieNode();
        for (int i = 0; i < keys.length ; i++)
            insert(root, keys[i]);

        System.out.println("the --- " + search(root, "the"));
        System.out.println("these --- " + search(root, "these"));
        System.out.println("their --- " + search(root, "their"));
        System.out.println("thaw --- " + search(root, "thaw"));
        System.out.println("ans --- " + search(root, "ans"));
    }

    public static void insert(TrieNode root, String str)
    {
       TrieNode currNode = root;
       for(int i=0; i<str.length(); i++)
       {
           char cur = str.charAt(i);
           // cur - 'a' = ascii value of curr say for a -> 97, hence 97 - 97 = 0 -> arr[0]
           // if the current character doesn't point to any node
           // we create a new node
           if(currNode.children[cur - 'a'] == null)
           {
               TrieNode newNode = new TrieNode();
               currNode.children[cur - 'a'] = newNode;
           }
           // else we just mode to the next node
           currNode = currNode.children[cur - 'a'];
       }
       // we mark the end of this word to be true
       currNode.isEndOfWord = true;
    }

    public static boolean search(TrieNode root, String key)
    {
        TrieNode currNode = root;
        for(int i=0;i<key.length(); i++)
        {
            char cur = key.charAt(i);
            if(currNode.children[cur - 'a'] == null) return false;
            currNode = currNode.children[cur - 'a'];
        }
        return currNode.isEndOfWord;
    }
}

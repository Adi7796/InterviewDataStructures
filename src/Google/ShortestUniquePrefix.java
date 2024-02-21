package Google;

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

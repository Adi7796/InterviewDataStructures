package Companies.Google;

import java.util.ArrayList;
import java.util.List;

/*
ou are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.



Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].

Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
 */
public class SearchSuggestionSystem {

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        SearchSuggestionSystem system = new SearchSuggestionSystem();
        List<List<String>> ansList = system.suggestedProducts(products, searchWord);

        for(List<String> list : ansList)
        {
            System.out.println(list);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = buildTree(products);
        List<List<String>> result = new ArrayList<>();

        for(int i=1; i<=searchWord.length(); i++)
        {
            result.add(findTopThree(searchWord.substring(0, i), root));
        }
        return result;
    }

    private List<String> findTopThree(String searchTerm, TrieNode root)
    {
        List<String> result = new ArrayList<>();
        TrieNode node = root;
        for(char ch : searchTerm.toCharArray())
        {
            if(node.children[ch - 'a'] == null)
            {
                return result;
            }
            else
            {
                node = node.children[ch - 'a'];
            }
        }

        if(node.isWord == true)
        {
            result.add(searchTerm);
        }

        for(TrieNode child : node.children)
        {
            if(child != null)
            {
                List<String> thisResult = dfs(child, searchTerm, new ArrayList<>());
                result.addAll(thisResult);
                if(result.size() >= 3)
                {
                    return result.subList(0, 3);
                }
            }
        }
        return result;
    }

    private List<String> dfs(TrieNode root, String word, List<String> result)
    {
        if(root.isWord)
        {
            result.add(word + root.c);
            if(result.size() >= 3){
                return result;
            }
        }

        for(TrieNode child : root.children)
        {
            if(child != null)
            {
                result = dfs(child, word + root.c, result);
            }
        }

        return result;
    }

    private TrieNode buildTree(String[] products)
    {
        TrieNode root = new TrieNode(' ');
        for(String product : products)
        {
            insert(product, root);
        }
        return root;
    }

    private void insert(String product, TrieNode root)
    {
        TrieNode node = root;
        for(int i=0; i<product.length(); i++)
        {
            char curr = product.charAt(i);
            if(node.children[curr - 'a'] == null)
            {
                node.children[curr - 'a'] = new TrieNode(curr);
            }
            node = node.children[curr - 'a'];
        }
        node.isWord = true;
    }
}

class TrieNode{

    char c;
    TrieNode[] children;
    boolean isWord;

    public TrieNode(char c)
    {
        this.c = c;
        children = new TrieNode[26];
    }
}

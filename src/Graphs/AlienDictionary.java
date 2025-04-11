package Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
There is a new alien language that uses the English alphabet.
However, the order of the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary.
Now it is claimed that the strings in words are sorted lexicographically by the rules of this new language.

If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules.
If there are multiple solutions, return any of them.

Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".

Steps -
1) Reduce the problem to a directed graph with in-degree vertices data structure
2) once done, apply toposort on the char vertices to find the correct order of characters
 */
public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        AlienDictionary obj = new AlienDictionary();

        System.out.println(obj.alienOrder(words));
    }

    public String alienOrder(String[] words) {

        // Need this map to keep track of all the neighbour chars of each char
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        // to keep track of the indegree's of all the chars
        HashMap<Character, Integer> inDegreeMap = new HashMap<>();

        for(int i = 0; i<words.length; i++)
        {
            String s = words[i];
            for(char ch : s.toCharArray())
            {
                inDegreeMap.put(ch, 0);
            }
        }

        for(int i = 0; i<words.length-1; i++)
        {
            String s1 = words[i];
            String s2 = words[i+1];

            // edge case when no ordering is possible
            // when the word occurring before is greater in length than the 2nd word
            // and the 2nd word is a prefix of the first word, eg - abcd & abc
            if(s1.length() > s2.length() && s1.startsWith(s2)) return "";

            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j<len; j++)
            {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                // place of first mismatch of characters
                if(c1 != c2)
                {
                    HashSet<Character> set = new HashSet<>();
                    if(graph.containsKey(c1) == true)
                    {
                        set = graph.get(c1);
                        if(!set.contains(c2))
                        {
                            set.add(c2);
                            inDegreeMap.put(c2, inDegreeMap.get(c2) + 1);
                        }
                    }
                    else
                    {
                        set.add(c2);
                        inDegreeMap.put(c2, inDegreeMap.get(c2) + 1);
                    }
                    graph.put(c1, set);
                    break;
                }
            }
        }

        return topoSort(graph, inDegreeMap);
    }

    String topoSort(HashMap<Character, HashSet<Character>> graph, HashMap<Character, Integer> inDegreeMap) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : inDegreeMap.keySet()) {
            if (inDegreeMap.get(ch) == 0)
                queue.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!queue.isEmpty()) {
            char ch = queue.remove();
            sb.append(ch);
            count++;
            if (graph.containsKey(ch)) {
                // get the neighbour set of the current char
                HashSet<Character> nbrSet = graph.get(ch);
                // traverse over all the neighbour char and decrement their in degree
                for (char nbr : nbrSet) {
                    inDegreeMap.put(nbr, inDegreeMap.get(nbr) - 1);
                    // enqueue if any char has indegree = 0
                    if (inDegreeMap.get(nbr) == 0) {
                        queue.add(nbr);
                    }
                }
            }

        }
        return inDegreeMap.size() > sb.length() ? "" : sb.toString();
    }
}

/*
Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary,
‘len’ is the length up to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.
N*len - for words array and word traversal
K+E - for toposort using BFS

Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array,
and O(K) for the queue data structure used in BFS(where K = no.of nodes), O(K)
for the answer array and O(K) for the adjacency list used in the algorithm.

For the third part, recall that a breadth-first search has a cost of O(V+E)
 */

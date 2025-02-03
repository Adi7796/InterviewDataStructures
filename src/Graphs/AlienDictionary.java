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

 */
public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        AlienDictionary obj = new AlienDictionary();

        System.out.println(obj.alienOrder(words));
    }

    public String alienOrder(String[] words) {

        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
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

            if(s1.length() > s2.length() && s1.startsWith(s2)) return "";

            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j<len; j++)
            {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
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
                HashSet<Character> nbrSet = graph.get(ch);
                for (char nbr : nbrSet) {
                    inDegreeMap.put(nbr, inDegreeMap.get(nbr) - 1);
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
Time complexity : O(C).

There were three parts to the algorithm; identifying all the relations,
putting them into an adjacency list,
and then converting it into a valid alphabet ordering.

In the worst case, the first and second parts require checking every letter of every word
(if the difference between two words was always in the last letter). This is O(C).

For the third part, recall that a breadth-first search has a cost of O(V+E)
 */

package Graphs;

import java.util.*;

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

        System.out.println(obj.findOrder(words));
    }

    public String findOrder(String[] words) {
        // code here
        Set<Integer> charSet = new HashSet<>();
        for(String s : words)
        {
            for(int i=0; i<s.length(); i++)
            {
                charSet.add(s.charAt(i)-'a');
            }
        }

        int V = charSet.size();
        ArrayList<ArrayList<Integer>> graph = constructGraph(words);
        if(graph.isEmpty()) return "";
        return topoSort(graph, V, charSet);
    }

    private static ArrayList<ArrayList<Integer>> constructGraph(String[] words)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<26; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<words.length-1; i++)
        {
            String s1 = words[i];
            String s2 = words[i+1];
            /*
            to take care of a corner case where in s1 - abcd and s2 - abc
            in that case abc match in s1 and s2 but we dont have d to match to anything in s1
             */
            if(s1.length() > s2.length() && s1.startsWith(s2)) return new ArrayList<>();
            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++)
            {
                if(s1.charAt(j) != s2.charAt(j)) // whenever there is a mismatch we add the nodes to the graph and break
                {
                    // nodes are stores as int vertices and not char hence we use the conversion
                    addEdge(graph, s1.charAt(j) -'a', s2.charAt(j) -'a');
                    break;
                }
            }
        }

        return graph;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
    }

    private static String topoSort(ArrayList<ArrayList<Integer>> graph, int V, Set<Integer> charSet)
    {
        char[] order = new char[V];
        int[] inDegree = new int[26];
        Queue<Integer> q = new LinkedList<>();

        // prepare indegree arr for the connected chars in the form of int vertices - 0,1,2,3.. 26
        for(ArrayList<Integer> list : graph)
        {
            for(int i : list)
            {
                inDegree[i]++;
            }
        }

        for(int i=0; i<inDegree.length; i++)
        {
            // we check only for those vertices which are present in the chatSet and not all 26 chars
            if(charSet.contains(i) && inDegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;
        // apply normal topo sort using kahn's algo
        while(!q.isEmpty())
        {
            int v = q.poll();
            order[cnt] = (char)(97 + v);
            cnt++;
            for(int i: graph.get(v))
            {
                if(charSet.contains(i) && --inDegree[i] == 0)
                {
                    q.add(i);
                }
            }
        }
        if(cnt != V) return ""; // to check for cycles
        StringBuffer sb = new StringBuffer("");
        for(char ch : order)
        {
            sb.append(ch);
        }
        return sb.toString();
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

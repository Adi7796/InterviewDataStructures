package Graphs;

import java.util.*;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts.
Two accounts definitely belong to the same person if there is some common email to both accounts.
Note that even if two accounts have the same name, they may belong to different people as people could
have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account
is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],
["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */
public class AccountsMerge {

    static int[] parent;
    static int[] rank;
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();

        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> ans = accountsMerge(accounts);

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts)
    {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i<n; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }

        Map<String, Integer> map = new HashMap<>();

        // This step creates a map which marks each id to a vertex
        // and also unions id to the same vertex if the id's match
        // emailid1 -> 0
        // emailid2 -> 1 and so on
        for(int i=0; i<n; i++)
        {
            for(int j = 1; j < accounts.get(i).size(); j++)
            {
                if(!map.containsKey(accounts.get(i).get(j)))
                {
                    map.put(accounts.get(i).get(j), i);
                }
                else
                {
                    int u = map.get(accounts.get(i).get(j));
                    int v = i;
                    unionByRank(u, v);
                }
            }
        }

        // creates a map which contains the vertex as key and the list of email id's the vertex corresponds to
        // after merging the mail id's using disjoint set
        List<List<String>> mergedList = new ArrayList<>();
        Map<Integer, List<String>> mapList = new HashMap<>();
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            int u = entry.getValue();
            int parent_u = findParent(u);
            if(!mapList.containsKey(parent_u))
            {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                mapList.put(parent_u, list);
            }
            else{
                List<String> list = mapList.get(parent_u);
                list.add(entry.getKey());
            }
        }

        // creates the final ans list with, name and sorted email id's
        for(Map.Entry<Integer, List<String>> entry : mapList.entrySet())
        {
            List<String> mailsList = entry.getValue();
            Collections.sort(mailsList);
            mailsList.add(0, accounts.get(entry.getKey()).get(0));
            mergedList.add(mailsList);
        }

        return mergedList;
    }

    public static void unionByRank(int u, int v)
    {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if(rank[parent_v] > rank[parent_u])
        {
            parent[parent_u] = parent_v;
        }
        else if(rank[parent_v] < rank[parent_u])
        {
            parent[parent_v] = parent_u;
        }
        else
        {
            parent[parent_v] = parent_u;
            rank[parent_u]++;
        }
    }

    public static int findParent(int u)
    {
        if(parent[u] == u)
        {
            return u;
        }
        return parent[u] = findParent(parent[u]);
    }
}

/*
Time Complexity: O(N+E) + O(E*4ɑ) + O(N*(ElogE + E)) where N = no. of indices or nodes and E = no. of emails.
The first term is for visiting all the emails. The second term is for merging the accounts.
And the third term is for sorting the emails and storing them in the answer array.

Space Complexity: O(N)+ O(N) +O(2N) ~ O(N) where N = no. of nodes/indices.
The first and second space is for the ‘mergedMail’ and the ‘ans’ array.
The last term is for the parent and size array used inside the Disjoint set data structure.
 */
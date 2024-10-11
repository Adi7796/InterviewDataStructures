package Graphs;

import java.util.List;

/*
https://www.scaler.com/topics/data-structures/disjoint-set/
 */
public class UnionFindAlgorithm {

    static int V = 8;
    static int[] parent;
    static int[] rank;

    public UnionFindAlgorithm()
    {
        parent = new int[V];
        rank = new int[V];
        for(int i = 0; i < V; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static void main(String[] args) {
        UnionFindAlgorithm obj = new UnionFindAlgorithm();
        unionByRank(0, 1);
        unionByRank(1, 2);
        unionByRank(2, 3);
        unionByRank(2, 4);

        System.out.println("Parent : " + findByPathCompression(2));

        unionByRank(5, 6);
        unionByRank(6, 7);

        System.out.println("Parent : " + findByPathCompression(7));

        unionByRank(2, 7);
        System.out.println("Parent : " + findByPathCompression(7));
    }

    public static int find(int u)
    {
        if(parent[u] == u){
            return u;
        }
        return find(parent[u]);
    }

    public static void Union(int u, int v)
    {
        int root_u = find(u);
        int root_v = find(v);

        if(root_v != root_u)
        {
            parent[root_v] = root_u;
        }
    }

    /*
    Complexity Analysis:
    Find – Time complexity of Find operation is O(n) in the worst case
    (consider the case when all the elements are in the same set and we
    need to find the parent of a given element then we may need to make n recursive calls).
    Union – For union query (say Union(u, v)) we need to find the parents of u and v making
    its time complexity to be O(n).
     */

    public static int findByPathCompression(int u)
    {
        if(parent[u] == u)
        {
            return u;
        }
        return parent[u] = findByPathCompression(parent[u]);
    }

    /* time complexity = O(logn) */
    public static void unionByRank(int u, int v)
    {
        int root_u = findByPathCompression(u);
        int root_v = findByPathCompression(v);

        if(rank[root_v] > rank[root_u])
        {
            parent[root_u] = root_v;
        }
        else if(rank[root_u] > rank[root_v])
        {
            parent[root_v] = root_u;
        }
        else
        {
            parent[root_v] = root_u;
            rank[root_u]++;
        }
    }
    /* time complexity = O(logn) */
}

package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    List<Edge> edgeList;
    int V, E;

    public KruskalsAlgorithm(int v, int e) {
        V = v;
        E = e;
        edgeList = new ArrayList<>();
    }

    public static void main(String[] args) {
        KruskalsAlgorithm obj = new KruskalsAlgorithm(6, 9);
        obj.addEdge(0, 1, 7);
        obj.addEdge(0, 2, 8);
        obj.addEdge(1, 2, 3);
        obj.addEdge(1, 4, 6);
        obj.addEdge(2, 3, 3);
        obj.addEdge(2, 4, 4);
        obj.addEdge(3, 4, 2);
        obj.addEdge(3, 5, 2);
        obj.addEdge(4, 5, 2);

        obj.mst_kruskal();
    }

    public void mst_kruskal()
    {
        Collections.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);
        DisjointSet dsu = new DisjointSet(V);
        int i = 0, e = 0, sum = 0;
        while(e < V-1)
        {
            Edge edge = edgeList.get(i);
            i++;
            int root_u = dsu.findByPathCompression(edge.u);
            int root_v = dsu.findByPathCompression(edge.v);

            if(root_u != root_v)
            {
                System.out.println("Adding edge " + edge.u + " <---> " + edge.v + " to MST : weight : " + edge.weight);
                sum += edge.weight;
                dsu.unionByRank(root_u, root_v);
                e++;
            }
        }

        System.out.println("MST has a weight of " + sum);
    }

    public void addEdge(int u, int v, int weight) { edgeList.add(new Edge(u, v, weight));}



    static class Edge
    {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DisjointSet
    {
        static int[] parent;
        static int[] rank;

        public DisjointSet(int V)
        {
            parent = new int[V];
            rank = new int[V];

            for(int i = 0; i < V; i++)
            {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findByPathCompression(int u)
        {
            if(parent[u] == u)
            {
                return u;
            }
            return parent[u] = findByPathCompression(parent[u]);
        }

        /* time complexity = O(logn) */
        public void unionByRank(int u, int v)
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
    }
}


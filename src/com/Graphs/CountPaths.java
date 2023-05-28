package com.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CountPaths {
    static
    int V,E;
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        V= s.nextInt();
        E=s.nextInt();
        int source = s.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> adj = new LinkedList<>();
        for(int v=1;v<=V;v++)
        {
            matrix.add(new ArrayList<>());
        }
        for(int i=1;i<=E;i++)
        {
            int x=s.nextInt();
            int y=s.nextInt();
            matrix.get(x).add(y);
        }


    }
}

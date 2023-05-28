package com.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfiniteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> queries = new ArrayList<>();
//        queries.get(0).add(0,1L);
//        queries.get(0).add(1,3L);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for(int i=0;i<n;i++)
//        {
//            arr[i] = sc.nextInt();
//        }
//        int q = sc.nextInt();
//        for(int i=0;i<q;i++)
//        {
//            queries.add(new ArrayList<>());
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            queries.get(i).add(0,l);
//            queries.get(i).add(1,r);
//        }
//
//        System.out.println(queries);
//        sumInRanges(arr,n,queries,q);

          int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        getProductArrayExceptSelf(arr);
    }

    public static void sumInRanges(int[] arr, int n, List<List<Integer>> queries, int q) {

        // Write your code here!
        long mod = 1000000007;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<q;i++)
        {
            int left = queries.get(i).get(0);
            int right = queries.get(i).get(1);
            int sum =0;
            for(int j=left;j<=right;j++)
            {
                sum = (sum + arr[(j-1) % n]) % 1000009;
            }
            list.add(sum);
        }

        for(int i: list)
        {
            System.out.print(i+" ");
        }

    }

    public static void getProductArrayExceptSelf(int[] arr) {
        //Your code goes here
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i =1;i<n;i++)
        {
            left[i] = left[i-1]*arr[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
            right[i] = right[i+1]*arr[i+1];
        }
        int ans[] = new int[n];
        for(int i =0;i<n;i++)
        {
            ans[i] = left[i]*right[i];
        }
        for(int i : ans)
        {
            System.out.println(i);
        }
    }

}

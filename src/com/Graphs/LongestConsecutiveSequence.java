package com.Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(arr[0],1);
        for(int i=1;i<n;i++)
        {
            System.out.print(map);
            if(map.containsKey(arr[i]-1))
            {
                System.out.println(map.get(arr[i]-1)+1);
                map.put(arr[i],map.get(arr[i]-1)+1);
            }
            if(map.containsKey(arr[i]+1))
            {
                map.put(arr[i]+1,map.get(arr[i])+1);
            }
            else
                map.put(arr[i],1);

        }
        System.out.print(map);
//       for(Map.Entry<Integer,Integer> entry : map.entrySet())
//       {
//
//       }

    }
}

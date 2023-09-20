package Backtracking;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an arr(N) of integers, print the sum of all the subsets in the array
 */
public class SubsetSum {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(1);

        ArrayList<Integer> ans = new ArrayList<>();
        calculateSum(arr, 0, 0, ans);
        Collections.sort(ans);

        System.out.println(ans);
    }

    public static void calculateSum(ArrayList<Integer> arr, int sum, int index, ArrayList<Integer> ans)
    {
        if(index == arr.size()){
            ans.add(sum);
            return;
        }

        calculateSum(arr, sum + arr.get(index),index +1 , ans);

        calculateSum(arr, sum, index + 1, ans);
    }
}

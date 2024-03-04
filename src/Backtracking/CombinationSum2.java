package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
Given an array of positive integers arr[] and an integer x,
The task is to find all unique combinations in arr[] where the sum is equal to x.
The same number cannot be chosen again from arr[].
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(2);
        //arr.add(8);
        arr.add(1);
        //arr.add(4);
        arr.add(2);
        int sum = 5;
        ArrayList<ArrayList<Integer>> ans = combinationalSumUtil(arr, sum);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> combinationalSumUtil(ArrayList<Integer> arr, int sum){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        findNumbers(ans, arr, 0, sum, temp, set);
        return ans;
    }

    public static void findNumbers(ArrayList<ArrayList<Integer>> ans,
                                   ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> temp, HashSet set)
    {
        if(index == arr.size()){
            if(sum == 0){
                ans.add(new ArrayList<>(temp));
            }
        }

        if(arr.get(index) <= sum && !set.contains(index))
        {
            temp.add(arr.get(index));
            set.add(index);
            findNumbers(ans, arr, index, sum - arr.get(index), temp, set);
            temp.remove(temp.size()-1);
            set.remove(index);
        }

        findNumbers(ans, arr, index+1, sum, temp, set);
    }
}

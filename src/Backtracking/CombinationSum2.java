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
        arr.add(4);
        arr.add(6);
        arr.add(8);
        arr.add(2);
        arr.add(4);

        int sum = 8;
        ArrayList<ArrayList<Integer>> ans = combinationalSumUtil(arr, sum);
        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> combinationalSumUtil(ArrayList<Integer> arr, int sum){
        HashSet<Integer> set = new HashSet<>(arr);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // first do hashing since hashset does not always
        // sort
        //  removing the duplicates using HashSet and
        // Sorting the arrayList
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);

        findNumbers(ans, arr, 0, sum, temp);
        return ans;
    }

    public static void findNumbers(ArrayList<ArrayList<Integer>> ans,
                                   ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> temp)
    {
        if(sum == 0)
        {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=index ; i<arr.size(); i++)
        {
            if(i > index && (sum - arr.get(index)) >= 0)
            {
                // adding element which can contribute to sum
                temp.add(arr.get(index));
                findNumbers(ans, arr, index+1, sum - arr.get(index), temp);
                temp.remove(arr.size() -1);
            }
        }
    }
}

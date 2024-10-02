package Backtracking;

import java.util.*;

/*
Given an array of positive integers arr[] and an integer x,
The task is to find all unique combinations in arr[] where the sum is equal to x.
The same number cannot be chosen again from arr[].
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr= {10, 1, 2, 7, 6, 1, 5};
        int sum = 8;

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        combinationalSumUtil(arr, sum, 0, ans, new ArrayList<>());
        for(List<Integer> list : ans)
        {
            System.out.println(list);
        }
    }

    public static void combinationalSumUtil(int[] arr, int target, int index, List<List<Integer>> ans,
                                            List<Integer> subList){
        if(target == 0)
        {
            ans.add(new ArrayList<>(subList));
            return;
        }

        for(int i = index; i < arr.length; i++)
        {
            if(i > index && arr[i-1] == arr[i]) continue;

            if(arr[i] > target) break;

            subList.add(arr[i]);
            combinationalSumUtil(arr, target - arr[i], i + 1, ans, subList);
            subList.remove(subList.size()-1);
        }
    }


}

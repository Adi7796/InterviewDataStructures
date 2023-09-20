package Backtracking;

import java.util.ArrayList;

/*
Given an array of positive integers arr[] and an integer x,
The task is to find all unique combinations in arr[] where the sum is equal to x.
The same repeated number may be chosen from arr[] an unlimited number of times.
 */
public class CombinationSum1 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(7);
        //arr.add(2);
        //arr.add(4);

        int sum = 7;
        ArrayList<ArrayList<Integer>> ans = combinationalSumUtil(arr, sum);
        System.out.println(ans);

    }

    public static ArrayList<ArrayList<Integer>> combinationalSumUtil(ArrayList<Integer> arr, int sum){
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findNumbers(ans, arr, 0, sum, temp);
        return ans;
    }

    public static void findNumbers(ArrayList<ArrayList<Integer>> ans,
                                   ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> temp)
    {
        if(index == arr.size()){
            if(sum ==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        // checking that sum does not become negative
        if(arr.get(index) <= sum)
        {
            // adding element which can contribute to sum
            temp.add(arr.get(index));
            // we picked the current index hence we can pick it up again, hence we pass index
            // since we picked the current element the new sum becomes sum - arr[index]
            findNumbers(ans, arr, index, sum - arr.get(index), temp);

            // removing element from list (backtracking)
            temp.remove(temp.size()-1);
        }
        // we dont update the sum as we didnt pick the current index and moved to index +1
        findNumbers(ans, arr, index+1, sum, temp);
    }
}

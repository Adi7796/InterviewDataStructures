package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of distinct integers, return all possible permutations in any order
 */
public class ArrayPermutations {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] isFreq = new boolean[arr.size()];
        Arrays.fill(isFreq, false);
        findPermutations(arr, ans, isFreq, temp);
        System.out.println(ans);
    }

    public static void findPermutations(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans,
                                        boolean[] isFreq, ArrayList<Integer> temp){

        // We add the deep copy of the temp list to the ans list
        // whenever the current size of the temp list becomes equal to the array size
        if(temp.size() == arr.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // we loop over the array and check if we have already put the value at the index into the
        // isFreq array
        // if not, we put that value into the temp array, mark it as visited and recur from there for other values
        for(int index = 0;index < arr.size(); index ++)
        {
            if(!isFreq[index])
            {
                isFreq[index] =true;
                temp.add(arr.get(index));
                findPermutations(arr, ans, isFreq, temp);
                // go back --> backtrack
                temp.remove(temp.size() -1);
                isFreq[index] = false;
            }
        }
    }
}
/*
Time Complexity: O(N*N!) Note that there are N! permutations and it requires O(N) time to print a permutation.
Auxiliary Space: O(r – l)
 */

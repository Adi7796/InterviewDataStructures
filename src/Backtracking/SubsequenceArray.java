package Backtracking;

import java.util.ArrayList;

public class SubsequenceArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        SubsequenceArray obj = new SubsequenceArray();
        obj.subsequence(arr, 0, new ArrayList<>());
    }

    public void subsequence(int[] arr, int index, ArrayList<Integer> path){
        if(index == arr.length){
            if(path.size() > 0) {
                System.out.println(path);
            }
            return;
        }
        path.add(arr[index]);
        subsequence(arr, index +1, path); // take
        path.remove(path.size() -1);
        subsequence(arr, index + 1, path);  // not take
    }
}

/*
time complexity - 2^n * n
 */

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
            if(path.size() > 0)
                System.out.println(path);
        }
        else{
            subsequence(arr, index +1, path);
            path.add(arr[index]);
            subsequence(arr, index + 1, path);
            path.remove(path.size() -1);
        }
        return;
    }
}

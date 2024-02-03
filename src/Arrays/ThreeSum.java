package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {50, 30, 10, 60, 20, 40, 90, 80, 10, 20, 40};
        int targetSum = 100;
        if(arr.length <3) return;
        ArrayList<ArrayList<Integer>> resultList = find3Sum(arr, targetSum);
        resultList.forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> find3Sum(int arr[], int targetSum)
    {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        for(int i=0; i<=arr.length-2; i++)
        {
            if(i!=0 && arr[i] == arr[i-1]) continue;

            int twoSum = targetSum - arr[i];
            ArrayList<ArrayList<Integer>> twoSumList = find2SumPair(arr, twoSum, i+1, arr.length -1);
            for(ArrayList<Integer> list : twoSumList)
            {
                list.add(arr[i]);
                resultList.add(list);
            }
        }
        return resultList;
    }

    public static ArrayList<ArrayList<Integer>> find2SumPair(int[] arr,
                                                  int twoSum,
                                                  int leftIndex,
                                                  int rightIndex)
    {
        ArrayList<ArrayList<Integer>> subList = new ArrayList<>();
        while(leftIndex < rightIndex)
        {
            if(arr[leftIndex] + arr[rightIndex] == twoSum){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[leftIndex]);
                list.add(arr[rightIndex]);
                subList.add(list);
                leftIndex++;
                rightIndex--;
            }
            else if(arr[leftIndex] + arr[rightIndex] < twoSum){
                leftIndex++;
            }
            else if(arr[leftIndex] + arr[rightIndex] > twoSum){
                rightIndex--;
            }
        }

        return subList;
    }
}

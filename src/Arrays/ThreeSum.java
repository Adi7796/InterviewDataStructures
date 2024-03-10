package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        List<List<Integer>> resultList = find3Sum(arr);
        resultList.forEach(System.out::println);
    }

    public static List<List<Integer>> find3Sum(int arr[])
    {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(i!=0 && arr[i] == arr[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j<k)
            {
                long sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else {
                    List<Integer> subList = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(subList);
                    k--;
                    j++;
                    while(j<k && arr[j]== arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
}

/*
Time Complexity: O(NlogN)+O(N2), where N = size of the array.
Reason: The pointer i, is running for approximately N times. And both the pointers
j and k combined can run for approximately N times including the operation of skipping duplicates.
So the total time complexity will be O(N2).
 */

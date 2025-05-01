package Companies.Google;

import java.util.ArrayList;
import java.util.Collections;

/*
Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class AllUniquePermutations {

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    static ArrayList<Integer> subList = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(2);

        int n = arr.size();

        ans = permutation(arr, ans, n);
        for (ArrayList<Integer> subList : ans) {
            System.out.println(subList);
        }
    }
    public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> arr,
                                                            ArrayList<ArrayList<Integer>> ans, int n) {

        // Sort the input array to handle duplicates easily
        Collections.sort(arr);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        backtrack(arr, n, visited);
        return ans;
    }

    public static void backtrack(ArrayList<Integer> arr, int n, boolean[] visited) {
        if (subList.size() == n) {
            ans.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < n; i++) {
            //Skip if already visited
            if (visited[i])
                continue;

            // Skip duplicates if the previous identical element wasn’t used
            if (i > 0 && arr.get(i) == arr.get(i - 1) && !visited[i - 1])
                continue;

            visited[i] = true;
            subList.add(arr.get(i));
            backtrack(arr, n, visited);

            visited[i] = false;
            subList.remove(subList.size() - 1);
        }

    }

}

/*
Time Complexity: O(n! * n), n! comes from the total number of permutations in the worst case
(when all elements are distinct) and n accounts for the time taken to copy each complete permutation
(which has n elements) into the result array.
Auxiliary Space: O(n), depth of recursion equals the number of elements and also for visited and curr array.
 */




package Google;

import java.util.ArrayList;
import java.util.Collections;

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
            if (visited[i])
                continue;

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




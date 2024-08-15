package Companies.Google;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String[] args) {
        int N = 9;
        ArrayList<ArrayList<Integer>> pascal = printPascal(N);
        for(ArrayList<Integer> rowList : pascal)
        {
            for(Integer i : rowList){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> printPascal(int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=n; i++)
        {
            ArrayList<Integer> rowList = new ArrayList<>();
            for(int j=1;j<=i;j++)
            {
                if(j==1 || j==i) rowList.add(1);
                else if(i>=3 && j>1 && j<n){
                    int x = ans.get(i-2).get(j-2);
                    int y = ans.get(i-2).get(j-1);
                    rowList.add(x+y);
                }
            }
            ans.add(rowList);
        }
        return ans;
    }
}

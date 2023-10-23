package Greedy;

import java.util.ArrayList;
import java.util.List;

/*
Given a value of V Rs and an infinite supply of each of the denominations {1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes,
The task is to find the minimum number of coins and/or notes needed to make the change
 */
public class MinNumberOfCoins {

    static int[] denom = {1, 2, 5, 10, 20, 50 ,100, 500, 1000};
    public static void main(String[] args) {
        int V = 97;

        System.out.println("Minimum number of coins for "+ V);
        findMin(V);
    }

    public static void findMin(int V){
        int n = denom.length;
        List<Integer> list = new ArrayList<>();
        int i=n-1;
        while(i>=0)
        {
            while(V >= denom[i]){
               V = V- denom[i];
               list.add(denom[i]);
            }
            i--;
        }
        if(i==-1 && V!=0){
            System.out.println("Remaining balance : "+ V);
        }else {
            for (int j : list) {
                System.out.print(j + " ");
            }
        }
    }
}

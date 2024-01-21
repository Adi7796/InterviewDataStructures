package Strings;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        int max_length = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr)
            set.add(i);

        for(int i=0; i< arr.length; i++)
        {
            if(!set.contains(arr[i] - 1))
            {
                int startingNumber = arr[i];
                while(set.contains(startingNumber))
                {
                    startingNumber ++;
                }
                max_length = Math.max(max_length, startingNumber - arr[i]);
            }
        }

        System.out.println("max length : " + max_length);
    }
}

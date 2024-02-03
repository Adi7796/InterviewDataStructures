package Arrays;

import java.util.Arrays;

public class TwoSum {

    static class Pair{
        int x;
        int y;

        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int sum = 14;

        Pair pair = isSumPresent(arr, sum);
        if(pair.x == -1 && pair.y == -1)
            System.out.println("No pair found for the given sum");
        else
            System.out.println("Pair with the given sum : " + pair.x + "," +pair.y);
    }

    public static Pair isSumPresent(int[] arr, int sum)
    {
        Pair pair = new Pair(-1,-1);
        Arrays.sort(arr);

        int left = 0, right = arr.length-1;
        while(left <= right)
        {
            if(arr[left] + arr[right] == sum){
                pair.x = arr[left];
                pair.y = arr[right];
                return pair;
            }
            else if(arr[left] + arr[right] > sum)
                right--;
            else
                left++;
        }
        return pair;
    }
}

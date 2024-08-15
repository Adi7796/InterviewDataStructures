package Companies.Google;

import java.util.Arrays;

/*
You are given an arbitrary array ‘arr’ consisting of N non-negative integers,
where every element appears thrice except one.
You need to find the element that appears only once.
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 3, 3, 6};
        Arrays.sort(arr);

        for(int i=0; i<arr.length; i++)
        {
            int count =1;
            while(i<arr.length - 1 && arr[i+1] == arr[i])
            {
                count++;
                i++;
            }
            if(count ==1)
            {
                System.out.println("Single number : " + arr[i]);
                return;
            }
        }
    }
}

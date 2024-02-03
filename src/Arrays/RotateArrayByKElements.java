package Arrays;

import java.util.stream.Stream;

public class RotateArrayByKElements {
    public static void main(String[] args) {
        char[] arr = {'a','b','c','d','e','f','g','h'};

        int len = arr.length;
        int K = -9;
        rotate(arr, K);
        Stream.of(arr).forEach(System.out::println);
    }

    public static void rotate(char[] arr, int K)
    {
        int len = arr.length;
        K = K%len;
        if(K < 0) {  // suppose K= -1, this is similar to rotating the array as -1 + 8 = 7
            K = K + len;
        }
        // reverse left part --> e,d,c,b,a,f,g,h
        reverse(arr, K, 0, len -K -1);
        // reverse right part --> e,d,c,b,a,h,g,f
        reverse(arr, K, len -K, len -1);
        // reverse the whole array --> f,g,h,a,b,c,d,e
        reverse(arr, K, 0, len-1);
    }

    public static void reverse(char[] arr, int K, int leftIndex, int rightIndex)
    {
        while(leftIndex < rightIndex)
        {
            char temp = arr[leftIndex];
            arr[leftIndex] = arr[rightIndex];
            arr[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }
    }
}

package SortingSearching;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4 ,3, -2, 100, 34, 50, -98, 1234, 44, 8};
        int n = arr.length;

        for(int i=0;i<n-1;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(arr[j] < arr[j-1])
                    swap(j, j-1, arr);
            }
        }

        for(int i : arr)
            System.out.print(i + " ");
    }

    public static void swap(int a, int b, int[] arr)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

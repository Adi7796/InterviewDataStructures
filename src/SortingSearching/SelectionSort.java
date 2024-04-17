package SortingSearching;

/*
Selection sort is a simple and efficient sorting algorithm that works by repeatedly
selecting the smallest (or largest) element from the unsorted portion of the list
and moving it to the sorted portion of the list.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4 ,3, -2, 100, 34, 50, -98, 1234, 44, 8};
        int n = arr.length;

        for(int i=0;i<n-1;i++)
        {
            int minimum = arr[i];
            int minimumIndex = i;
            for(int j=i+1;j<n-1;j++)
            {
                if(arr[j] < minimum)
                {
                    minimum = arr[j];
                    minimumIndex = j;
                }
            }
            swap(minimumIndex, i, arr);
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

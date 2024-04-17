package SortingSearching;

/*
Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list
into its correct position in a sorted portion of the list.
It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order in the sorted output.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4 ,3, -2, 100, 34, 50, -98, 1234, 44, 8};
        int n = arr.length;

        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j>0;j--)
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

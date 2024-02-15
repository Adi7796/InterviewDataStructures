package SortingSearching;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 8, 1, 3};
        quickSort(arr, 0, arr.length -1);

        for(int i : arr){
            System.out.print(i +  " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
       if(low<high){
           int pivot = partition(low, high, arr);
           //once we have the pivot we call the same sorting function for the left and right sub arrays
           quickSort(arr, low, pivot -1);
           quickSort(arr, pivot + 1, high);
       }
    }

    public static int partition(int low, int high, int[] arr){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i<j){
            // traversing till thr current element is smaller than the pivot
            while(arr[i] <= pivot && i< arr.length)
                i++;
            // traversing till the current element is greater than the pivot
            while(arr[j] >= pivot && j>0)
                j--;
            // once the upper 2 loop break, we swap i and j to put the elements at their correct place
            if(i<j)
                swap(arr, i, j);

            //we keep on running this loop till i crosses j

        }
        // This is done to put the pivot element at its correct place
        // now all the elements to the right of pivot are greater than the pivot
        // and all elements to the left of pivot are smaller than the pivot
        swap(arr, low, j);

        // since we have swapped the pivot element to j index
        // we return this index to the calling function
        return j;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

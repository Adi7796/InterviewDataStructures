package SortingSearching;


// Used binary Search, hence time complexity - O(N)
public class SearchElementSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        int index = searchElement(arr, key);
        if(index!= -1)
            System.out.println("Key found at : " + index);
        else
            System.out.println("Key not found");

    }

    public static int searchElement(int[] arr, int key)
    {
        int low = 0;
        int high = arr.length-1;



        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid] == key) return mid;

            // checking if the left sub array is sorted
            // if sorted the mid-1 element should be greater than the low element
            else if(arr[low] < arr[mid-1])
            {
                // checking if the key lies in the range of low and mid
                // if yes we shorten our searching range to low and mid 1
                if(key>=arr[low] && key<arr[mid]){
                    high = mid-1;
                }
                // else we search in the right subarray which is not sorted
                // by increasing the lower bound
                else{
                    low = mid+1;
                }
            }

            // if the left sub array is not sorted, then the right sub array is 100% sorted
            else{
                // checking if the key lies in the range of mid and high
                // if yes we shorten our search range to mid+1 and high
                if(key>arr[mid] && key <= arr[high]){
                    low = mid + 1;
                }

                // else we search in the left subarray which is unsorted
                // in the range of low and mid-1
                else{
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}

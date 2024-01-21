package SortingSearching;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {12,84,10,7,43,56};
        int ans = search(arr,56,0,arr.length-1);
        if(ans == -1)
            System.out.println("Doesn't exist");
        else
            System.out.println(ans);
    }

    public static int search(int[] arr, int target, int start, int end){
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(arr[mid]==target)
            return mid;
        else if(arr[mid]>target)
            return search(arr,target,0,mid-1);
        else
            return search(arr,target,mid+1,arr.length-1);
    }
}

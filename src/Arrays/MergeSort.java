package Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12,0,45,20,4,15,100,79,34};
        mergeSort(0,arr.length-1,arr);
        for(int i : arr)
            System.out.println(i);
    }

    public static void mergeSort(int start, int end, int[] arr){
        if(start<end)
        {
            int mid = (start + end)/2;
            mergeSort(start, mid, arr);
            mergeSort(mid + 1, end, arr);
            merge(start, mid, end, arr);
        }
    }

    public static void merge(int start, int mid, int end, int[] arr){

        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++)
            left[i]=arr[start+i];
        for(int j=0;j<n2;j++)
            right[j]= arr[mid+1+j];

        int k =start;
        int i=0,j=0;
        while(i<n1 && j<n2)
        {
            if(left[i]<=right[j]){
                arr[k]= left[i];
                i++;
            }
            else if(right[j]<left[i]){
                arr[k] = right[j];
                j++;
            }
         k++;
        }
        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    }
}

package Arrays;

public class Segregate012 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        int low = 0, mid = 0, high = arr.length-1;

        while(mid <= high)
        {
             if(arr[mid] == 0)
             {
                 swap(low, mid, arr);
                 low++;
                 mid++;
             }
             else if(arr[mid] == 1){
                 mid++;
             }
             else if(arr[mid] == 2){
                 swap(mid, high, arr);
                 high--;
             }
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int i, int j, int[] arr)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

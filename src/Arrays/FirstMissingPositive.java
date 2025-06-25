package Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {3, 2, -6, 1, 0};
        int n = arr.length;
        for(int i=0;i<arr.length; i++){
            // substitute negative and 0's with n+1 as both dont satisfy our use case
            if(arr[i]<=0){
                arr[i] = n+1;
            }
        }

        System.out.println("Aditya");

        // mark the present numbers with negative values
        // ignore values which are greater than n
        for(int i=0; i<arr.length; i++)
        {
            int index = Math.abs(arr[i]) -1;
            if(index < n)
            {
                arr[index] = arr[index]*(-1);
            }
        }

        // traverse and check which is the first positive number
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                System.out.println("First missing positive : " + (i+1));
                return;
            }
        }
        System.out.println("First missing positive : " + n+1);
    }
}

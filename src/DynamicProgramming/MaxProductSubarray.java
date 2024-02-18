package DynamicProgramming;

public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 4, -6, 3, -2, 6};
        findMaxProduct(arr, arr.length);

        int[] arr1 = {-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4};
        findMaxProduct(arr1, arr1.length);
    }

    public static void findMaxProduct(int[] arr, int n)
    {
        int prefix = 1;
        int suffix = 1;
        int maxPrefix = Integer.MIN_VALUE;
        int maxSuffix = Integer.MIN_VALUE;
        int maxProduct = Integer.MIN_VALUE;

        for(int i=0;i<arr.length; i++){
            // if we encounter 0, we reset the prefix and suffix to 1
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            // calculating prefix from start
            prefix = prefix * arr[i];
            // calculating suffix from end
            suffix = suffix * arr[n-i-1];

            maxPrefix = Math.max(prefix, maxPrefix);
            maxSuffix = Math.max(suffix, maxSuffix);
        }

        maxProduct = Math.max(maxPrefix, maxSuffix);

        System.out.println("Max product subarray : " + maxProduct);
    }
}

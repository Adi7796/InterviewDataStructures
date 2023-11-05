package DynamicProgramming;

public class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

        System.out.println("Max sum : " + KadaneAlgorithm(arr));
    }

    public static int KadaneAlgorithm(int[] arr)
    {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0;i<arr.length;i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if(max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if(max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    //Time Complexity: O(N)
    //Auxiliary Space: O(1)
}

package Companies.Amazon;

public class SumSubArrayEqualsK {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 1};
        int k = 0;

        System.out.println(findCount(arr, k));
    }

    public static int findCount(int[] arr, int k)
    {

        // This approach only works for positive integers, will fail if we have negative values
        if(k==0 && arr.length!=0) return 0;
        int left = 0, right = 0;
        int sum_so_far = arr[0];
        int n = arr.length;
        int count = 0;

        while(right < n)
        {
            while(left<=right && sum_so_far > k)
            {
                sum_so_far = sum_so_far - arr[left];
                left++;
            }
            if(sum_so_far == k)
            {
                count++;
            }
            right++;
            if(right < n)
            {
                sum_so_far += arr[right];
            }

        }
        return count;
    }
}
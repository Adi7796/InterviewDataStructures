package BinarySearch;

/*
You are given 2 numbers n and m, the task is to find n√m (nth root of m).
If the root is not integer then returns -1.

Examples :
Input: n = 2, m = 9
Output: 3
Explanation: 32 = 9
Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not integer.
Input: n = 1, m = 14
Output: 14
 */
public class NthRootOfM {

    public static void main(String[] args) {
        System.out.println(nthRoot(2, 9));
        System.out.println(nthRoot(3, 9));
    }

    public static int nthRoot(int n, int m) {
        // code here
        return findNthRoot(m, n);
    }

    private static int findNthRoot(int M, int N)
    {
        int ans = 1;
        int low = 0, high = M;

        while(low <= high)
        {
            int mid = (low + high)/2;
            int dupMid = mid;
            for(int i = 2; i<=N; i++)
            {
                mid = dupMid * mid;
            }
            if(mid == M)
            {
                ans = dupMid;
                return ans;
            }
            else if(mid < M){
                low = dupMid + 1;
            }
            else{
                high = dupMid - 1;
            }
        }
        return -1;
    }
}

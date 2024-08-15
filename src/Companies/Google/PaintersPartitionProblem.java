package Companies.Google;

/*
Given are N boards of with length of each given in the form of array, and K painters,
such that each painter takes 1 unit of time to paint 1 unit of the board.
The task is to find the minimum time to paint all boards under the constraints that any painter will only paint continuous sections of boards,
say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

can be solved similar to the allocating books problem

Logic explanation - https://takeuforward.org/arrays/painters-partition-problem/
 */
public class PaintersPartitionProblem {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        int k =2;
        int max = arr[arr.length-1];
        int sum = 0;

        for(int i=0;i<arr.length;i++)
        {
            sum +=arr[i];
        }

        System.out.println("Minimum time to paint max boards : " + findBoards(max, sum, arr, k));
    }

    static int countPainters(int[] arr, int time)
    {
        int painters =1;
        int boardsPainted = 0;

        for(int i=0;i<arr.length;i++)
        {
            if(boardsPainted + arr[i] <= time){
                boardsPainted += arr[i];
            }
            else{
                painters++;
                boardsPainted = arr[i];
            }
        }

        return painters;
    }

    static int findBoards(int low, int high, int[] arr, int k)
    {
        if(k>arr.length) return -1;

        while(low<=high)
        {
            int mid = (low+high)/2;
            int painters = countPainters(arr, mid);

            if(painters>k) low = mid + 1;
            else high = mid -1;
        }

        return low;
    }
}

/*
Time Complexity: O(N * log(sum(arr[])-max(arr[])+1)), where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
Space Complexity:  O(1)
 */

package Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated (>= 0)
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.


Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50}
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3
but the profit with this schedule is 20+50+100 which is less than 250.
 */
public class JobScheduling {

    static class Job{
        int start;
        int finish;
        int profit;

        Job(int start, int finish, int profit){
            this.start= start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    public static int findMaxProfitRec(Job[] arr, int n)
    {
        int[] table = new int[arr.length];
        table[0] = arr[0].profit;

        for(int i=1;i<n;i++)
        {
            // Find profit including the current job
            int includingProfit = arr[i].profit;
            int l = recentNonConflicting(arr, i);
            if(l != -1)
            {
                includingProfit = includingProfit + table[l];
            }
            table[i] = Math.max(includingProfit, table[i-1]); // find maxbetween including profit and excluding current profit
        }
        return table[n-1];
    }

    // Find the latest job (in sorted array) that doesn't
    // conflict with the job[i]. If there is no compatible
    // job, then it returns -1.
    public static int recentNonConflicting(Job[] arr, int i)
    {
        for(int j=i-1; j>=0; j--)
        {
            // check which previous recent job has the finish time smaller or equal to the start time of the current job
            if(arr[j].finish <= arr[i].start)
                return j;
        }
        return -1;
    }

    // Sort jobs according to finish time
    public static int findMaxProfit(Job arr[], int n){
        Arrays.sort(arr, new Comparator<Job>(){
            public int compare(Job j1, Job j2){
                return j1.finish - j2.finish;
            }
        });
        return findMaxProfitRec(arr, n);
    }

    public static void main(String[] args) {
        int m =4;
        Job arr[] = new Job[4];
        arr[0] = new Job(1, 2, 50);
        arr[1] = new Job(3, 5, 20);
        arr[2] = new Job(6, 19, 100);
        arr[3] = new Job(2, 100, 200);
        System.out.println("Max Profit : "+ findMaxProfit(arr, arr.length));

    }

    // Time complexity is O(n*n)
    // Could have been O(nlogN) if we had used binary search instead of linear search in recentNonConflicting
}

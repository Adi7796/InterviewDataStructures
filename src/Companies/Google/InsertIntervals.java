package Companies.Google;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of non-overlapping intervals
intervals where intervals[i] = [starti, endi] represent the start and
the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in
ascending order by starti and intervals still does not have any overlapping
intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2, 5};

        int[][] ans = insert(intervals, newInterval);
        for(int i = 0; i < ans.length; i++)
        {
            for(int j = 0; j< ans[0].length; j++)
            {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ansList = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        /*
        No Overlap Before Insertion:
        Loop through intervals while i is less than n and
        the current interval's endpoint (intervals[i][1])
        is less than the new interval's start point (newInterval[0]).
        */
        while(i < n && intervals[i][1] < newInterval[0])
        {
            int low = intervals[i][0];
            int high = intervals[i][1];
            ansList.add(new int[]{low, high});
            i++;
        }

        /*
        Overlap and Merge:
        Loop through intervals while i is less than n and the
        new interval's endpoint (newInterval[1]) is greater than or
        equal to the current interval's start point (intervals[i][0]).
        */
        while(i < n && newInterval[1] >= intervals[i][0])
        {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ansList.add(newInterval);

        /*
        No overlap after insertion:
        Loop through the remaining intervals (from index i)
        and add them to the res array.
        */
        while(i < n){
            int low = intervals[i][0];
            int high = intervals[i][1];
            ansList.add(new int[]{low, high});
            i++;
        }

        return ansList.toArray(new int[ansList.size()][]);
    }
}

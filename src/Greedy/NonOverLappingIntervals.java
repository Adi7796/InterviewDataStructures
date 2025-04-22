package Greedy;

import java.util.*;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping.
For example, [1, 2] and [2, 3] are non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverLappingIntervals {

    class Interval implements Comparable<Interval>
    {
        int start;
        int finish;

        Interval(int start, int finish)
        {
            this.start = start;
            this.finish = finish;
        }

        public int compareTo(Interval i)
        {
            return this.finish - i.finish;
        }
    }
    public static void main(String[] args) {
        //int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};

        NonOverLappingIntervals obj = new NonOverLappingIntervals();
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals)
    {
        List<Interval> intervalList = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalList);

        int count = 0;
        int latestFinishTime = Integer.MIN_VALUE;
        for(int i = 0; i<intervalList.size(); i++)
        {
            /*
            For each interval - If the start time is greater than or equal to k,
            update k to the end time of the current interval.
            */
            Interval currInterval = intervalList.get(i);
            if(currInterval.start >= latestFinishTime)
            {
                latestFinishTime = currInterval.finish;
            }
            // otherwise increment count to indicate we need to remove this interval
            else
            {
                count++;
            }
        }
        return count;
    }
}
/*
Time complexity: O(n⋅logn)
 */
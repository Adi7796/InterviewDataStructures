package Companies.Google;

import java.util.Arrays;

/*
Given a set of N intervals, the task is to find the maximal set of mutually disjoint intervals.
Two intervals [i, j] & [k, l] are said to be disjoint if they do not have any point in common.

Input: arr[][] = [[1, 4], [2, 3], [4, 6], [8, 9]]
Output:
2 3
4 6
8 9
Explanation: if [1, 4] is included then we cannot include [2, 3] & [4, 6].

Input: arr[][] = [[1, 9], [2, 3], [5, 7]]
Output:
2 3
5 7
 */
public class DisjointIntervals {

    static class Pair implements Comparable<Pair>{
        int start;
        int finish;

        Pair(int start, int finish)
        {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }

        @Override
        public int compareTo(Pair p1)
        {
            if(this.finish > p1.finish)
                return 1;
            else if(this.finish == p1.finish)
                return 0;
            return -1;
        }
    }
    public static void main(String[] args) {
        Pair[] intervals = new Pair[4];
        intervals[0] = new Pair(1, 4);
        intervals[1] = new Pair(2, 3);
        intervals[2] = new Pair(4, 6);
        intervals[3] = new Pair(8, 9);

        findDisjointIntervals(intervals);
    }

    public static void findDisjointIntervals(Pair[] intervals)
    {
        // sorting the intervals in the ascending order of finishing times
        Arrays.sort(intervals);

        System.out.println(intervals[0]);
        int prevFinish = intervals[0].finish;
        for(int i=1; i< intervals.length;i++)
        {
            int currentStart = intervals[i].start;
            int currentFinish = intervals[i].finish;

            // if the intervals are disjoint, only then we print the interval
            if(currentStart > prevFinish) {
                System.out.println(intervals[i]);
                prevFinish = currentFinish;
            }
        }
    }
}

/*
Time Complexity: O(nlogn)
Auxiliary Space: O(1)

this can be done using stacks as well keeping track of the top element
in that case space would be : O(N)
 */

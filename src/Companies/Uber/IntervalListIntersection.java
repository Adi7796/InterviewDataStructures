package Companies.Uber;

import java.util.ArrayList;
import java.util.List;

/*
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

 */
public class IntervalListIntersection {

    public static void main(String[] args) {
        IntervalListIntersection obj = new IntervalListIntersection();
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] ans = obj.intervalIntersection(firstList, secondList);

        for(int i = 0; i < ans.length; i++)
        {
            System.out.println(ans[i][0] + ", " + ans[i][1]);
        }
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ansList = new ArrayList<>();

        if(firstList.length == 0 || secondList.length == 0)
        {
            return new int[0][0];
        }

        int i = 0, j=0;

        while(i<firstList.length && j<secondList.length)
        {
            int low = Math.max(firstList[i][0], secondList[j][0]);
            int high = Math.min(firstList[i][1], secondList[j][1]);

            if(low <= high) {
                ansList.add(new int[]{low, high});
            }


            if(firstList[i][1] < secondList[j][1])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}

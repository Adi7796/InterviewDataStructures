package Companies.Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take.
To take course 3 you should have finished both courses 1 and 2.
Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]

 */
public class CourseSchedule2 {

    public static void main(String[] args) {
        int[][] prerequisites = {{0,2}, {1,2}, {2,0}};
        int numCourses = 3;

        List<Integer> ans = findOrder(prerequisites, numCourses);
        for(int i = ans.size()-1; i>=0; i--)
        {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static List<Integer> findOrder(int[][] prerequisites, int numCourses)
    {
        List<Integer> orderList = new ArrayList<>();
        List<List<Integer>> adjancencyList = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i++)
        {
            adjancencyList.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++)
        {
            adjancencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inDegree = new int[numCourses];

        for(List<Integer> subList : adjancencyList)
        {
            for(int i = 0; i < subList.size(); i++)
            {
                inDegree[subList.get(i)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int j = 0; j < inDegree.length; j++)
        {
            if(inDegree[j] == 0) queue.offer(j);
        }

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            orderList.add(currentNode);
            for (int i = 0; i < adjancencyList.get(currentNode).size(); i++) {
                int neighbour = adjancencyList.get(currentNode).get(i);
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        if(orderList.size() != numCourses) return new ArrayList<>();
        return orderList;
    }
}

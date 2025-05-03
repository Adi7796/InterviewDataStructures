package Companies.Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};

        CourseSchedule obj = new CourseSchedule();

        System.out.println(obj.canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0 ;i < numCourses;i++)
        {
            adjacencyList.add(new ArrayList<>());
        }

        int size = prerequisites.length;
        for(int i=0; i < size; i++)
        {
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inDegree = new int[adjacencyList.size()];
        for(List<Integer> list : adjacencyList)
        {
            for(int i = 0;i<list.size(); i++)
            {
                inDegree[list.get(i)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length; i++)
        {
            if(inDegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        int numberOfNodes = 0;
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            numberOfNodes++;;
            for(int i = 0 ; i< adjacencyList.get(current).size(); i++)
            {
                int neighbour = adjacencyList.get(current).get(i);
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0)
                {
                    queue.offer(neighbour);
                }
            }
        }

        return numberOfNodes == numCourses;
    }
}

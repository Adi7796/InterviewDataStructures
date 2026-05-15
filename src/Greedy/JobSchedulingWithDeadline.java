package Greedy;

import java.util.*;
/*
Given a list of tasks with deadlines and total profit earned on completing a task, find the maximum profit earned by executing the tasks within the specified deadlines. Assume that each task takes one unit of time to complete, and a task can't execute beyond its deadline.

Input: (Task Id, Deadline, Profit)

[(1, 9, 15), (2, 2, 2), (3, 5, 18), (4, 7, 1), (5, 4, 25), (6, 2, 20), (7, 5, 8), (8, 7, 10), (9, 4, 12), (10, 3, 5)]

Output: {1, 3, 4, 5, 6, 7, 8, 9}
Explanation: The maximum profit that can be achieved is 109 by leaving tasks 2 and 10 out.

Constraints:

• Only a single task can be executed at a time.
• The maximum number of tasks are 100.
• The maximum deadline that can be associated with a job is 1000.

*/
public class JobSchedulingWithDeadline {

    static class Job
    {
        public int taskId, deadline, profit;

        public Job(int taskId, int deadline, int profit)
        {
            this.taskId = taskId;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static Set<Integer> scheduleJobs(List<Job> jobs)
    {
        // Write your code here...
        Collections.sort(jobs, (j1, j2) -> j2.profit - j1.profit);
        int profit = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();
        for(Job j : jobs)
        {
            int deadline = j.deadline;
            if(!set.contains(deadline))
            {
                set.add(deadline);
                ansSet.add(j.taskId);
                //profit += j.profit;
            }
            else{
                while(set.contains(deadline))
                {
                    deadline--;
                }
                if(deadline > 0)
                {
                    set.add(deadline);
                    ansSet.add(j.taskId);
                }
            }
        }
        return ansSet;
    }

    public static void main(String[] args)
    {
        // List of given jobs. Each job has an identifier, a deadline, and
        // profit associated with it
        List<Job> jobs = Arrays.asList(
                new Job(1, 9, 15), new Job(2, 2, 2), new Job(3, 5, 18),
                new Job(4, 7, 1), new Job(5, 4, 25), new Job(6, 2, 20),
                new Job(7, 5, 8), new Job(8, 7, 10), new Job(9, 4, 12),
                new Job(10, 3, 5));

        // stores the maximum deadline that can be associated with a job
        final int T = 15;

        // schedule jobs and calculate the maximum profit
        Set<Integer> ans = scheduleJobs(jobs);
        ans.forEach(System.out::println);
    }
}

//The time complexity of the above solution is O(n2), where n is the total number of jobs.
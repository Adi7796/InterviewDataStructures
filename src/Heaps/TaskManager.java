package Heaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
There is a task management system that allows users to manage their tasks, each associated with a priority.
The system should efficiently handle adding, modifying, executing, and removing tasks.

Implement the TaskManager class:

TaskManager(vector<vector<int>>& tasks) initializes the task manager with a list of user-task-priority triples.
Each element in the input list is of the form [userId, taskId, priority], which adds a task to the specified user with the given priority.

void add(int userId, int taskId, int priority) adds a task with the specified taskId and priority to the user with userId.
It is guaranteed that taskId does not exist in the system.

void edit(int taskId, int newPriority) updates the priority of the existing taskId to newPriority.
It is guaranteed that taskId exists in the system.

void rmv(int taskId) removes the task identified by taskId from the system.
It is guaranteed that taskId exists in the system.

int execTop() executes the task with the highest priority across all users.
If there are multiple tasks with the same highest priority, execute the one with the highest taskId.
After executing, the taskId is removed from the system. Return the userId associated with the executed task.
If no tasks are available, return -1.

Note that a user may be assigned multiple tasks.

Input:
["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
[[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]

Output:
[null, null, null, 3, null, null, 5]

Explanation

TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // Initializes with three tasks for Users 1, 2, and 3.
taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
taskManager.edit(102, 8); // Updates priority of task 102 to 8.
taskManager.execTop(); // return 3. Executes task 103 for User 3.
taskManager.rmv(101); // Removes task 101 from the system.
taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
taskManager.execTop(); // return 5. Executes task 105 for User 5.
 */
public class TaskManager {

    static class Tasks implements Comparable<Tasks>{
        int userId;
        int taskId;
        int priority;

        public Tasks(int userId, int taskId, int priority)
        {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        public int compareTo(Tasks tp)
        {
            if(this.priority != tp.priority)
            {
                return tp.priority - this.priority;
            }
            else return tp.taskId - this.taskId;
        }

    }

    TreeMap<Tasks, Integer> sortedTasksMap;
    Map<Integer, Tasks> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        sortedTasksMap = new TreeMap<>();
        taskMap = new HashMap<>();

        for(List<Integer> subList : tasks)
        {
            for(int i = 0; i < 3; i++)
            {
                int userId = subList.get(0);
                int taskId = subList.get(1);
                int priority = subList.get(2);
                add(userId, taskId, priority);
            }
        }
    }

    public void add(int userId, int taskId, int priority)
    {
        Tasks task = new Tasks(userId, taskId, priority);
        sortedTasksMap.putIfAbsent(task, userId);
        taskMap.putIfAbsent(taskId, task);
    }

    public void edit(int taskId, int newPriority)
    {
        Tasks task = taskMap.get(taskId);
        if(task != null)
        {
            sortedTasksMap.remove(task);
            task.priority = newPriority;
            sortedTasksMap.put(task, task.userId);
        }
    }

    public void rmv(int taskId)
    {
        Tasks task = taskMap.get(taskId);
        if(task != null)
        {
            taskMap.remove(taskId);
            sortedTasksMap.remove(task);
        }
    }

    public int execTop()
    {
        if(sortedTasksMap.isEmpty()) return -1;
        Tasks topTask = sortedTasksMap.firstKey();
        taskMap.remove(topTask.taskId);
        sortedTasksMap.remove(topTask);
        return topTask.userId;
    }
}

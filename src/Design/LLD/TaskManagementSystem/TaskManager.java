package Design.LLD.TaskManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskManager {

    private static TaskManager instance;
    private Map<String, Task> taskMap;
    private Map<String, List<Task>> userTasksMap;

    private TaskManager()
    {
        taskMap = new ConcurrentHashMap<>();
        userTasksMap = new ConcurrentHashMap<>();

    }
    public static synchronized TaskManager getTaskManagerInstance(){
        if(instance == null)
        {
            instance = new TaskManager();
        }
        return instance;
    }


    public void createTask(Task task)
    {
        taskMap.put(task.getTaskId(), task);
        assignTaskToUser(task.getAssignedUser(), task);
        System.out.println("Created task : " + task + " for user : " + task.getAssignedUser());
    }

    public void assignTaskToUser(User user, Task task)
    {
        List<Task> taskList = userTasksMap.get(user.getUserId());
        if(taskList == null)
        {
            taskList = new ArrayList<>();
        }
        taskList.add(task);
        userTasksMap.put(user.getUserId(), taskList);
    }

    public void unassignTaskFromUser(Task task, User user)
    {
       List<Task> tasksList = userTasksMap.get(user.getUserId());
       if(tasksList != null){
           tasksList.remove(task);
       }
    }

    public void updateTask(Task updatedTask)
    {
        Task existingTask = taskMap.get(updatedTask.getTaskId());
        synchronized (existingTask)
        {
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setTitle(updatedTask.getTitle());

            User previousUser = existingTask.getAssignedUser();
            User newUser = updatedTask.getAssignedUser();

            if(!previousUser.equals(newUser))
            {
                unassignTaskFromUser(existingTask, previousUser);
                assignTaskToUser(newUser, existingTask);
            }
        }
        System.out.println("Updated task successfully:" + existingTask);
    }

    public List<Task> searchTasks(String keyword)
    {
        List<Task> matchingTasks = new ArrayList<>();
        for(Task task : taskMap.values())
        {
            if(task.getDescription().contains(keyword) || task.getTitle().contains(keyword))
            {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    public void deleteTask(String taskId)
    {
        Task task = taskMap.remove(taskId);
        if(task != null)
            unassignTaskFromUser(task, task.getAssignedUser());
    }

    public List<Task> filterTasks(TaskStatus taskStatus, Date startDate, Date endDate, int priority)
    {
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : taskMap.values())
        {
            if(task.getTaskStatus() == taskStatus &&
            task.getPriority() == priority &&
            task.getDueDate().compareTo(startDate) >=0 &&
            task.getDueDate().compareTo(endDate) <= 0)
                filteredTasks.add(task);
        }

        return filteredTasks;
    }

    public void markTaskAsCompleted(String taskId)
    {
        Task task = taskMap.get(taskId);
        if(task != null){
            task.setTaskStatus(TaskStatus.COMPLETED);
        }

        User user = taskMap.get(taskId).getAssignedUser();
        List<Task> tasksList = userTasksMap.get(user.getUserId());
        tasksList.add(task);
    }

    public List<Task> getTaskHistory(User user){
        return new ArrayList<>(userTasksMap.getOrDefault(user.getUserId(), new ArrayList<>()));
    }
}

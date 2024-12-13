package Design.LLD.TaskManagementSystem;

import java.util.Date;

public class Task {

    private final String taskId;
    private String title;
    private String description;
    private Date dueDate;
    private int priority;
    private TaskStatus taskStatus;
    private User assignedUser;

    public Task(String taskId, String title, String description, Date dueDate, int priority, User assignedUser) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.taskStatus = TaskStatus.PENDING;
        this.assignedUser = assignedUser;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", taskStatus=" + taskStatus +
                ", assignedUser=" + assignedUser +
                '}';
    }
}

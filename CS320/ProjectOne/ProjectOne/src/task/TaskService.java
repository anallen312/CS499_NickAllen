package task;

import java.util.HashMap;

public class TaskService {
    private HashMap<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskID(), task);
    }

    public boolean deleteTask(String taskID) {
        if (tasks.containsKey(taskID)) {
            tasks.remove(taskID);
            return true;
        }
        return false;
    }

    public boolean updateTask(String taskID, String name, String description) {
        Task task = tasks.get(taskID);
        if (task != null) {
            task.setName(name);
            task.setDescription(description);
            return true;
        }
        return false;
    }

    public int getTasksSize() {
        return tasks.size();
    }

    // Get task method
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}

package task;

public class Task {
    private final String taskID;  // Immutable & unique, max 10 characters
    private String name;          // Required, max 20 characters
    private String description;   // Required, max 50 characters

    // Constructor
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskID() {
        return this.taskID;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}

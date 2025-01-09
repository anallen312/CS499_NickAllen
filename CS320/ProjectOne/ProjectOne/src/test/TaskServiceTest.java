package test;

import task.Task;
import task.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        int initialSize = taskService.getTasksSize();
        Task newTask = new Task("T1", "Read book", "Read 'Clean Code' by Robert C. Martin");
        taskService.addTask(newTask);
        assertEquals(initialSize + 1, taskService.getTasksSize());
    }

    @Test
    public void testDeleteTask() {
        Task newTask = new Task("T1", "Read book", "Read 'Clean Code' by Robert C. Martin");
        taskService.addTask(newTask);
        boolean isDeleted = taskService.deleteTask("T1");
        assertEquals(true, isDeleted);
    }

    @Test
    public void testUpdateTask() {
        Task newTask = new Task("T1", "Read book", "Read 'Clean Code' by Robert C. Martin");
        taskService.addTask(newTask);
        boolean isUpdated = taskService.updateTask("T1", "Read another book", "Read 'The Pragmatic Programmer'");
        assertEquals(true, isUpdated);
        
        // Added assertions to check updated values
        Task updatedTask = taskService.getTask("T1");
        assertNotNull(updatedTask);
        assertEquals("Read another book", updatedTask.getName());
        assertEquals("Read 'The Pragmatic Programmer'", updatedTask.getDescription());
    }
    
    // Boundary test: Adding a task with max ID length
    @Test
    public void testAddTaskBoundaryID() {
        String maxID = "1234567890"; // Max length of 10
        Task newTask = new Task(maxID, "Some task", "Some description");
        taskService.addTask(newTask);
        assertNotNull(taskService.getTask(maxID));
    }

    // Boundary test: Adding a task with max name length
    @Test
    public void testAddTaskBoundaryName() {
        String maxName = "12345678901234567890"; // Max length of 20
        Task newTask = new Task("T2", maxName, "Some description");
        taskService.addTask(newTask);
        assertEquals(maxName, taskService.getTask("T2").getName());
    }

    // Boundary test: Adding a task with max description length
    @Test
    public void testAddTaskBoundaryDescription() {
        String maxDescription = "12345678901234567890123456789012345678901234567890"; // Max length of 50
        Task newTask = new Task("T3", "Some task", maxDescription);
        taskService.addTask(newTask);
        assertEquals(maxDescription, taskService.getTask("T3").getDescription());
    }
}

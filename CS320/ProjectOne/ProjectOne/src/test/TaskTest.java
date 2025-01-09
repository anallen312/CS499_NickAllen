package test;

import task.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {
    private Task task;

    @BeforeEach
    public void setUp() {
        task = new Task("TaskID1", "TaskName", "TaskDescription");
    }

    @Test
    public void testTaskIDNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "TaskName", "TaskDescription"));
    }

    @Test
    public void testNameNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TaskID1", null, "TaskDescription"));
    }

    @Test
    public void testDescriptionNotNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TaskID1", "TaskName", null));
    }

    @Test
    public void testTaskIDLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task("LongTaskID111111111111", "TaskName", "TaskDescription"));
    }

    @Test
    public void testNameLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TaskID1", "LongTaskName111111111111111111111111111", "TaskDescription"));
    }

    @Test
    public void testDescriptionLength() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TaskID1", "TaskName", "LongTaskDescription111111111111111111111111111111111111111111111111111111111111"));
    }

    // New Tests based on Feedback
    @Test
    public void testGettersAfterSettingViaConstructor() {
        assertEquals("TaskID1", task.getTaskID());
        assertEquals("TaskName", task.getName());
        assertEquals("TaskDescription", task.getDescription());
    }
    
    // Boundary test: Adding a task with max ID length
    @Test
    public void testAddTaskBoundaryID() {
        Task newTask = new Task("1234567890", "Some task", "Some description");
        assertNotNull(newTask);
        assertEquals("1234567890", newTask.getTaskID());
    }

    // Boundary test: Adding a task with max name length
    @Test
    public void testAddTaskBoundaryName() {
        Task newTask = new Task("T2", "12345678901234567890", "Some description");
        assertNotNull(newTask);
        assertEquals("12345678901234567890", newTask.getName());
    }

    // Boundary test: Adding a task with max description length
    @Test
    public void testAddTaskBoundaryDescription() {
        Task newTask = new Task("T3", "Some task", "12345678901234567890123456789012345678901234567890");
        assertNotNull(newTask);
        assertEquals("12345678901234567890123456789012345678901234567890", newTask.getDescription());
    }
}

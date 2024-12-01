import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToDoListManager {
    private final List<Task> tasks = new ArrayList<>();
    private final Stack<List<Task>> history = new Stack<>();
    private final Logger logger = Logger.getLogger(ToDoListManager.class.getName());

    public ToDoListManager() {
        logger.setLevel(Level.INFO);
    }

    // Add a new task
    public void addTask(Task task) {
        saveState();
        tasks.add(task);
        logger.info("Task added: " + task.getDescription());
    }

    // Mark a task as completed
    public void markTaskCompleted(String description) {
        saveState();
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                logger.info("Task marked as completed: " + description);
                return;
            }
        }
        logger.warning("Task not found: " + description);
    }

    // Delete a task
    public void deleteTask(String description) {
        saveState();
        tasks.removeIf(task -> task.getDescription().equalsIgnoreCase(description));
        logger.info("Task deleted: " + description);
    }

    // View tasks based on filter
    public List<Task> viewTasks(String filter) {
        switch (filter.toLowerCase()) {
            case "all":
                return new ArrayList<>(tasks);
            case "completed":
                return tasks.stream().filter(Task::isCompleted).toList();
            case "pending":
                return tasks.stream().filter(task -> !task.isCompleted()).toList();
            default:
                logger.warning("Invalid filter: " + filter);
                return Collections.emptyList();
        }
    }

    // Undo the last operation
    public void undo() {
        if (!history.isEmpty()) {
            tasks.clear();
            tasks.addAll(history.pop());
            logger.info("Undo operation performed");
        } else {
            logger.warning("No actions to undo");
        }
    }

    // Save the current state for undo functionality
    private void saveState() {
        history.push(new ArrayList<>(tasks));
    }
}

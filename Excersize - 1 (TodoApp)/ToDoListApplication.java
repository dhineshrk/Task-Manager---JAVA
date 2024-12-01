import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ToDoListApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoListManager manager = new ToDoListManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.println("\n1. Add Task\n2. Mark Task Completed\n3. Delete Task\n4. View Tasks\n5. Undo\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter due date (dd-MM-yyyy) or leave blank: ");
                    String dueDateString = scanner.nextLine();
                    LocalDate dueDate = null;

                    if (!dueDateString.isEmpty()) {
                        try {
                            dueDate = LocalDate.parse(dueDateString, formatter);
                            if (dueDate.isBefore(LocalDate.now())) {
                                System.out.println("Date is invalid, task will not be added as the due date is in the past.");
                                continue; // Skip adding the task
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Date is invalid, task will not be added due to incorrect format.");
                            continue; // Skip adding the task
                        }
                    }

                    Task task = new Task.Builder(description).withDueDate(dueDate).build();
                    manager.addTask(task);
                }
                case 2 -> {
                    System.out.print("Enter task description to mark as completed: ");
                    String description = scanner.nextLine();
                    manager.markTaskCompleted(description);
                }
                case 3 -> {
                    System.out.print("Enter task description to delete: ");
                    String description = scanner.nextLine();
                    manager.deleteTask(description);
                }
                case 4 -> {
                    System.out.print("View tasks (all/completed/pending): ");
                    String filter = scanner.nextLine();
                    List<Task> tasks = manager.viewTasks(filter);
                    tasks.forEach(System.out::println);
                }
                case 5 -> manager.undo();
                case 6 -> {
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

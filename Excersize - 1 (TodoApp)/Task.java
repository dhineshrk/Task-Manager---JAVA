import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    private final String description;
    private final LocalDate dueDate;
    private boolean isCompleted;

    // Builder Pattern for creating tasks
    public static class Builder {
        private final String description;
        private LocalDate dueDate;

        public Builder(String description) {
            this.description = description;
        }

        public Builder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    private Task(Builder builder) {
        this.description = builder.description;
        this.dueDate = builder.dueDate;
        this.isCompleted = false;
    }

    // Getters
    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Mark task as completed
    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "Completed" : "Pending";
        String dueDateString = (dueDate != null) ? dueDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : "No Due Date";
        return description + " - " + status + ", Due: " + dueDateString;
    }
}

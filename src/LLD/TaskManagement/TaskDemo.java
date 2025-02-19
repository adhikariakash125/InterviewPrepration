package LLD.TaskManagement;


import java.util.Date;
import java.util.List;

public class TaskDemo {
    public static void main(String[] args) {
        TaskHandlerImpl taskHandler = TaskHandlerImpl.getInstance();

        // Create users
        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task("1", "Task 1", "Description 1", new Date(), TaskPriority.P1, TaskStatus.PENDING,user1);
        Task task2 = new Task("2", "Task 2", "Description 2", new Date(), TaskPriority.P2, TaskStatus.PENDING,user2);
        Task task3 = new Task("3", "Task 3", "Description 3", new Date(), TaskPriority.P1, TaskStatus.PENDING,user1);

        // Add tasks to the task manager
        taskHandler.create(task1);
        taskHandler.create(task2);
        taskHandler.create(task3);

        // Update a task
        task2.setDescription("Updated description");
        taskHandler.update(task2);

        // Search tasks
        List<Task> searchResults = taskHandler.searchTasks("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        // Filter Tasks
        List<Task> filteredTasks = taskHandler.filter(TaskStatus.PENDING, new Date(0), new Date(), TaskPriority.P1);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as completed
        taskHandler.markComplete("1");

        // Get task history for a user
        List<Task> taskHistory = taskHandler.getAllTasks(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        // Delete a task
        taskHandler.delete("3");

    }
}

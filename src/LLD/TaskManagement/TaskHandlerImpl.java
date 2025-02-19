package LLD.TaskManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TaskHandlerImpl {

    private final Map<String, Task> tasks;
    private final Map<String, List<Task>> assignedTasks;
    private static TaskHandlerImpl taskHandler;

    public static synchronized TaskHandlerImpl getInstance(){
        if (taskHandler!=null) return taskHandler;
        return new TaskHandlerImpl();
    }

    private TaskHandlerImpl() {
        this.tasks = new ConcurrentHashMap<>();
        this.assignedTasks = new ConcurrentHashMap<>();
    }

    public void create(Task task) {
        tasks.put(task.getId(), task);
        addAssignedTask(task);
    }

    private void addAssignedTask(Task task) {
        List<Task> assignedTasksList = assignedTasks.get(task.getUser().getId());
        if (assignedTasksList == null) {
            assignedTasksList = new ArrayList<>();
        }
        assignedTasksList.add(task);
        assignedTasks.put(task.getUser().getId(),assignedTasksList);
    }

    public void update(Task task) {
        Task existingTask = tasks.get(task.getId());
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setPriority(task.getPriority());
            existingTask.setStatus(task.getStatus());
            if (existingTask.getUser() != task.getUser()) {
                deleteAssignedTask(existingTask);
                addAssignedTask(task);
            }
        } else {
            System.out.println("No task to update");
        }
    }

    public Task getTaskById(String id) {
        return tasks.get(id);
    }

    public void delete(String id) {
        Task task = tasks.remove(id);
        deleteAssignedTask(task);
    }

    private void deleteAssignedTask(Task task) {
        List<Task> userTasks = assignedTasks.get(task.getUser().getId());
        if (userTasks != null)
            userTasks.remove(task);
    }

    public void markComplete(String id) {
        Task task = tasks.get(id);
        if (task != null)
            task.setStatus(TaskStatus.COMPLETED);
    }

    public List<Task> getAllTasks(User user) {
        return assignedTasks.get(user.getId());
    }

    public List<Task> searchTasks(String task) {
        return tasks.values()
                    .stream()
                    .filter(t -> t.getTitle().contains(task) || t.getDescription().contains(task))
                    .toList();
    }

    public List<Task> filter(TaskStatus taskStatus, Date startDate, Date endDate, TaskPriority taskPriority) {
        return tasks.values().stream()
                .filter(t -> t.getPriority().equals(taskPriority)
                        && t.getStatus().equals(taskStatus)
                        && t.getDueDate().compareTo(startDate)>=0 && t.getDueDate().compareTo(endDate)<0)
                .toList();
    }
}

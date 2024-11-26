import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<Task>();

    public static void addNewTask(String description) {
       tasks = FileManager.loadTasks();
       Task newTask = new Task();

       newTask.setId(UUID.randomUUID().toString());
       newTask.setDescription(description);
       newTask.setStatus(TaskStatus.TODO);
       newTask.setCreatedAt(System.currentTimeMillis());

       tasks.add(newTask);
       FileManager.saveTasks(tasks);
    }

    public static List<Task> listTasks() {
        tasks = FileManager.loadTasks();
        if(tasks.isEmpty()) {
            throw new RuntimeException("No tasks loaded");
        }
        return tasks;
    }

    public static void deleteTask(Integer i) {
        Task task = getTaskbyIndex(i);
        String taskId = task.getId();
        tasks.removeIf(t-> t.getId().equals(taskId));
        FileManager.saveTasks(tasks);
    }
    public static Task getTaskbyIndex(Integer index) {
        tasks = FileManager.loadTasks();
        if (index >= 0 && index < tasks.size() ) {
            return tasks.get(index);
        } else {
            throw new RuntimeException("Index out of bounds");
        }
    }
}

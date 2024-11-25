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
        System.out.println("New task added: " + newTask.getDescription());
    }
}

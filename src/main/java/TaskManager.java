import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<Task>();

    public static void addNewTask(String description) {
       tasks = FileManager.loadTasks();
       Task newTask = new Task(UUID.randomUUID().toString(), description, TaskStatus.TODO, new Date(), new Date());
        tasks.add(newTask);
        FileManager.saveTasks(tasks);
        System.out.println("New task added: " + newTask.getDescription());
    }
}

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "src/main/java/data/tasks.json";

    public static List<Task> loadTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            return new ObjectMapper().readValue(br, new TypeReference<List<Task>>() {});
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveTasks(List<Task> tasks) {
        ObjectMapper objMapper = new ObjectMapper();

        try (BufferedWriter br = new BufferedWriter(new FileWriter(FILE_PATH))) {
            objMapper.writeValue(br, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Como usar: taskt-cli <comando> <parâmetros>");
            System.out.println("add: adiciona uma nova tarefa");
            System.out.println("list: lista as tarefas");
            System.out.println("remove: remover uma nova tarefa");
            return;
        }

        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("A tarefa precisa ter uma descrição! ");
                    break;
                }
                String desc = args[1];
                TaskManager.addNewTask(desc);
                System.out.println("Tarefa adicionada com sucesso!");
               break;
            case "list":
                List<Task> tasks = new ArrayList<Task>();
                tasks = TaskManager.listTasks();
                int index = 1;
                for (Task task : tasks) {
                    System.out.println(index + " Task: " + task.getDescription() + " Status: " + task.getStatus()) ;
                    index++;
                }
                break;
            case "remove":
                String strIndex = args[1];
                Integer indexRemove = Integer.parseInt(strIndex);
                indexRemove -= 1;
                TaskManager.deleteTask(indexRemove);
                tasks = TaskManager.listTasks();
                break;
            default:
                System.out.println("Comando inválido!");
        }


    }
}

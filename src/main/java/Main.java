import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            CLIHelper.printHelp();
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
            case "delete":
                String strIndex = args[1];
                Integer indexRemove = Integer.parseInt(strIndex);
                indexRemove -= 1;
                TaskManager.deleteTask(indexRemove);
                tasks = TaskManager.listTasks();
                break;
            case "mark":
                if (args.length < 2) {
                    System.out.println("Informe o ID da tarefa que será modificada");
                    break;
                }

                if (args.length < 3) {
                    System.out.println("Informe o Status");
                    break;
                }

                strIndex = args[1];
                indexRemove = Integer.parseInt(strIndex);
                indexRemove -= 1;

                TaskStatus status = TaskStatus.valueOf(args[2]);
                TaskManager.updateTaskStatus(indexRemove, status);
                break;
            case "update":
                if (args.length < 2) {
                    System.out.println("Informe o ID da tarefa que será modificada");
                    break;
                }

                if (args.length < 3) {
                    System.out.println("Insira a nova descrição");
                    break;
                }
                strIndex = args[1];
                indexRemove = Integer.parseInt(strIndex);
                indexRemove -= 1;

                TaskManager.updateTaskDesc(indexRemove, args[2]);

                System.out.println("Tarefa atualizada com sucesso!");
                TaskManager.listTasks();
                break;
            default:
                System.out.println("Comando inválido!");
        }


    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Como usar: taskt-cli <comando> <parâmetros>");
            System.out.println("add: adiciona uma nova tarefa");
            System.out.println("list: lista as tarefas");
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

               break;
            case "list":
                break;
            default:
                System.out.println("Comando inválido!");
        }


    }
}
